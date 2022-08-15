package src.main.models;

import java.util.HashMap;

public class Game {
    private HashMap<Team, Integer> scoreboard;
    private static int gameCount;

    public Game(Team home, Team away){
        this.scoreboard = new HashMap<Team, Integer>();
        this.scoreboard.put(new Team(home), 0);
        this.scoreboard.put(new Team(away), 0);
        gameCount++;
    }
    
    public Integer getScore(Team team){
        return this.scoreboard.get(team);
    }

    public void setScore(Team team, Integer score){
        this.scoreboard.put(team, score);
    }

    public Team getTeam(String name){
        return
        this.scoreboard.keySet().stream()
        .filter((key) -> key.getHouse().equals(name))
        .findFirst()
        .orElse(null);
    }

    public static int getGameCount() {
        return gameCount;
    }

    // Testing functions

    public String getPlaceholder(String play){
        return play.substring(play.indexOf("<") + 1,play.indexOf(">"));
    }

    public String replacePlaceholder(String play, String placeholder, String value){
        return play.replace("<" + placeholder + ">", value);
    }

}
