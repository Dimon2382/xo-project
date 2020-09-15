package view;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import controllers.CurrentMoveController;
import controllers.MoveController;
import controllers.WinnerController;
import models.Field;
import models.Figure;
import models.Game;
import models.exceptions.AlreadyOccupaiedException;
import models.exceptions.InvalidPointException;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {
    private CurrentMoveController currentMoveController = new CurrentMoveController();

    private WinnerController winnerController =new WinnerController();

    private MoveController moveController = new MoveController();
    public void show(Game game){
        System.out.format("Game name: %s\n", game.getName());
        Field field = game.getField();
        for (int x = 0; x < field.getSize() ; x++) {
            if(x != 0) printSeparator();
            printLine(field, x);
        }

    }

    public boolean move(Game game){
        Field field = game.getField();
        Figure winner = winnerController.getWinner(field);
        if (winner != null) {
            System.out.format("Winner is %s\n ", winner);
            return false;
        }
        Figure currentFigure = currentMoveController.currentMove(field);
        if(currentFigure == null){
                System.out.println("No winner, no moves left");
                return false;
        }
        System.out.format("Please enter move point for: %s\n",currentFigure);
        Point point = askPoint();
        try {
            moveController.applyFigure(field,point,currentFigure);
        } catch (InvalidPointException | AlreadyOccupaiedException e) {
            System.out.println("Point is invalid");
        }
        return true;
    }
    private Point askPoint(){
        return new Point(askCoordinate("X")-1,askCoordinate("Y")-1);
    }

    private int askCoordinate(String coordinateName){
        System.out.format("Please input %s ", coordinateName);
        Scanner in = new Scanner(System.in);
        try {
            return in.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Enter valid point");
            return askCoordinate(coordinateName);
        }
    }

    private void printLine(Field field, int x) {
        for (int y = 0; y < field.getSize(); y++) {
            if(y != 0) System.out.print("|");
            System.out.print(" ");
            Figure figure;
            try {
                figure = field.getFigure(new Point(y, x));
            } catch (InvalidPointException e){
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.print(figure != null ? figure : " ");
            System.out.print(" ");
        }
        System.out.println();
    }
    private void printSeparator(){
        System.out.println("-----------");
    }
}
