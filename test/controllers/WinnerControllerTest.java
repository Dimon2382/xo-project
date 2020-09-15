package controllers;

import models.Field;
import models.Figure;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class WinnerControllerTest {

    @Test
    public void testGetWinnerWhenWinnerRow() throws Exception {
        WinnerController winnerController = new WinnerController();
        for (int i = 0; i < 3; i++) {
            Field field = new Field(3);
            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.X);
            field.setFigure(new Point(i, 2), Figure.X);
            assertEquals(Figure.X, winnerController.getWinner(field));
        }
    }


    @Test
    public void testGetWinnerWhenNoWinnerRow() throws Exception {
        WinnerController winnerController = new WinnerController();
        for (int i = 0; i < 3; i++) {
            Field field = new Field(3);
            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.X);
            field.setFigure(new Point(i, 2), Figure.O);
            assertNull(winnerController.getWinner(field));
        }

    }

    @Test
    public void testGetWinnerWhenNowWinnerColumn() throws Exception {
        WinnerController winnerController = new WinnerController();
        Field field = new Field(3);
        for (int i = 0; i < 3; i++) {
            field.setFigure(new Point(0, i), Figure.X);
            field.setFigure(new Point(1, i), Figure.X);
            field.setFigure(new Point(2, i), Figure.O);
        }
        assertEquals(Figure.X, winnerController.getWinner(field));
    }

    @Test
    public void testGetWinnerWhenNoWinnerColumn() throws Exception {
        WinnerController winnerController = new WinnerController();
        for (int i = 0; i < 3; i++) {
            Field field = new Field(3);
            field.setFigure(new Point(0, i), Figure.X);
            field.setFigure(new Point(1, i), Figure.X);
            field.setFigure(new Point(2, i), Figure.O);
            assertNull(winnerController.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenWinnerDiag1() throws Exception {
        WinnerController winnerController = new WinnerController();
        Field field = new Field(3);
        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 2), Figure.X);
        assertEquals(Figure.X, winnerController.getWinner(field));
    }


    @Test
    public void testGetWinnerWhenNoWinnerDiag1() throws Exception {
        WinnerController winnerController = new WinnerController();
        Field field = new Field(3);
        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 2), Figure.O);
        assertNull(winnerController.getWinner(field));
    }

    @Test
    public void testGetWinnerWhenWinnerDiag2() throws Exception {
        WinnerController winnerController = new WinnerController();
        Field field = new Field(3);
        field.setFigure(new Point(0, 2), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 0), Figure.X);
        assertEquals(Figure.X, winnerController.getWinner(field));
    }


    @Test
    public void testGetWinnerWhenNoWinnerDiag2() throws Exception {
        WinnerController winnerController = new WinnerController();
        Field field = new Field(3);
        field.setFigure(new Point(0, 2), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 0), Figure.O);
        assertNull(winnerController.getWinner(field));
    }

    @Test
    public void testGetWinnerWhenNoWinnerRow2() throws Exception {
        WinnerController winnerController = new WinnerController();
        for (int i = 0; i < 3; i++) {
            Field field = new Field(3);
            field.setFigure(new Point(i, 0), Figure.O);
            field.setFigure(new Point(i, 1), Figure.X);
            field.setFigure(new Point(i, 2), Figure.X);
            assertNull(winnerController.getWinner(field));
        }
    }
}
