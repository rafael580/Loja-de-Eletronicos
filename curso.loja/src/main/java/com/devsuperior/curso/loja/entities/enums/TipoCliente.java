package com.devsuperior.curso.loja.entities.enums;

public enum TipoCliente {
    PESSOAFISICA(1,"Pessoa Física"),
    PESSOAJURIDICA(2,"Pessoa Jurídica");

    private Integer cod;
    private String descricao;

    private TipoCliente(int code,String descricao){
        this.cod =code;
        this.descricao =descricao;
    }

    public static TipoCliente toEnum(Integer code){
        if(code==null){
            return null;
        }
        for (TipoCliente x : TipoCliente.values()){
            if (code.equals(x.getCod())){
                return x;
            }
        }
        throw new IllegalArgumentException("Id invalid"+ code);
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }
}
