package com.bento.fullstack.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Produto não existe na base de dados")
public class ProdutoNotFoundException extends RuntimeException{


}
