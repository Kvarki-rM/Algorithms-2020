package lesson1;

class Timer {
    private static long start;

    private Timer() {
    }

    static void start() {
        start = System.nanoTime();
    }

    static void stop(String methodName) {
        long runTime = System.nanoTime() - start;
        System.out.println(methodName + " completed in " + (runTime / 1000000) + " ms. [" + runTime + " ns.]");
    }
}
