package com.moraes.LinkVault.link;



import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import com.moraes.LinkVault.link.dto.LinkRequestDTO;
import com.moraes.LinkVault.link.dto.LinkResponseDTO;

import jakarta.persistence.EntityNotFoundException;

@Service
public class LinkService {
    

    private final LinkRepository repository;

    public LinkService(LinkRepository repository) {
        this.repository = repository;
    }    

    public LinkResponseDTO save(LinkRequestDTO dto) {

        
            LinkModel model = LinkModel.of(dto);

            LinkModel created =repository.save(model);

            return LinkResponseDTO.from(created);

    }

    public Page<LinkResponseDTO> getAll(Pageable pageable) {
        
        return repository.findAll(pageable)
        .map(LinkResponseDTO::from);
         
    }
    

    public LinkResponseDTO getLinkById(Integer id) {

        LinkModel returned = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Link não encontrado"));

        return LinkResponseDTO.from(returned);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public LinkResponseDTO update(LinkRequestDTO dto, Integer id) {

        LinkModel model = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());

        model.update(dto.link(), dto.description());

        repository.save(model);

        return LinkResponseDTO.from(model);


    }
    
}
