package com.bento.fullstack.persistence;

import com.bento.fullstack.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoDAO extends JpaRepository<Produto, Long> {
}
