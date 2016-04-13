
package Model;

import java.util.ArrayList;

/**
 *
 * @author Sherif
 */
public class Iterator implements IteratorInterface {
    private int positionHorizontal=0;
    private int positionVertical=0;
    private ArrayList<Shapes>horizontal;
    private ArrayList<Shapes>vertical;
    public Iterator(ArrayList<Shapes>horizontal,ArrayList<Shapes>vertical ){
        this.horizontal=horizontal;
        this.vertical=vertical;
    }
    public Boolean has_next_horizontal(){
        if(positionHorizontal<horizontal.size())
            return true;
        else
            return false;
        
    }
     public Boolean has_next_vertical(){
        if(positionVertical<vertical.size())
            return true;
        else
            return false;
    }
    public Shapes next_horzontal(){
        if(has_next_horizontal()){
            int z=positionHorizontal;
            positionHorizontal++;
            return horizontal.get(z);
        }
        else{
            
            return begin_horizontal();
        }
    }
     public Shapes next_vertical(){
             if(has_next_vertical()){
            int z=positionVertical;
            positionVertical++;
            return vertical.get(z);
        }
        else{
            return begin_vertical();
        }
    }
     public Shapes begin_horizontal(){
        this.positionHorizontal=1;
        return horizontal.get(0);
     }
      public Shapes begin_vertical(){
        this.positionVertical=1;
        return vertical.get(0);
     }
    
}
