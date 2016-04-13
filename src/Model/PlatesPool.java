package Model;

import Model.Objects.Ellipse;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Sherif
 */
public class PlatesPool {

    private static ArrayList<Shapes> available = new ArrayList<Shapes>();
    private static ArrayList<Shapes> in_use = new ArrayList<Shapes>();
    private static PlatesPool singletonObjectPlates;

    private  PlatesPool(ArrayList<Shapes> availablee, ArrayList<Shapes> in_usee) {
        this.available = availablee;
        this.in_use = in_usee;
    }

    public static synchronized PlatesPool getPlates() {
        if (singletonObjectPlates == null) {
            ArrayList<Shapes> avail = new ArrayList<Shapes>();
            ArrayList<Shapes> in_use = new ArrayList<Shapes>();
            singletonObjectPlates = new PlatesPool(avail, in_use);
            Point positions = new Point(0, 0);
            int index=480;
            for (int i = 0; i < 16; i++) {
                Shapes newShape = new Ellipse();
                positions.setLocation(index, 70);
                newShape.setPosition(positions);
                avail.add(newShape);
                index--;
            }
            index=880;
             for (int i = 0; i < 16; i++) {
                Shapes newShape = new Ellipse();
                positions.setLocation(index, 70);
                newShape.setPosition(positions);
                avail.add(newShape);
                index++;
            }
              index=330;
             for (int i = 0; i < 11; i++) {
                Shapes newShape = new Ellipse();
                positions.setLocation(index, 130);
                newShape.setPosition(positions);
                avail.add(newShape);
                index--;
            }
             index=1030;
               for (int i = 0; i < 11; i++) {
                Shapes newShape = new Ellipse();
                positions.setLocation(index, 130);
                newShape.setPosition(positions);
                avail.add(newShape);
                index++;
            }
            for (int i = 0; i < 30; i++) {
                Shapes newShape = new Ellipse();
                avail.add(newShape);
            }
             
        }
        return singletonObjectPlates;
    }

    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public static Shapes GetObject() {
        if (available.size() != 0) {
            Shapes storedObject = available.get(0);
            in_use.add(storedObject);
            available.remove(0);
            return storedObject;
        } else {
            Shapes newer = new Ellipse();
            in_use.add(newer);
            return newer;
        }
    }
// 

    public static void ReleaseObject(int index) {
        in_use.get(index).position.x = 0;
        in_use.get(index).position.y = 0;

        available.add(in_use.get(index));
        in_use.remove(index);
    }
}
