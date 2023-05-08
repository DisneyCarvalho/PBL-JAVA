package com.example.fbl.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompCompTest {

    @Test
    void retiraItem() {
        CompComp tat = new CompComp(15,14,90);

        CompComp nova = tat.retiraItem(6);
        CompComp tee = nova.retiraItem( 9);
        assertEquals(6,nova.getQuantidade());
        assertEquals(9,tat.getQuantidade());
        assertNull(tee);


    }
}