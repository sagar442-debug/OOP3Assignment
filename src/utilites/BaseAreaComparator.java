package utilites;
import java.util.Comparator;
import shapes.Shape;

// Comparator for Base Area
public class BaseAreaComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape s1, Shape s2) {
        return Double.compare(s1.calcBaseArea(), s2.calcBaseArea()); // Ascending order
    }
}