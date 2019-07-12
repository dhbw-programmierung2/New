package game;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String playerName;

    private String color;

    private List<Figure> figureList = new ArrayList<>();

    public void initPlayer(String localPlayerName, String localColor){
        setColor(localColor);
        setPlayerName(localPlayerName);
    }

    public String getPlayerName() {
        return playerName;
    }

    private void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getColor() {
        return color;
    }

    private void setColor(String color) {
        this.color = color;
    }

    public List<Figure> getFigureList() {
        return figureList;
    }


}
