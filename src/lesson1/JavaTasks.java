package lesson1;

import kotlin.NotImplementedError;
import kotlin.random.URandomKt;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.*;

import static lesson1.QuickSort.quickSort;

@SuppressWarnings("unused")
public class JavaTasks {
    /**
     * Сортировка времён
     * <p>
     * Простая
     * (Модифицированная задача с сайта acmp.ru)
     * <p>
     * Во входном файле с именем inputName содержатся моменты времени в формате ЧЧ:ММ:СС AM/PM,
     * каждый на отдельной строке. См. статью википедии "12-часовой формат времени".
     * <p>
     * Пример:
     * <p>
     * 01:15:19 PM
     * 07:26:57 AM
     * 10:00:03 AM
     * 07:56:14 PM
     * 01:15:19 PM
     * 12:40:31 AM
     * <p>
     * Отсортировать моменты времени по возрастанию и вывести их в выходной файл с именем outputName,
     * сохраняя формат ЧЧ:ММ:СС AM/PM. Одинаковые моменты времени выводить друг за другом. Пример:
     * <p>
     * 12:40:31 AM
     * 07:26:57 AM
     * 10:00:03 AM
     * 01:15:19 PM
     * 01:15:19 PM
     * 07:56:14 PM
     * <p>
     * В случае обнаружения неверного формата файла бросить любое исключение.
     */
    /**
     * Ресурсоемкость - O(N)
     * Трудоемкость - O(N log2N)
     */

    static public void sortTimes(String inputName, String outputName) throws IOException {
        ArrayList<TimeClass> temp = sortOfTime(inputName);
        writerT(temp, outputName);
    }

