import models.Field;
import models.Figure;
import models.Game;
import models.Player;
import view.ConsoleView;

public class XOCLI {
    public static void main(String[] args) {
        String name1 = "Dima";
        String name2 = "Olga";

        Player [] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2,Figure.O);


        Game game = new Game(players,new Field(3),"XO");

        ConsoleView consoleView = new ConsoleView();
        consoleView.show(game);
        while (consoleView.move(game)) {
            consoleView.show(game);
        }

    }
}
