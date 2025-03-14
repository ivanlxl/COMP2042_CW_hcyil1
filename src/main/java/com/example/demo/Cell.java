package com.example.demo;


import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * Creates each individual cell
 */
public class Cell {
    private Rectangle rectangle;
    private Group root;
    private Text textClass;
    static boolean modify = false;
    static long temp_score = 0;
    static boolean spawn = false; //Checks whether a cell has been added together or a cell is moved


    void setModify(boolean modify) {
        this.modify = modify;
    }

    boolean getModify() {
        return modify;
    }

    /**
     *Constructor name for Cell
     * @param x width
     * @param y height
     * @param scale
     * @param root
     */
    Cell(double x, double y, double scale, Group root) {
        rectangle = new Rectangle();
        rectangle.setX(x);
        rectangle.setY(y);
        rectangle.setHeight(scale);
        rectangle.setWidth(scale);
        this.root = root;
        rectangle.setFill(Color.rgb(224, 226, 226, 0.5));
        this.textClass = TextMaker.getSingleInstance().madeText("0", x, y, root);
        root.getChildren().add(rectangle);
    }

    void setTextClass(Text textClass) {
        this.textClass = textClass;
    }

    /**
     * Updates the numbering of the cell once they move
     * @param cell
     */
    void changeCell(Cell cell) {
        TextMaker.changeTwoText(textClass, cell.getTextClass());
        root.getChildren().remove(cell.getTextClass());
        root.getChildren().remove(textClass); //Removes the 0 that would appear in the cell

        if (!cell.getTextClass().getText().equals("0")) { //if the cell is not 0, put the number
            root.getChildren().add(cell.getTextClass());
            spawn = true;
        }
        if (!textClass.getText().equals("0")) {
            root.getChildren().add(textClass);
        }
        setColorByNumber(getNumber());
        cell.setColorByNumber(cell.getNumber());
    }

    /**
     * Handles adding the value of each cell
     * @param cell
     */
    void adder(Cell cell) {
        cell.getTextClass().setText((cell.getNumber() + this.getNumber()) + "");//Adds the 2 numbers
        textClass.setText("0"); //When 2 cells are added, one of the cell needs to be made 0
        spawn = true;
        root.getChildren().remove(textClass);
        cell.setColorByNumber(cell.getNumber());
        setColorByNumber(getNumber());
        temp_score += (cell.getNumber() + this.getNumber());
    }

    /**
     * Setting each number tile to a specified colour
     * @param number
     */
    void setColorByNumber(int number) {
        switch (number) {
            case 0:
                rectangle.setFill(Color.rgb(224, 226, 226, 0.5));
                break;
            case 2:
                rectangle.setFill(Color.rgb(232, 255, 100, 0.5));
                break;
            case 4:
                rectangle.setFill(Color.rgb(232, 220, 50, 0.5));
                break;
            case 8:
                rectangle.setFill(Color.rgb(232, 200, 44, 0.8));
                break;
            case 16:
                rectangle.setFill(Color.rgb(232, 170, 44, 0.8));
                break;
            case 32:
                rectangle.setFill(Color.rgb(180, 120, 44, 0.7));
                break;
            case 64:
                rectangle.setFill(Color.rgb(180, 100, 44, 0.7));
                break;
            case 128:
                rectangle.setFill(Color.rgb(180, 80, 44, 0.7));
                break;
            case 256:
                rectangle.setFill(Color.rgb(180, 60, 44, 0.8));
                break;
            case 512:
                rectangle.setFill(Color.rgb(180, 30, 44, 0.8));
                break;
            case 1024:
                rectangle.setFill(Color.rgb(250, 0, 44, 0.8));
                break;
            case 2048:
                rectangle.setFill(Color.rgb(250,0,0,1));


        }

    }

    double getX() {
        return rectangle.getX();
    }

    double getY() {
        return rectangle.getY();
    }

    int getNumber() {
        return Integer.parseInt(textClass.getText());
    }

    private Text getTextClass() {
        return textClass;
    }

}
