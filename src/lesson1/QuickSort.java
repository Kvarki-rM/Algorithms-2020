package lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {

    public static void quickSort(ArrayList<Double> array, int low, int high) {
        if (array.size() == 0)
            return;//завершить выполнение если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        //double opora = array[middle];
        double opora = array.get(middle);

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array.get(i) < opora) {
                i++;
            }

            while (array.get(j) > opora) {
                j--;
            }

            if (i <= j) {//меняем местами
                double temp = array.get(i);
                array.set(i, array.get(j));
                array.set(j, temp);
                i++;
                j--;
            }
        }
        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }

    public static void main(String[] args) {
        ArrayList<Double> x = new ArrayList<>();
        x.add(8.0);
        x.add(0.0);
        x.add(4.0);
        x.add(7.0);
        x.add(3.0);
        x.add(7.0);
        x.add(10.0);
        x.add(12.0);
        x.add(-3.0);
        System.out.println("Было");
        System.out.println(x.toString());

        int low = 0;
        int high = x.size() - 1;

        quickSort(x, low, high);
        System.out.println("Стало");
        System.out.println(x.toString());
    }
}