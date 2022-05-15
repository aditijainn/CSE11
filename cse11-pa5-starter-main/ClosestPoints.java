class Point {
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    boolean belowLeftOf(Point p) {
        return p.x > this.x && p.y > this.y;
    }
    boolean aboveRightOf(Point p) {
        return p.x < this.x && p.y < this.y;
    }
    double distance(Point p) {
        int dx = p.x - this.x;
        int dy = p.y - this.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}

class ClosestPoints {
    public static void main(String[] args) {
        Point one = new Point(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
        Point two = new Point(Integer.parseInt(args[2]),Integer.parseInt(args[3]));
        Point three = new Point(Integer.parseInt(args[4]),Integer.parseInt(args[5]));
        double a = one.distance(two);
        double b = one.distance(three);
        double c = two.distance(three);
        if ((a < b) && (a < c)) {
            System.out.println("The closest points are (" + one.x + ", " + one.y + ") and (" + two.x + ", " + two.y + ") at distance " + a);
        }
        else if ((b < a) && (b < c)) {
            System.out.println("The closest points are (" + one.x + ", " + one.y + ") and (" + three.x + ", " + three.y + ") at distance " + b);
        }
        else {
            System.out.println("The closest points are (" + two.x + ", " + two.y + ") and (" + three.x + ", " + three.y + ") at distance " + c);

        }
    }
}