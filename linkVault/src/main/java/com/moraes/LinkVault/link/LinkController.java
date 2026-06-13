package com.moraes.LinkVault.link;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moraes.LinkVault.link.dto.LinkRequestDTO;
import com.moraes.LinkVault.link.dto.LinkResponseDTO;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public LinkController(LinkService service) {
        this.service = service;
    }
    

    @PostMapping(value = "/save", version = "1.0")
    public ResponseEntity<URI> save(@RequestBody @Valid LinkRequestDTO dto) {
        
        logger.info("Requisição post recebida: {}", dto);
        LinkResponseDTO created = service.save(dto);
        URI uri = URI.create("/link/"+created.id());
        logger.info( "Requisição processada");
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<LinkResponseDTO>> getAllLinks(Pageable pageable) {

        return ResponseEntity.ok().body(service.getAll(pageable));
    }

    @GetMapping(value = "/{id}", version = "1.0")
    public ResponseEntity<LinkResponseDTO> getMethodName(@PathVariable Integer id) {

        logger.info("Requisição get recebida, id: {} ", id);
        return ResponseEntity.ok(service.getLinkById(id));
    }
    
    @DeleteMapping(value = "/delete/{id}", version = "1.0")
    public ResponseEntity<String> deleteLink(@PathVariable Integer id) {

        logger.info("Requisição delete recebida, id: {}", id);
        service.deleteById(id);

        return ResponseEntity.status(204).build();
    }

    @PutMapping(value = "/{id}", version = "1.0")
    public ResponseEntity<LinkResponseDTO> update(@PathVariable Integer id, @RequestBody LinkRequestDTO link) {
        
        logger.info("Requisição recbida, id: {} ",id);

        return ResponseEntity.ok(service.update(link, id));
        
    }
    
    

}
