package appDomain;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import shapes.Cone;
import shapes.Cylinder;
import shapes.OctagonalPrism;
import shapes.PentagonalPrism;
import shapes.Pyramid;
import shapes.Shape;
import shapes.SquarePrism;
import shapes.TriangularPrism;
import utilites.SortingUtils;

public class AppDriver {
    public static void main(String[] args) {
        String fileName = null;
        String compareType = "h"; // Default compare type is height
        String sortType = "q"; // Default sort type is quicksort

        // Parse command-line arguments to get the file name, compare type, and sort type
        for (int i = 0; i < args.length; i++) {
            if ("-f".equalsIgnoreCase(args[i]) && i + 1 < args.length) {
                fileName = args[i + 1];
            }
            if ("-t".equalsIgnoreCase(args[i]) && i + 1 < args.length) {
                compareType = args[i + 1].toLowerCase();
            }
            if ("-s".equalsIgnoreCase(args[i]) && i + 1 < args.length) {
                sortType = args[i + 1].toLowerCase();
            }
        }

        // Check if file name was provided
        if (fileName == null) {
            System.out.println("Error: No input file provided. Use -f option to specify the file.");
            return;
        }

        try {
            // Reading shapes from the file and store them in an array
            Shape[] shapes = readShapesFromFile(fileName);
            
            // Starting timing the sorting operation
            long startTime = System.currentTimeMillis();

            // Sorting the shapes based on the compare type
            switch (sortType) {
                case "b": // Bubble Sort
                    SortingUtils.bubbleSort(shapes);
                    break;
                case "s": // Selection Sort
                    SortingUtils.selectionSort(shapes);
                    break;
                case "i": // Insertion Sort
                    SortingUtils.insertionSort(shapes);
                    break;
                case "m": // Merge Sort
                    SortingUtils.mergeSort(shapes);
                    break;
                case "q": // Quick Sort
                    SortingUtils.quickSort(shapes);
                    break;
                case "h": // Heap Sort
                    SortingUtils.heapSort(shapes);
                    break;
                default:
                    System.out.println("Invalid sorting algorithm specified. Use b, s, i, m, q, or z.");
                    return;
            }

            // End timing the sorting operation
            long endTime = System.currentTimeMillis();
            long runtime = endTime - startTime;

            // Printing specific sorted shapes
            displaySpecificShapes(shapes, compareType);

            // Displaying runtime
            System.out.println("Runtime: " + runtime + " milliseconds");

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + fileName);
        }
    }

    private static Shape[] readShapesFromFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        // Reading the number of shapes from the first line
        int numberOfShapes = scanner.nextInt();
        scanner.nextLine(); // Move to the next line

        Shape[] shapes = new Shape[numberOfShapes];

        // Iterating over the remaining lines to create shape objects
        for (int i = 0; i < numberOfShapes; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            String shapeType = parts[0];

            switch (shapeType.toLowerCase()) {
                case "cylinder":
                    double cylinderHeight = Double.parseDouble(parts[1]);
                    double cylinderRadius = Double.parseDouble(parts[2]);
                    shapes[i] = new Cylinder(cylinderHeight, cylinderRadius);
                    break;

                case "cone":
                    double coneHeight = Double.parseDouble(parts[1]);
                    double coneRadius = Double.parseDouble(parts[2]);
                    shapes[i] = new Cone(coneHeight, coneRadius);
                    break;

                case "pyramid":
                    double pyramidHeight = Double.parseDouble(parts[1]);
                    double pyramidBaseSide = Double.parseDouble(parts[2]);
                    shapes[i] = new Pyramid(pyramidHeight, pyramidBaseSide);
                    break;

                case "squareprism":
                    double squarePrismHeight = Double.parseDouble(parts[1]);
                    double squarePrismSide = Double.parseDouble(parts[2]);
                    shapes[i] = new SquarePrism(squarePrismHeight, squarePrismSide);
                    break;

                case "triangularprism":
                    if (parts.length < 3) {
                        System.out.println("Error: Not enough parameters for TriangularPrism: " + line);
                        break;
                    }
                    double triangularPrismHeight = Double.parseDouble(parts[1]);
                    double triangularPrismBase = Double.parseDouble(parts[2]);
                    shapes[i] = new TriangularPrism(triangularPrismHeight, triangularPrismBase);
                    break;

                case "pentagonalprism":
                    double pentagonalPrismHeight = Double.parseDouble(parts[1]);
                    double pentagonalPrismSide = Double.parseDouble(parts[2]);
                    shapes[i] = new PentagonalPrism(pentagonalPrismHeight, pentagonalPrismSide);
                    break;

                case "octagonalprism":
                    double octagonalPrismHeight = Double.parseDouble(parts[1]);
                    double octagonalPrismSide = Double.parseDouble(parts[2]);
                    shapes[i] = new OctagonalPrism(octagonalPrismHeight, octagonalPrismSide);
                    break;

                default:
                    System.out.println("Unknown shape type: " + shapeType);
                    break;
            }
        }

        scanner.close();
        return shapes;
    }

    private static void displaySpecificShapes(Shape[] shapes, String compareType) {
        // First sorted value
        System.out.printf("First sorted value: The %s has a %s of: %.2f%n",
                          shapes[0].getClass().getSimpleName(),
                          getMetricName(compareType),
                          getMetricValue(shapes[0], compareType));

       
        
        // Every thousandth element
        for (int i = 1000; i < shapes.length; i += 1000) {
            System.out.printf("%d-th element is: The %s has a %s of: %.2f%n",
                              i,
                              shapes[i].getClass().getSimpleName(),
                              getMetricName(compareType),
                              getMetricValue(shapes[i], compareType));
        }
        

        // Second last element
        if (shapes.length >= 2) {
            System.out.printf("Second Last element: The %s has a %s of: %.2f%n",
                              shapes[shapes.length - 2].getClass().getSimpleName(),
                              getMetricName(compareType),
                              getMetricValue(shapes[shapes.length - 2], compareType));
        }
        // Last sorted value
        System.out.printf("Last Element: The %s has a %s of: %.2f%n",
                          shapes[shapes.length - 1].getClass().getSimpleName(),
                          getMetricName(compareType),
                          getMetricValue(shapes[shapes.length - 1], compareType));
    }

    private static String getMetricName(String compareType) {
        switch (compareType) {
            case "v":
                return "Volume";
            case "a":
                return "Base Area";
            case "h":
                return "Height";
            default:
                return "Unknown Metric";
        }
    }

    private static double getMetricValue(Shape shape, String compareType) {
        switch (compareType) {
            case "v":
                return shape.calcVolume();
            case "a":
                return shape.calcBaseArea();
            case "h":
                return shape.getHeight();
            default:
                return 0;
        }
    }
}
