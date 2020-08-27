package com.bento.fullstack.service;

import com.bento.fullstack.entities.Produto;
import com.bento.fullstack.persistence.ProdutoDAO;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoDAO produtoDAO;

    public List<Produto> findAll() {
        return produtoDAO.findAll();
    }

    public Optional<Produto> findProduto(Long id) {
            return produtoDAO.findById(id);
    }

    public void deleteProduto(Long id) {
            produtoDAO.deleteById(id);
    }

    public ResponseEntity<Object> createProduto(Produto produto) {
        Produto salvo = produtoDAO.save(produto);
        URI local = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(salvo.getId()).toUri();
        return ResponseEntity.created(local).build();
    }

    public ResponseEntity<Object> updateProduto(Produto produto, long id) {
        produto.setId(id);
        produtoDAO.save(produto);
        return ResponseEntity.noContent().build();
    }
}
