package org.example.task1;

public class TangImpl {

    public static double tan(double x, int n) {
        return sin(x, n) / cos(x, n);
    }

    private static double sin(double x, int n) {
        double ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.pow(-1, i) / fact(2 * i + 1) * Math.pow(x, 2 * i + 1);
        }
        return ans;
    }

    private static double cos(double x, int n) {
        double ans = 0;

        for (int i = 0; i < n; i++) {
            ans += Math.pow(-1, i) / fact(2 * i) * Math.pow(x, 2 * i);
        }
        return ans;
    }

    private static double fact(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n == 1 || n == 0) return 1;
        return n * fact(n - 1);
    }
}
