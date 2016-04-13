/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Player;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Omar Elfarouk
 */
public class PlayerController {
    String playerName;
    Player player ;//= new Player();;
    Timer timer = new Timer();
    int index = 0;
    boolean walk = false;
    final Image[] moved = {new javax.swing.ImageIcon(getClass().getResource("move1Plate.png")).getImage(),
            new javax.swing.ImageIcon(getClass().getResource("move2Plate.png")).getImage(),
            new javax.swing.ImageIcon(getClass().getResource("move3Plate.png")).getImage()
        };
    public PlayerController(String playerName){
        timer.scheduleAtFixedRate(new Picture(), 100, 100);
        this.playerName = playerName;
        this.player = new Player();
        this.player.setPlayerName(playerName);
    }
    
    public int getxPosition(){
        return player.getxPosition();
    }
    
    public Image getImage(){
        return player.getPicture();
    }
    
    public void setImage(Image image){
        player.setPicture(image);
    }
    
    public void keyPressed(int keyCode) {
        if ( playerName.equalsIgnoreCase("one") ){
            if ( keyCode == KeyEvent.VK_RIGHT ){
                for ( int i = 0; i<10 ;i++)
            player.setxPosition(player.getxPosition()+1);
                walk = true;
            }
            else if ( keyCode == KeyEvent.VK_LEFT ){
            player.setxPosition(player.getxPosition()-10);
            walk = true;
            }
        }
        
    }

    public void mouseMove(int x) {
        if ( playerName.equalsIgnoreCase("two") ){
            player.setxPosition(x);
        }    
        walk = true;
    }

    public void stop() {
        walk = false;
    }
    
    class Picture extends TimerTask{

        @Override
        public void run() {
            if ( walk ){
            setImage(moved[index]);
            index++;
            if ( index == 3 )
                index = 0;
            }
        }
        
    }
    
}
