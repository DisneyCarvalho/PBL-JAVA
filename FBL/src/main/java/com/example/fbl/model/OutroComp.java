package com.example.fbl.model;

import java.io.Serializable;

public class OutroComp extends Componentes implements Serializable {
    String descricao;


    public OutroComp(int quantidade, float custo, float preco) {
        super(quantidade, custo, preco);
    }


    /**
     * retira um item e retorna um objeto com o numero de itens que foi retirado.
     * @param quantidade
     * @return
     */
    public OutroComp retiraItem(int quantidade){
        if (getQuantidade() >= quantidade){
            setQuantidade(getQuantidade()-quantidade);
            OutroComp outrocomp = new OutroComp(quantidade,getCusto(),getPreco());
            return outrocomp;
        }
        return null;
    }
}



