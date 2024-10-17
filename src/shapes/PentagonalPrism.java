package shapes;

public class PentagonalPrism extends Shape {
    private double side; // Length of the side of the pentagonal base

    public PentagonalPrism(double height, double side) {
        super(height); // Call to the parent class (Shape) constructor
        this.side = side;
    }

    @Override
    public double calcVolume() {
        return calcBaseArea() * height; // Volume = Base Area * Height
    }

    @Override
    public double calcBaseArea() {
        // Base area of a regular pentagon = (1/4) * √(5(5 + 2√5)) * side²
        return (1.0 / 4) * Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) * Math.pow(side, 2);
    }

    @Override
    public String toString() {
        return String.format("PentagonalPrism [Height=%.2f, Side=%.2f, Volume=%.2f, Base Area=%.2f]", 
                             height, side, calcVolume(), calcBaseArea());
    }
}
