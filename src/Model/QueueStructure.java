/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Sherif
 */
public class QueueStructure {
    private  ArrayList<Shapes>horizontal;
    private  ArrayList<Shapes>vertical;
    private  int motion;
    private  int x;
    private  int y;
    public QueueStructure(ArrayList<Shapes>horizontal, ArrayList<Shapes>vertical, int motion, int x, int y){
        this.horizontal=horizontal;
        this.vertical=vertical;
        this.motion=motion;
        this.x=x;
        this.y=y;
        
    }

    public ArrayList<Shapes> getHorizontal() {
        return horizontal;
    }

    public void setHorizontal(ArrayList<Shapes> horizontal) {
        this.horizontal = horizontal;
    }

    public ArrayList<Shapes> getVertical() {
        return vertical;
    }

    public void setVertical(ArrayList<Shapes> vertical) {
        this.vertical = vertical;
    }

    public int getMotion() {
        return motion;
    }

    public void setMotion(int motion) {
        this.motion = motion;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public Iterator getInterator(){
        return new Iterator(horizontal, vertical);
    }
    
    
}
