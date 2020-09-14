package models;

import org.junit.jupiter.api.Test;
import models.exceptions.AlreadyOccupaiedException;
import models.exceptions.InvalidPointException;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    @Test
    void testGetSize() {
        Field field = new Field();

        assertEquals(3, field.getSize());
    }

    @Test
    void testSetFigure() throws InvalidPointException, AlreadyOccupaiedException {
        Field field = new Field();
        Point inputPoint = new Point(0, 0);
        Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);
        Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure, actualFigure);
    }

    @Test
    void testGetFigureWhenFigureIsNotSet() throws Exception {
        Field field = new Field();
        Point inputPoint = new Point(0, 0);

        Figure actualFigure = field.getFigure(inputPoint);

        assertNull(actualFigure);
    }

    @Test
    void testGetFigureWhenXIsLessThenZero() throws Exception {
        Field field = new Field();
        Point inputPoint = new Point(-1, 0);
        try {
            field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e) {

        }

    }

    @Test
    void testGetFigureWhenXIsMoreThenSize() throws Exception {
        Field field = new Field();
        Point inputPoint = new Point(field.getSize() + 1, 0);
        try {
            field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e) {

        }
    }
    @Test
    void testGetFigureWhenYIsMoreThenSize() throws Exception {
        Field field = new Field();
        Point inputPoint = new Point(0, field.getSize() + 1);
        try {
            field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e) {

        }
    }

    }

