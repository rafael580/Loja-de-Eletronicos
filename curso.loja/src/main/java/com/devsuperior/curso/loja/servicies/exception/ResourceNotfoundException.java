package com.devsuperior.curso.loja.servicies.exception;

public class ResourceNotfoundException  extends RuntimeException{
    private static final Long serialVersionUID =1L;

    public ResourceNotfoundException(String msg){
        super(msg);
    }
}
