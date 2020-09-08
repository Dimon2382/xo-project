package tect.dima.xo.model;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @org.junit.jupiter.api.Test
    void getName() {
        String inputValue = "Dima";
        String expectedValue = inputValue;

        Player player = new Player(inputValue,null);

        String actualValue = player.getName();

        assertEquals(expectedValue,actualValue);
    }

    @org.junit.jupiter.api.Test
    void getFigure() {
        Figure inputValue = Figure.X;
        Figure expectedValue = inputValue;

        Player player = new Player(null,inputValue);

        Figure actualValue = player.getFigure();

        assertEquals(expectedValue,actualValue);
    }
}
