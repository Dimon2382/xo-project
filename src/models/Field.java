package models;

import models.exceptions.InvalidPointException;
import models.exceptions.AlreadyOccupaiedException;


import java.awt.*;

public class Field {

    private static int MIN_COORDINATE = 0;

    private Figure [][] field;

    private int fieldSize;

    public Field(int fieldSize) {
        this.fieldSize = fieldSize;
        field = new Figure[fieldSize][fieldSize];
    }

    public int getSize(){
        return fieldSize;
    }

    public Figure getFigure(Point point) throws InvalidPointException {
        if(!checkPoint(point)){
            throw new InvalidPointException();
        }
        return field[point.x][point.y];
    }

    public void setFigure(Point point, Figure figure) throws InvalidPointException {
        if(!checkPoint(point)){
            throw new InvalidPointException();
        }

        field[point.x][point.y] = figure;
    }
// check valid coordinates
    private boolean checkPoint(Point point){
        return checkCoordinate(point.x, field.length) && checkCoordinate(point.y, field[point.x].length);
    }
    private boolean checkCoordinate(int coordinate, int maxCoordinate){
        return coordinate >= MIN_COORDINATE && coordinate < field.length;
    }
}
