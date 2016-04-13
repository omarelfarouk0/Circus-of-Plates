
package Model;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Shape;

public class Shapes {
    protected Point position;
    protected Dimension dimension;
    
   public Shapes(){
       this.dimension = new Dimension(30, 20);
   }
    
   public Shape getShape(){
       return null;
   }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }
}
