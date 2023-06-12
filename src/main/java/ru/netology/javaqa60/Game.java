package ru.netology.javaqa60;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName() == name) {
                return player;
            }
        }
        return null;
    }

    int result;

    public int findStrength(String name) {
        for (Player player : players) {
            if (player.getName() == name) {
                result = player.getStrength();
            }
        }
        return result;
    }

    public int round(String playerName1, String playerName2) {
        if (findByName(playerName1) == null) {
            throw new NotRegisteredException(
                    "Player with name: " + playerName1 + " not registered"
            );
        }
        if (findByName(playerName2) == null) {
            throw new NotRegisteredException(
                    "Player with name: " + playerName2 + " not registered"
            );
        }
        if (findStrength(playerName1) > findStrength(playerName2)) {
            return 1;
        } else if (findStrength(playerName1) < findStrength(playerName2)) {
            return 2;
        } else {
            return 0;
        }
    }

}
