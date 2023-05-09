package Ultilidades;

import com.example.fbl.model.OutroComp;
import dao.OutroComp.OutroCompListImpl;

import java.io.*;
import java.util.ArrayList;

public class Arquivo {


    /**
     * Abre o arquivo com seu nome e grava as informaçoes.
     * @param Lista
     * @param nome
     * @param <t>
     */
    public static <t> void gravar(ArrayList<t> Lista , String nome){

        try {
            ObjectOutputStream Objet = new ObjectOutputStream(new FileOutputStream(nome));
            Objet.writeObject(Lista);
            Objet.close();


        }catch (IOException e){
        }


    }


    /**
     * Abre o arquivo com o seu nome e ler os objetos.
     * @param nome
     * @return
     * @param <t>
     */
    public static <t> ArrayList<t> ler(String nome){

        try {
            File arq = new File(nome);
            if (!arq.exists()){
                gravar(new ArrayList<t>(),nome);
            }



            ObjectInputStream Nani = new ObjectInputStream(new FileInputStream(nome));
            ArrayList<t> lista = (ArrayList<t>)Nani.readObject();
            Nani.close();
            return  lista;
        }

        catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }



}
