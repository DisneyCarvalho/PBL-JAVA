package com.example.fbl.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OutroCompTest {

    @Test
    void retiraItem() {
        OutroComp tat = new OutroComp(15,14,90);

        OutroComp nova = tat.retiraItem(6);
        OutroComp tee = nova.retiraItem( 9);
        assertEquals(6,nova.getQuantidade());
        assertEquals(9,tat.getQuantidade());
        assertNull(tee);



    }
}