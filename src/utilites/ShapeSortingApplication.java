package utilites;

import java.util.Arrays;

import shapes.Cone;
import shapes.Cylinder;
import shapes.Shape;
import shapes.OctagonalPrism;
import shapes.SquarePrism;
import shapes.Pyramid;
import shapes.PentagonalPrism;
import shapes.TriangularPrism;

public class ShapeSortingApplication {
    public static void main(String[] args) {
        // Example shapes
        Shape[] shapes = {
            new Cylinder(10, 5),
            new Cone(8, 3),
            new Pyramid(6, 4),
            new SquarePrism(5, 4),
            new PentagonalPrism(7, 3),
            new OctagonalPrism(4, 2),
            new TriangularPrism(6, 3)
        };

        // Default compare type
        String compareType = "h"; // Default to height
        for (int i = 0; i < args.length; i++) {
            if ("-t".equalsIgnoreCase(args[i]) && i + 1 < args.length) {
                compareType = args[i + 1].toLowerCase();
            }
        }

        // Sort based on the specified comparison type
        switch (compareType) {
            case "h":
                Arrays.sort(shapes); // Sort by height using Comparable
                break;
            case "a":
                Arrays.sort(shapes, new BaseAreaComparator()); // Sort by base area
                break;
            case "v":
                Arrays.sort(shapes, new VolumeComparator()); // Sort by volume
                break;
            default:
                System.out.println("Invalid comparison type. Use h for height, a for base area, v for volume.");
                return;
        }

        // Print sorted shapes based on the comparison type
        System.out.println("Sorted Shapes:");
        printShapes(shapes, compareType); // Pass the compareType to printShapes
    }

    private static void printShapes(Shape[] shapes, String compareType) {
        for (Shape shape : shapes) {
            // Check the comparison type and print accordingly
            if (compareType.equals("v")) {
                System.out.printf("%s, Volume: %.2f%n", shape.getClass().getSimpleName(), shape.calcVolume());
            } else if (compareType.equals("a")) {
                System.out.printf("%s, Base Area: %.2f%n", shape.getClass().getSimpleName(), shape.calcBaseArea());
            } else {
                System.out.printf("%s, Height: %.2f%n", shape.getClass().getSimpleName(), shape.getHeight());
            }
        }
    }
}
