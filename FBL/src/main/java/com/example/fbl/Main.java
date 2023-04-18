package com.example.fbl;


import com.example.fbl.model.Tecnic;

import java.util.ArrayList;
public class Main {
    public static void main(String[] args){
        ArrayList<Tecnic> tecnicos = new ArrayList<Tecnic>();
        tecnicos.add(new Tecnic(14));
        System.out.println(tecnicos.toString());

    }

}
