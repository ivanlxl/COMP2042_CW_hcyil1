package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    @Test
    void getModify() {
        assertEquals(false,Cell.modify);
    }
}