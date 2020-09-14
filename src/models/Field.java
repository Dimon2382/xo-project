package models;

import models.exceptions.InvalidPointException;
import models.exceptions.AlreadyOccupaiedException;


import java.awt.*;

public class Field {
    private static final int FIELD_SIZE = 3;

    private static int MIN_COORDINATE = 0;

    private static int MAX_COORDINATE = FIELD_SIZE;

    private Figure [][] field = new Figure[FIELD_SIZE][FIELD_SIZE];

    public int getSize(){
        return FIELD_SIZE;
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
        return checkCoordinate(point.x) && checkCoordinate(point.y);
    }
    private boolean checkCoordinate(int coordinate){
        return coordinate >= MIN_COORDINATE && coordinate < MAX_COORDINATE;
    }
}
