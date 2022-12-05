package com.example.demo;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

class GameScene{
    public static int GRID = 4;
    public static boolean boardCheck = false;
    private static int HEIGHT = 700;
    static int distanceBetweenCells = 10;
    static double  LENGTH = (HEIGHT - ((GRID + 1) * distanceBetweenCells)) / (double) GRID;;
    private TextMaker textMaker = TextMaker.getSingleInstance();
    private Cell[][] cells = new Cell[GRID][GRID];
    private Group root;
    private static long score = 0;



     static void setGRID(int number) { //Most likely for mode changing
        GRID = number;
        LENGTH = (HEIGHT - ((GRID + 1) * distanceBetweenCells)) / (double) GRID;
    }

    static double getLENGTH() {
        return LENGTH;
    }

    static double getScore() {
        return score;
    }

    /**
     * Random number generator
     * @param turn
     */
    private void randomFillNumber(int turn) {

        Cell[][] emptyCells = new Cell[GRID][GRID];
        int a = 0;
        int b = 0;
        int aForBound=0,bForBound=0;
        outer:
        for (int i = 0; i < GRID; i++) {
            for (int j = 0; j < GRID; j++) {
                if (cells[i][j].getNumber() == 0) { // if the cell is empty, copy it into emptyCells
                    emptyCells[a][b] = cells[i][j];
                    if (b < GRID -1) {
                        bForBound=b;
                        b++;

                    } else {
                        aForBound=a;
                        a++;
                        b = 0;
                        if(a== GRID)
                            break outer;

                    }
                }
            }
        }


/**
 * Determines whether the randomly spawned cell is a 2 or 4
 */
        Text text;
        Random random = new Random();
        boolean putTwo = true;
        if (random.nextInt() % 2 == 0)
            putTwo = false;
        int xCell, yCell;
            xCell = random.nextInt(aForBound+1);
            yCell = random.nextInt(bForBound+1);
        if (putTwo) {
            text = textMaker.madeText("2", emptyCells[xCell][yCell].getX(), emptyCells[xCell][yCell].getY(), root);
            emptyCells[xCell][yCell].setTextClass(text);
            root.getChildren().add(text);
            emptyCells[xCell][yCell].setColorByNumber(2);
        } else {
            text = textMaker.madeText("4", emptyCells[xCell][yCell].getX(), emptyCells[xCell][yCell].getY(), root);
            emptyCells[xCell][yCell].setTextClass(text);
            root.getChildren().add(text);
            emptyCells[xCell][yCell].setColorByNumber(4);
        }
    }

    /**
     * Used to check whether there are empty cells, whether 2048 has been achieved, or whether there are no empty cells
     * @return
     */
    private int  haveEmptyCell() {
        for (int i = 0; i < GRID; i++) {
            for (int j = 0; j < GRID; j++) {
                if (cells[i][j].getNumber() == 0)
                    return 1;
                if(cells[i][j].getNumber() == 2048)
                    return 0;
            }
        }
        return -1;
    }

    private int passDestination(int i, int j, char direct) {
        int coordinate = j;
        if (direct == 'l') {
            for (int k = j - 1; k >= 0; k--) {
                if (cells[i][k].getNumber() != 0) {
                    coordinate = k + 1;
                    break;
                } else if (k == 0) {
                    coordinate = 0;
                }
            }
            return coordinate;
        }
        coordinate = j;
        if (direct == 'r') {
            for (int k = j + 1; k <= GRID - 1; k++) {
                if (cells[i][k].getNumber() != 0) {
                    coordinate = k - 1;
                    break;
                } else if (k == GRID - 1) {
                    coordinate = GRID - 1;
                }
            }
            return coordinate;
        }
        coordinate = i;
        if (direct == 'd') {
            for (int k = i + 1; k <= GRID - 1; k++) {
                if (cells[k][j].getNumber() != 0) {
                    coordinate = k - 1;
                    break;

                } else if (k == GRID - 1) {
                    coordinate = GRID - 1;
                }
            }
            return coordinate;
        }
        coordinate = i;
        if (direct == 'u') {
            for (int k = i - 1; k >= 0; k--) {
                if (cells[k][j].getNumber() != 0) {
                    coordinate = k + 1;
                    break;
                } else if (k == 0) {
                    coordinate = 0;
                }
            }
            return coordinate;
        }
        return -1;
    }

    private void moveLeft() {
        for (int i = 0; i < GRID; i++) {
            for (int j = 1; j < GRID; j++) {
                moveHorizontally(i, j, passDestination(i, j, 'l'), -1);
            }
            for (int j = 0; j < GRID; j++) {
                cells[i][j].setModify(false);
            }
        }
    }

    private void moveRight() {
        for (int i = 0; i < GRID; i++) {
            for (int j = GRID - 1; j >= 0; j--) {
                moveHorizontally(i, j, passDestination(i, j, 'r'), 1);
            }
            for (int j = 0; j < GRID; j++) {
                cells[i][j].setModify(false);
            }
        }
    }

    private void moveUp() {
        for (int j = 0; j < GRID; j++) {
            for (int i = 1; i < GRID; i++) {
                moveVertically(i, j, passDestination(i, j, 'u'), -1);
            }
            for (int i = 0; i < GRID; i++) {
                cells[i][j].setModify(false);
            }
        }

    }

