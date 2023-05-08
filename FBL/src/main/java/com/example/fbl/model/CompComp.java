package com.example.fbl.model;

public class CompComp extends Componentes{
    private String Nome;
    private String Fabricante;


    public CompComp(int quantidade, float custo, float preco) {
        super(quantidade, custo, preco);
    }


    /**
     * retira um item e retorna um objeto com o numero de itens que foi retirado.
     * @param quantidade
     * @return
     */

    public CompComp retiraItem(int quantidade){
        if (getQuantidade() >= quantidade){
            setQuantidade(getQuantidade()-quantidade);
            CompComp compcomp = new CompComp(quantidade,getCusto(),getPreco());
            return compcomp;
        }
        return null;
    }
}
