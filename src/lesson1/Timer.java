package lesson1;

public class Timer {
    private static long start;

    private Timer() {
    }

    public static void start() {
        start = System.nanoTime();
    }

    public static void stop(String methodName) {
        long runTime = System.nanoTime() - start;
        System.out.println(methodName + " completed in " + (runTime / 1000000) + " ms. [" + runTime + " ns.]");
    }
}
