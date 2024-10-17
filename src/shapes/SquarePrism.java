package shapes;

public class SquarePrism extends Shape {
    private double side; // Length of a side of the square base

    public SquarePrism(double height, double side) {
        super(height);
        this.side = side;
    }

    @Override
    public double calcVolume() {
        return calcBaseArea() * height; // Volume = Base Area * Height
    }

    @Override
    public double calcBaseArea() {
        return Math.pow(side, 2); // Area of square base
    }

    @Override
    public String toString() {
        return String.format("SquarePrism [Height=%.2f, Side=%.2f, Volume=%.2f, Base Area=%.2f]", 
                             height, side, calcVolume(), calcBaseArea());
    }
}
