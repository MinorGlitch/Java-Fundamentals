import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Point[] triangleCoordinates = new Point[3];

        for (int i = 0; i < 3; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            triangleCoordinates[i] = new Point(x, y);

            scanner.nextLine();
        }

        int result = CalculateArea(triangleCoordinates);

        System.out.println(result);
    }

    private static int CalculateArea(Point[] triangleCoordinates) {
        Point A = triangleCoordinates[0];
        Point B = triangleCoordinates[1];
        Point C = triangleCoordinates[2];

        int area = A.getX() * (B.getY() - C.getY()) + B.getX() * (C.getY() - A.getY()) + C.getX() * (A.getY() - B.getY());

        return Math.abs(area / 2);
    }
}

class Point {
    private int X;
    private int Y;

    Point(int x, int y) {
        X = x;
        Y = y;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }
}
