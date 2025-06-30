package recursion;

public class StackSizeTester {
    static int depth = 0;

    public static void testRecursion() {
        depth++; // Har bir chaqiruvda depth oshadi
        testRecursion();
    }

    public static void main(String[] args) {
        try {
            testRecursion();
        } catch (StackOverflowError e) {
            System.out.println("Maximum Recursion Depth: " + depth);
        }
    }


}


