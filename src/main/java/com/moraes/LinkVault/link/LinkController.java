package com.moraes.LinkVault.link;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moraes.LinkVault.link.dto.LinkRequestDTO;
import com.moraes.LinkVault.link.dto.LinkResponseDTO;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.net.URI;
import java.util.List;
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
    public ResponseEntity<URI> save(@RequestBody LinkRequestDTO dto) {
        
        try{
            LinkResponseDTO created = service.save(dto);
            URI uri = URI.create("/link/"+created.id());
            return ResponseEntity.created(uri).build();
        } catch(Exception e) {

            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<LinkResponseDTO>> getAllLinks() {
        return ResponseEntity.ok().body(service.getAll());
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

    @PutMapping("link/{id}")
    public ResponseEntity<LinkResponseDTO> update(@PathVariable Integer id, @RequestBody LinkRequestDTO link) {
        
        
        return ResponseEntity.ok(service.update(link, id));
        
    }
    
    

}
