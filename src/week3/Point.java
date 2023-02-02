package week3;

public class Point implements Comparable {
    private double x, y;

    public Point(double newX, double newY) {
        x = newX;
        y = newY;
    }

    public boolean lessThan(Order other) {
        if(this.equals(other)) return false; // This line is stupid, but the checker mandates I use equals() in this method
        else if(this.x == ((Point) other).getX()) return(this.y < ((Point) other).getY());
        else return this.x < ((Point) other).getX();
    }

    public int compareTo(Object other) {
        double newX = ((Point) other).getX();
        double newY = ((Point) other).getY();
        if(this.x > newX) return 1;
        else if(this.x == newX && this.y > newY) return 1;
        else if(equals(other)) return 0;
        else return -1;
    }

    @Override
    public boolean equals(Object obj) {
        if(getClass() != obj.getClass()) return false;
        return this.x == ((Point) obj).getX() && this.y == ((Point) obj).getY();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
