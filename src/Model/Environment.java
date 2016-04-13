/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Omar Elfarouk
 */
public class Environment {

    private static Environment singletonObject_Environment;
    private ArrayList<Shapes> horizontal1;
    private ArrayList<Shapes> vertical1;
    private int motion1;
    private int x1;
    private int y1;
    private ArrayList<Shapes> horizontal2;
    private ArrayList<Shapes> vertical2;
    private int motion2;
    private int x2;
    private int y2;
    private ArrayList<Shapes> horizontal3;
    private ArrayList<Shapes> vertical3;
    private int motion3;
    private int x3;
    private int y3;
    private ArrayList<Shapes> horizontal4;
    private ArrayList<Shapes> vertical4;
    private int motion4;
    private int x4;
    private int y4;
    QueueStructure queue1;
    QueueStructure queue2;
    QueueStructure queue3;
    QueueStructure queue4;

    private Environment(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        PlatesPool.getPlates();
        horizontal1 = new ArrayList<Shapes>();
        for (int i = 0; i < 16; i++) {
            horizontal1.add(PlatesPool.GetObject());
        }
        vertical1 = new ArrayList<Shapes>();
        motion1 = 1;
        this.x1 = x1;
        this.y1 = y1;

        horizontal2 = new ArrayList<Shapes>();
        for (int i = 0; i < 16; i++) {
            horizontal2.add(PlatesPool.GetObject());
        }
        vertical2 = new ArrayList<Shapes>();
        motion2 = 1;
        this.x2 = x2;
        this.y2 = y2;
        horizontal3 = new ArrayList<Shapes>();
        for (int i = 0; i < 11; i++) {
            horizontal3.add(PlatesPool.GetObject());
        }
        vertical3 = new ArrayList<Shapes>();
        motion3 = 1;
        this.x3 = x3;
        this.y3 = y3;
        horizontal4 = new ArrayList<Shapes>();
        for (int i = 0; i < 11; i++) {
            horizontal4.add(PlatesPool.GetObject());
        }
        vertical4 = new ArrayList<Shapes>();
        motion4 = 1;
        this.x4 = x4;
        this.y4 = y4;
        queue1 = new QueueStructure(horizontal1, vertical1, motion1, x1, y1);
        queue2 = new QueueStructure(horizontal2, vertical2, motion2, x2, y2);
        queue3 = new QueueStructure(horizontal3, vertical3, motion3, x3, y3);
        queue4 = new QueueStructure(horizontal4, vertical4, motion4, x4, y4);
    }

    public static synchronized Environment getEnvironment(int X1, int Y1, int X2, int Y2, int X3, int Y3, int X4, int Y4) {
        if (singletonObject_Environment == null) {
            singletonObject_Environment = new Environment(X1, Y1, X2, Y2, X3, Y3, X4, Y4);
        }
        return singletonObject_Environment;
    }

    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public void update() {
        check_motion1();
        check_motion2();
        check_motion3();
        check_motion4();
    }

    public void check_motion1() {
        changing_all_horizontal_right(queue1.getHorizontal());
        changing_all_vertical(queue1.getVertical());
        if (queue1.getHorizontal().get(0).getPosition().getX() > queue1.getX()) {
            moving_from_horizontal_tovertical1(queue1.getHorizontal(), queue1.getVertical());
            Shapes t;
            t = PlatesPool.GetObject();
            Point positions = new Point(0, 0);
            positions.setLocation(0, 70);
            t.setPosition(positions);
            queue1.getHorizontal().add(t);
        }

    }

    public void check_motion2() {
        changing_all_horizontal_left(queue2.getHorizontal());
        changing_all_vertical(queue2.getVertical());
        if (queue2.getHorizontal().get(0).getPosition().getX() > queue2.getX()) {
            moving_from_horizontal_tovertical1(queue2.getHorizontal(), queue2.getVertical());
            Shapes t;
            t = PlatesPool.GetObject();
            Point positions = new Point(0, 0);
            positions.setLocation(1360, 70);
            t.setPosition(positions);
            queue2.getHorizontal().add(t);
        }
    }

