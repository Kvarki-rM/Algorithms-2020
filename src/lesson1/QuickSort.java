package lesson1;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

class QuickSort {

    static void quickSort(@NotNull ArrayList<Double> array, int low, int high) {
        if (array.size() == 0)
            return;
        if (low >= high)
            return;
        int middle = low + (high - low) / 2;
        double step = array.get(middle);

        int i = low;
        int j = high;
        while (i <= j) {
            while (array.get(i) < step) {
                i++;
            }
            while (array.get(j) > step) {
                j--;
            }
            if (i <= j) {
                double temp = array.get(i);
                array.set(i, array.get(j));
                array.set(j, temp);
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(array, low, j);
        if (high > i)
            quickSort(array, i, high);
    }
}