package shapes;

public class Cone extends Shape
{
	private double radius;
	public Cone(double height, double radius) {
		super(height);
		this.radius = radius;
	}
	@Override
	public double calcVolume() {
		return (1.0/3)*Math.PI * Math.pow(radius,2) * height;
	}
	@Override
	public double calcBaseArea() {
		return Math.PI * Math.pow(radius, 2);
	}
	 @Override
	    public String toString() {
		 return String.format("Cone [Height=%.2f, Radius=%.2f, Volume=%.2f, Base Area=%.2f]", 
                 height, radius, calcVolume(), calcBaseArea());
	    }
}
