package ru.netology.javaqa60;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    Player player1 = new Player(
            11,
            "Паша",
            10
    );

    Player player2 = new Player(
            12,
            "Каша",
            20
    );

    Player player3 = new Player(
            13,
            "Саша",
            5
    );

    Player player4 = new Player(
            14,
            "Даша",
            10
    );

    @Test
    public void shouldGetId() {

        int expected = 11;
        int actual = player1.getId();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetId() {

        player1.setId(111);

        int expected = 111;
        int actual = player1.getId();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetStrength() {

        int expected = 10;
        int actual = player1.getStrength();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetStrength() {

        player1.setStrength(11);

        int expected = 11;
        int actual = player1.getStrength();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldGetName() {

        String expected = "Паша";
        String actual = player1.getName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldSetName() {

        player1.setName("Маша");

        String expected = "Маша";
        String actual = player1.getName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinPlayerOne() {
        Game game = new Game();

        game.register(player1);
        game.register(player3);

        int expected = 1;
        int actual = game.round("Паша", "Саша");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinPlayerTwo() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Паша", "Каша");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldDraw() {
        Game game = new Game();

        game.register(player1);
        game.register(player4);

        int expected = 0;
        int actual = game.round("Паша", "Даша");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPlayerOneNotRegistered() {
        Game game = new Game();

        game.register(player4);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Паша", "Даша");
        });
    }

    @Test
    public void shouldPlayerTwoNotRegistered() {
        Game game = new Game();

        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Паша", "Даша");
        });
    }
}
