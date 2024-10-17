package shapes;

public abstract class Shape implements Comparable<Shape> {
    protected double height;

    public Shape(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    // Abstract methods to be implemented by subclasses
    public abstract double calcVolume();
    public abstract double calcBaseArea();

    // Implementation of compareTo method to compare shapes by height
    @Override
    public int compareTo(Shape other) {
    	Double thisHeight = this.height;
    	Double otherHeight = other.height;
//        return Double.compare(this.height, other.height);
    	return thisHeight.compareTo(otherHeight);
    }
}
