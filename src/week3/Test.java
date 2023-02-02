package week3;

public class Test {
    public static void main(String[] args) {
        Point O1 = new Point(0, 0);
        Point O2 = new Point(1, 1);
        Point O3 = new Point(0, 1);

        System.out.println("O1 less than O2: " + O1.lessThan(O2)); // true
        System.out.println("O1 less than O3: " + O1.lessThan(O3)); // true
        System.out.println("O2 less than O3: " + O2.lessThan(O3)); // false
        System.out.println("O3 less than O3: " + O3.lessThan(O3)); // false

        Comparable P1 = new Point(0, 0);
        Comparable P2 = new Point(1, 1);
        Comparable P3 = new Point(0, 1);

        System.out.println("P1 less than P2: " + P1.compareTo(P2)); // -1
        System.out.println("P1 less than P3: " + P1.compareTo(P3)); // -1
        System.out.println("P2 less than P3: " + P2.compareTo(P3)); // 1
        System.out.println("P3 less than P3: " + P3.compareTo(P3)); // 0
    }
}
