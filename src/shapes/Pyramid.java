package shapes;

public class Pyramid extends Shape {
    private double baseSide; // Length of a side of the square base

    public Pyramid(double height, double baseSide) {
        super(height);
        this.baseSide = baseSide;
    }

    @Override
    public double calcVolume() {
        return (1.0 / 3) * calcBaseArea() * height; // Volume = (1/3) * Base Area * Height
    }

    @Override
    public double calcBaseArea() {
        return Math.pow(baseSide, 2); // Area of square base
    }

    @Override
    public String toString() {
        return String.format("Pyramid [Height=%.2f, Base Side=%.2f, Volume=%.2f, Base Area=%.2f]", 
                             height, baseSide, calcVolume(), calcBaseArea());
    }
}
