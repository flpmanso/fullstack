package com.bento.fullstack.controller;

import com.bento.fullstack.entities.Produto;
import com.bento.fullstack.service.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Api(value = "Produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @ApiOperation(value = "Mostrar todos os produtos")
    @GetMapping("/produtos")
    public List<Produto> findAll() {
        return produtoService.findAll();
    }

    @ApiOperation(value = "Mostrar produto informado")
    @GetMapping("/produto/{id}")
    public Produto findProduto(@PathVariable long id) throws Exception {
        Optional<Produto> produto = produtoService.findProduto(id);

        if (produto.isPresent()) {
            return produto.get();
        } else {
            throw new ProdutoNotFoundException();
        }
    }

    @ApiOperation(value = "Deletar Produto informado")
    @DeleteMapping("/produto/{id}")
    public void deleteProduto(@PathVariable long id) {
        Optional<Produto> produto = produtoService.findProduto(id);

        if (produto.isEmpty()) {
            throw new ProdutoNotFoundException();
        }
        produtoService.deleteProduto(id);
    }

    @ApiOperation(value = "Adicionar novo produto")
    @PostMapping("/produto")
    public ResponseEntity<Object> createProduto(@RequestBody Produto produto) {
        return produtoService.createProduto(produto);
    }

    @ApiOperation(value = "Alterar produto informado")
    @PutMapping("/produto/{id}")
    public ResponseEntity<Object> updateProduto(@RequestBody Produto produto, @PathVariable long id) {
        Optional<Produto> produtoOptional = produtoService.findProduto(id);

        if (produtoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return produtoService.updateProduto(produto, id);
    }
}
