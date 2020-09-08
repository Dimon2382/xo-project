package tect.dima.xo.model;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    @Test
    void getSize() {
        Field field = new Field();

        assertEquals(3, field.getSize());
    }

    @Test
    void setFigure() {
        Field field = new Field();
        Point inputPoint = new Point(0,0);
        Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);
        Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure, actualFigure);
}
}