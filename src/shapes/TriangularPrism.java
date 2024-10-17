package shapes;

public class TriangularPrism extends Shape {
    private double base; // Length of the side of the triangular face (equilateral triangle)

    public TriangularPrism(double prismHeight, double base) {
        super(prismHeight);
        this.base = base;
    }

    @Override
    public double calcVolume() {
        return calcBaseArea() * height; // Volume = Base Area * Height of the prism
    }

    @Override
    public double calcBaseArea() {
        return (Math.pow(base, 2) * Math.sqrt(3)) / 4; // Area of equilateral triangle
    }

    @Override
    public String toString() {
        return String.format("TriangularPrism [Height=%.2f, Base=%.2f, Volume=%.2f, Base Area=%.2f]", 
                             height, base, calcVolume(), calcBaseArea());
    }
}
