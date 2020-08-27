package com.bento.fullstack.service;

import com.bento.fullstack.entities.Produto;

import java.util.List;

public interface IProdutoService {

    List<Produto> findAll();
}