    private void moveDown() {
        for (int j = 0; j < GRID; j++) {
            for (int i = GRID - 1; i >= 0; i--) {
                moveVertically(i, j, passDestination(i, j, 'd'), 1);
            }
            for (int i = 0; i < GRID; i++) {
                cells[i][j].setModify(false);
            }
        }

    }

    private boolean isValidDesH(int i, int j, int des, int sign) {
        if (des + sign < GRID && des + sign >= 0) {
            if (cells[i][des + sign].getNumber() == cells[i][j].getNumber() && !cells[i][des + sign].getModify()
                    && cells[i][des + sign].getNumber() != 0) {
                return true;
            }
        }
        return false;
    }

    private void moveHorizontally(int i, int j, int des, int sign) {
        if (isValidDesH(i, j, des, sign)) {
            cells[i][j].adder(cells[i][des + sign]);
            cells[i][des].setModify(true);
        }
        else if (des != j) {
            cells[i][j].changeCell(cells[i][des]);
        }
    }

    private boolean isValidDesV(int i, int j, int des, int sign) {
        if (des + sign < GRID && des + sign >= 0)
            if (cells[des + sign][j].getNumber() == cells[i][j].getNumber() && !cells[des + sign][j].getModify()
                    && cells[des + sign][j].getNumber() != 0) {
                return true;
            }
        return false;
    }

    private void moveVertically(int i, int j, int des, int sign) {
        if (isValidDesV(i, j, des, sign)) {
            cells[i][j].adder(cells[des + sign][j]);
            cells[des][j].setModify(true);
        } else if (des != i) {
            cells[i][j].changeCell(cells[des][j]);
        }
    }

    /**
     * Checks whether the cell beside has the same number
     * @param i
     * @param j
     * @return
     */

    private boolean haveSameNumberNearly(int i, int j) {
        if (i < GRID - 1 && j < GRID - 1) {
            if (cells[i + 1][j].getNumber() == cells[i][j].getNumber())
                return true;
            if (cells[i][j + 1].getNumber() == cells[i][j].getNumber())
                return true;
        }
        else if (i > 0 && j > 0) {
            if (cells[i - 1][j].getNumber() == cells[i][j].getNumber())
                return true;
            if (cells[i][j - 1].getNumber() == cells[i][j].getNumber())
                return true;
        }
        return false;
    }

    /**
     * Determines whether the cell can move or not
     * @return
     */
    private boolean canNotMove() {
        for (int i = 0; i < GRID; i++) {
            for (int j = 0; j < GRID; j++) {
                if (haveSameNumberNearly(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Update Score
     */
    private void updateScore() {
        score += Cell.temp_score;
        Cell.temp_score = 0;
    }

    void game(Scene gameScene, Group root, Stage primaryStage, Scene endGameScene, Group endGameRoot) {
        this.root = root;
        for (int i = 0; i < GRID; i++) {
            for (int j = 0; j < GRID; j++) {
                cells[i][j] = new Cell((j) * LENGTH + (j + 1) * distanceBetweenCells,
                        (i) * LENGTH + (i + 1) * distanceBetweenCells, LENGTH, root);
            }

        }

        Text text = new Text();
        root.getChildren().add(text);
        text.setText("SCORE :");
        text.setFont(Font.font(30));
        text.relocate(750, 100);
        Text scoreText = new Text();
        root.getChildren().add(scoreText);
        scoreText.relocate(750, 150);
        scoreText.setFont(Font.font(20));
        scoreText.setText("0");

        randomFillNumber(1);
        randomFillNumber(1);

        /**
         * Controls
         */
        gameScene.addEventHandler(KeyEvent.KEY_PRESSED, key ->{
                Platform.runLater(() -> {
                    int haveEmptyCell;
                    if (key.getCode() == KeyCode.DOWN) {
                        GameScene.this.moveDown();
                    } else if (key.getCode() == KeyCode.UP) {
                        GameScene.this.moveUp();
                    } else if (key.getCode() == KeyCode.LEFT) {
                        GameScene.this.moveLeft();
                    } else if (key.getCode() == KeyCode.RIGHT) {
                        GameScene.this.moveRight();
                    } else{
                        throw new RuntimeException("Invalid Key");
                    }

                    /**
                     * Sum up the score
                     */
                    GameScene.this.updateScore();
                    scoreText.setText(score + "");
                    haveEmptyCell = GameScene.this.haveEmptyCell();
                    /**
                     * If there are no more empty cells, and you cant move, end game
                     */
                    if (haveEmptyCell == -1) {
                        if (GameScene.this.canNotMove()) {
                            try {
                                Pane gameOverPane = (Pane) FXMLLoader.load(getClass().getResource("LoseScreen.fxml"));
                                primaryStage.setScene(new Scene(gameOverPane));
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            //EndController ObjScore = new EndController();
                            //ObjScore.getScore(score);
                        }
                    } else if(haveEmptyCell == 1){
                        GameScene.this.randomFillNumber(2);
                    }
                });
            });
    }
}
