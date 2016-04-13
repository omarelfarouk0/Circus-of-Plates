
package Model.Objects;

import Model.Shapes;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class Ellipse extends Shapes {
    @Override
    public Shape getShape(){
        return  new Ellipse2D.Double((int)position.getX(), (int)position.getY(), (int)dimension.getWidth(), (int)dimension.getHeight());
    }
}
