package controllers;

import models.Field;
import models.Figure;
import models.exceptions.InvalidPointException;

import java.awt.*;

public class WinnerController {
    public Figure getWinner(Field field){
        try {
            for (int i = 0; i < 3; i++){
                if(check(field, new Point(i,0), p -> new Point(p.x, p.y + 1)))
                  return field.getFigure(new Point(i,0));
            }

            for (int i = 0; i < 3; i++){
                if(check(field, new Point(i,0), p -> new Point(p.x + 1, p.y)))
                    return field.getFigure(new Point(i,0));
            }

            if(check(field, new Point(0,0), p -> new Point(p.x + 1, p.y +1)))
                return field.getFigure(new Point(0,0));

            if(check(field, new Point(0,2), p -> new Point(p.x + 1, p.y -1)))
                return field.getFigure(new Point(1,1));

        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return null;
    }
    private boolean check(Field field, Point currentPoint, IPointGenerator pointGenerator ) {
        Figure currentFigure;
        Figure nextFigure;
        Point nextPoint = pointGenerator.next(currentPoint);
        try {
            currentFigure = field.getFigure(currentPoint);
            nextFigure = field.getFigure(currentPoint);
        } catch (InvalidPointException e) {
            return true;
        }
        if (currentFigure == null) return false;

        if (currentFigure != nextFigure) return false;

        return check(field, nextPoint, pointGenerator);

    }
        private interface IPointGenerator{
        Point next(Point point);
        }
}
