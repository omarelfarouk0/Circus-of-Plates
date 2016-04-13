package Model;

/**
 *
 * @author Sherif
 */
public interface IteratorInterface {

    public Boolean has_next_horizontal();

    public Boolean has_next_vertical();

    public Shapes next_horzontal();

    public Shapes next_vertical();

    public Shapes begin_horizontal();

    public Shapes begin_vertical();
}
