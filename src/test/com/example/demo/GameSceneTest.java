package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class GameSceneTest {

    @Test
    void setGRID() {
        assertEquals(4, GameScene.GRID);
    }

    @Test
    void getLENGTH() {
        assertEquals(162.5, GameScene.getLENGTH());
    }

    @Test
    void getScore() {
        assertEquals(0.0, GameScene.getScore());
    }
}