    public void check_motion3() {
//        changing_all(queue3.getHorizontal(), queue3.getVertical());
//        if (queue3.getMotion() == 1) {
//            moving_from_horizontal_tovertical1(queue3.getHorizontal(), queue3.getVertical());
//        } else {
//            moving_from_horizontal_tovertical_1(queue3.getHorizontal(), queue3.getVertical());
//        }
        changing_all_horizontal_right(queue3.getHorizontal());
        changing_all_vertical(queue3.getVertical());
        if (queue3.getHorizontal().get(0).getPosition().getX() > queue3.getX()) {
            moving_from_horizontal_tovertical1(queue3.getHorizontal(), queue3.getVertical());
            Shapes t;
            t = PlatesPool.GetObject();
            Point positions = new Point(0, 0);
            positions.setLocation(0, 130);
            t.setPosition(positions);
            queue3.getHorizontal().add(t);
        }
    }

    public void check_motion4() {
        changing_all_horizontal_left(queue4.getHorizontal());
        changing_all_vertical(queue4.getVertical());
        if (queue4.getHorizontal().get(0).getPosition().getX() > queue4.getX()) {
            moving_from_horizontal_tovertical1(queue4.getHorizontal(), queue4.getVertical());
            Shapes t;
            t = PlatesPool.GetObject();
            Point positions = new Point(0, 0);
            positions.setLocation(1360, 130);
            t.setPosition(positions);
            queue4.getHorizontal().add(t);
        }
    }

    public void moving_from_horizontal_tovertical1(ArrayList<Shapes> horizontal, ArrayList<Shapes> vertical) {

        ArrayList<Shapes> horizontal2 = (ArrayList<Shapes>) horizontal.clone();
        vertical.add(horizontal2.get(0));
        horizontal.remove(0);

    }

//    public void moving_from_horizontal_tovertical_1(ArrayList<Shapes> horizontal, ArrayList<Shapes> vertical) {
//        ArrayList<Shapes> horizontal2 = (ArrayList<Shapes>) horizontal.clone();
//        vertical.add(horizontal2.get(0));
//        horizontal.remove(0);
//    }
    public void changing_all_horizontal_right(ArrayList<Shapes> horizontal) {
        for (int i = 0; i < horizontal.size(); i++) {
            Point positions = new Point(0, 0);
            int positionx = (int) horizontal.get(i).getPosition().getX() + 1;
            int positiony = (int) horizontal.get(i).getPosition().getY();
            positions.setLocation(positionx, positiony);
            horizontal.get(i).setPosition(positions);
        }
    }

    public void changing_all_horizontal_left(ArrayList<Shapes> horizontal) {
        for (int i = 0; i < horizontal.size(); i++) {
            Point positions = new Point(0, 0);
            int positionx = (int) horizontal.get(i).getPosition().getX() - 1;
            int positiony = (int) horizontal.get(i).getPosition().getY();
            positions.setLocation(positionx, positiony);
            horizontal.get(i).setPosition(positions);
        }
    }

    public void changing_all_vertical(ArrayList<Shapes> vertical) {
        for (int i = 0; i < vertical.size(); i++) {
            Point positions = new Point(0, 0);
            int positionx = (int) vertical.get(i).getPosition().getX();
            int positiony = (int) vertical.get(i).getPosition().getY() + 1;
            positions.setLocation(positionx, positiony);
            vertical.get(i).setPosition(positions);
        }
    }

    public Iterator getIterator1() {
        return queue1.getInterator();
    }

    public Iterator getIterator2() {
        return queue2.getInterator();
    }

    public Iterator getIterator3() {
        return queue3.getInterator();
    }

    public Iterator getIterator4() {
        return queue4.getInterator();
    }
}
