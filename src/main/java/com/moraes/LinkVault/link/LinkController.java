package com.moraes.LinkVault.link;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moraes.LinkVault.link.dto.LinkRequestDTO;
import com.moraes.LinkVault.link.dto.LinkResponseDTO;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.net.URI;
import org.springframework.web.bind.annotation.PutMapping;







@RestController
@RequestMapping("/link")
public class LinkController {

    private final LinkService service;

    public LinkController(LinkService service) {
        this.service = service;
    }
    

    @GetMapping("/get")
    public ResponseEntity<String> getTeste() {
        return ResponseEntity.ok("Teste executado");
    }

    @PostMapping("/save")
    public ResponseEntity<URI> save(@RequestBody @Valid LinkRequestDTO dto) {
        
            LinkResponseDTO created = service.save(dto);
            URI uri = URI.create("/link/"+created.id());
            return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<LinkResponseDTO>> getAllLinks(Pageable pageable) {

        return ResponseEntity.ok().body(service.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LinkResponseDTO> getMethodName(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getLinkById(id));
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLink(@PathVariable Integer id) {
        service.deleteById(id);

        return ResponseEntity.ok("Link excluido com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<LinkResponseDTO> update(@PathVariable Integer id, @RequestBody LinkRequestDTO link) {
        
        
        return ResponseEntity.ok(service.update(link, id));
        
    }
    
    

}
