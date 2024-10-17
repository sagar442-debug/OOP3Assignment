package shapes;

public class OctagonalPrism extends Shape {
    private double side;

    public OctagonalPrism(double height, double side) {
        super(height); // Call to the parent class (Shape) constructor
        this.side = side;
    }

    @Override
    public double calcVolume() {
        return calcBaseArea() * height; // Volume = Base Area * Height
    }

    @Override
    public double calcBaseArea() {
        return 2 * (1 + Math.sqrt(2)) * Math.pow(side, 2);
    }

    @Override
    public String toString() {
        return String.format("OctagonalPrism [Height=%.2f, Side=%.2f, Volume=%.2f, Base Area=%.2f]", 
                             height, side, calcVolume(), calcBaseArea());
    }
}
