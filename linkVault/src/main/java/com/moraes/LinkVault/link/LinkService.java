package com.moraes.LinkVault.link;



import com.moraes.LinkVault.exceptions.LinkNotFoundException;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import com.moraes.LinkVault.link.dto.LinkRequestDTO;
import com.moraes.LinkVault.link.dto.LinkResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LinkService {
    

    private final LinkRepository repository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public LinkService(LinkRepository repository) {
        this.repository = repository;
    }    

    @Transactional
    public LinkResponseDTO save(LinkRequestDTO dto) {


        logger.info("salvando objeto no banco de dados: {}", dto);
        LinkModel model = LinkModel.of(dto);

        LinkModel created = repository.save(model);

        return LinkResponseDTO.from(created);

    }

    @Transactional(readOnly = true)
    public Page<LinkResponseDTO> getAll(Pageable pageable) {
        
        return repository.findAll(pageable)
        .map(LinkResponseDTO::from);
         
    }
    

    @Transactional(readOnly = true)
    public LinkResponseDTO getLinkById(Integer id) {

        LinkModel returned = repository.findById(id)
        .orElseThrow(LinkNotFoundException::new);

        return LinkResponseDTO.from(returned);
    }

    @Transactional
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Transactional
    public LinkResponseDTO update(LinkRequestDTO dto, Integer id) {

        logger.info("atualizando objeto no banco de dados: {}", dto);

        LinkModel model = repository.findById(id).orElseThrow(LinkNotFoundException::new);

        model.update(dto.link(), dto.description());


        return LinkResponseDTO.from(model);


    }
    
}