    @NotNull
    private static ArrayList<TimeClass> sortOfTime(String inputName) {
        Timer.start();
        ArrayList<TimeClass> end = new ArrayList<>();
        int i = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(inputName)));
            String line;
            while ((line = br.readLine()) != null) {
                end.add(new TimeClass(line));
                i++;
            }
            br.close();
        } catch (IOException e) {
            throw new IllegalArgumentException("Нету файла по указанному пути или файл не соответсвует формату.");
        }
        for (int j = 0; j < end.size(); j++)
            for (int k = 0; k < end.size(); k++)
                if (end.get(j).hour < end.get(k).hour || ((end.get(j).min < end.get(k).min)
                        && (end.get(j).hour == end.get(k).hour)) || ((end.get(j).sec < end.get(k).sec)
                        && (end.get(j).min == end.get(k).min) && (end.get(j).hour == end.get(k).hour))) {
                    TimeClass temp = end.get(k);
                    end.set(k, end.get(j));
                    end.set(j, temp);
                }
        Timer.stop("sortOfTime");
        return end;
    }

    static private void writerT(@NotNull ArrayList<TimeClass> text, String outputName) throws IOException {
        Timer.start();
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(outputName))) {
            for (TimeClass timeClass : text)
                if (timeClass.full != null)
                    wr.write(timeClass.full + "\n");
        }
        Timer.stop("writerT");
    }


    /**
     * Сортировка адресов
     * <p>
     * Средняя
     * <p>
     * Во входном файле с именем inputName содержатся фамилии и имена жителей города с указанием улицы и номера дома,
     * где они прописаны. Пример:
     * <p>
     * Петров Иван - Железнодорожная 3
     * Сидоров Петр - Садовая 5
     * Иванов Алексей - Железнодорожная 7
     * Сидорова Мария - Садовая 5
     * Иванов Михаил - Железнодорожная 7
     * <p>
     * Людей в городе может быть до миллиона.
     * <p>
     * Вывести записи в выходной файл outputName,
     * упорядоченными по названию улицы (по алфавиту) и номеру дома (по возрастанию).
     * Людей, живущих в одном доме, выводить через запятую по алфавиту (вначале по фамилии, потом по имени). Пример:
     * <p>
     * Железнодорожная 3 - Петров Иван
     * Железнодорожная 7 - Иванов Алексей, Иванов Михаил
     * Садовая 5 - Сидоров Петр, Сидорова Мария
     * <p>
     * В случае обнаружения неверного формата файла бросить любое исключение.
     */
    static public void sortAddresses(String inputName, String outputName) {
        throw new NotImplementedError();
    }

    /**
     * Сортировка температур
     * <p>
     * Средняя
     * (Модифицированная задача с сайта acmp.ru)
     * <p>
     * Во входном файле заданы температуры различных участков абстрактной планеты с точностью до десятых градуса.
     * Температуры могут изменяться в диапазоне от -273.0 до +500.0.
     * Например:
     * <p>
     * 24.7
     * -12.6
     * 121.3
     * -98.4
     * 99.5
     * -12.6
     * 11.0
     * <p>
     * Количество строк в файле может достигать ста миллионов.
     * Вывести строки в выходной файл, отсортировав их по возрастанию температуры.
     * Повторяющиеся строки сохранить. Например:
     * <p>
     * -98.4
     * -12.6
     * -12.6
     * 11.0
     * 24.7
     * 99.5
     * 121.3
     *
     * Была использована быстрая сортировка
     * Трудоёмкость O(N), ресурсоёмкость O(1)
     */

    static public void sortTemperatures(String inputName, String outputName) throws IOException {
        Timer.start();
        ArrayList<Double> list = new ArrayList<>();
        Scanner in = new Scanner(new File(inputName));
        while (in.hasNextLine()) {
            Double temp = Double.valueOf(in.nextLine());
            if (temp > 500.0 || temp < -273.0) throw new IllegalArgumentException();
            list.add(temp);
        }
        quickSort(list, 0, list.size() - 1);
        try (FileWriter writer = new FileWriter(outputName)) {
            for (Double element : list) writer.write(element + "\n");
        }
        Timer.stop("sortTemperatures");
    }

    /**
     * Сортировка последовательности
     * <p>
     * Средняя
     * (Задача взята с сайта acmp.ru)
     * <p>
     * В файле задана последовательность из n целых положительных чисел, каждое в своей строке, например:
     * <p>
     * 1
     * 2
     * 3
     * 2
     * 3
     * 1
     * 2
     * <p>
     * Необходимо найти число, которое встречается в этой последовательности наибольшее количество раз,
     * а если таких чисел несколько, то найти минимальное из них,
     * и после этого переместить все такие числа в конец заданной последовательности.
     * Порядок расположения остальных чисел должен остаться без изменения.
     * <p>
     * 1
     * 3
     * 3
     * 1
     * 2
     * 2
     * 2
     */

    static public void sortSequence(String inputName, String outputName) throws IOException {
        Timer.start();
        ArrayDeque<Integer> list = new ArrayDeque<>();
        Integer nameOfMax = -1;
        Integer j = -1;
        try (BufferedReader buffer = new BufferedReader(new FileReader(inputName))) {
            Map<Integer, Integer> countNumber = new HashMap<>();
            String line = buffer.readLine();
            while (line != null) {
                int number = Integer.parseInt(line);
                list.add(number);
                Integer count = countNumber.get(number);
                if (count == null) count = 0;
                countNumber.put(number, count + 1);
                line = buffer.readLine();
            }
            for (Map.Entry<Integer, Integer> entry : countNumber.entrySet()) {
                Integer actualName = entry.getKey();
                Integer count = entry.getValue();
                if (count > j || ((count.equals(j)) && (actualName < nameOfMax))) {
                    j = count;
                    nameOfMax = actualName;
                }
            }
            try (FileWriter writer = new FileWriter(outputName)) {
                for (Integer zz : list) {
                    if (!zz.equals(nameOfMax))
                        writer.write(list.peek() + "\n");
                    list.remove();
                }
                for (; j > 0; j--) writer.write(nameOfMax + "\n");
            }
        }
        Timer.stop("sortSequence");
    }


    /**
     * Соединить два отсортированных массива в один
     * <p>
     * Простая
     * <p>
     * Задан отсортированный массив first и второй массив second,
     * первые first.size ячеек которого содержат null, а остальные ячейки также отсортированы.
     * Соединить оба массива в массиве second так, чтобы он оказался отсортирован. Пример:
     * <p>
     * first = [4 9 15 20 28]
     * second = [null null null null null 1 3 9 13 18 23]
     * <p>
     * Результат: second = [1 3 4 9 9 13 15 20 23 28]
     * array contents differ at index [1995], expected: <19955> but was: <19811>
     * array contents differ at index [1981], expected: <19811> but was: <19530>
     * array contents differ at index [1877], expected: <18770> but was: <16374>
     */
    static <T extends Comparable<T>> void mergeArrays(@NotNull T[] first, @NotNull T[] second) {
        int k = 0;
        int j = first.length;
        int i = 0;
        while ((j < second.length) && (i < second.length)) {
            if (first[k].compareTo(second[j]) < 0) {
                second[i] = first[k];
                k++;
                i++;
            } else {
                second[i] = second[j];
                j++;
                i++;
            }
        }
    }
}

