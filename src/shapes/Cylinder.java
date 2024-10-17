package shapes;

public class Cylinder extends Shape {
    private double radius;

    public Cylinder(double height, double radius) {
        super(height);
        this.radius = radius;
    }

    @Override
    public double calcVolume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }

    @Override
    public double calcBaseArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return String.format("Cylinder [Height=%.2f, Radius=%.2f, Volume=%.2f, Base Area=%.2f]", 
                             height, radius, calcVolume(), calcBaseArea());
    }
}