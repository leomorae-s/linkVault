package com.moraes.LinkVault.link;


import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepository extends JpaRepository<LinkModel, Integer>{
    
    Page<LinkModel> findAll(Pageable pageable);

}
