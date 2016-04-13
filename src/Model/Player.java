package Model;

import java.awt.Image;
import java.util.ArrayList;

public class Player {
    private String PlayerName;
    private int xPosition;
    private ArrayList<Shapes> rightHandPocket;
    private ArrayList<Shapes> leftHandPocket;
    private Score score;
    private Image picture;

    public void setPlayerName(String PlayerName) {
        this.PlayerName = PlayerName;
    }

    public Player() {
        score = new Score();
        xPosition = 100;
//        picture = new javax.swing.ImageIcon(getClass().getResource("PlayerOne.jpg")).getImage();
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public ArrayList<Shapes> getRightHandPocket() {
        return rightHandPocket;
    }

    public void setRightHandPocket(ArrayList<Shapes> rightHandPocket) {
        this.rightHandPocket = rightHandPocket;
    }

    public ArrayList<Shapes> getLeftHandPocket() {
        return leftHandPocket;
    }

    public void setLeftHandPocket(ArrayList<Shapes> leftHandPocket) {
        this.leftHandPocket = leftHandPocket;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public Image getPicture() {
        return picture;
    }

    public void setPicture(Image picture) {
        this.picture = picture;
    }
    
}
