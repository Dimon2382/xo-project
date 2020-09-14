package controllers;

import models.Field;
import models.Figure;
import models.exceptions.AlreadyOccupaiedException;
import models.exceptions.InvalidPointException;

import java.awt.*;

public class MoveController {
    public void applyFigure(Field field, Point point, Figure figure) throws InvalidPointException, AlreadyOccupaiedException {
        if(field.getFigure(point) != null){
            throw new AlreadyOccupaiedException();
        }
        field.setFigure(point,figure);

    }
}
