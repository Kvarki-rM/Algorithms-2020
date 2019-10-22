package lesson2;

import kotlin.NotImplementedError;
import kotlin.Pair;
import lesson1.Timer;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@SuppressWarnings("unused")
public class JavaAlgorithms {
    /**
     * Получение наибольшей прибыли (она же -- поиск максимального подмассива)
     * Простая
     * <p>
     * Во входном файле с именем inputName перечислены цены на акции компании в различные (возрастающие) моменты времени
     * (каждая цена идёт с новой строки). Цена -- это целое положительное число. Пример:
     * <p>
     * 201
     * 196
     * 190
     * 198
     * 187
     * 194
     * 193
     * 185
     * <p>
     * Выбрать два момента времени, первый из них для покупки акций, а второй для продажи, с тем, чтобы разница
     * между ценой продажи и ценой покупки была максимально большой. Второй момент должен быть раньше первого.
     * Вернуть пару из двух моментов.
     * Каждый момент обозначается целым числом -- номер строки во входном файле, нумерация с единицы.
     * Например, для приведённого выше файла результат должен быть Pair(3, 4)
     * <p> 17383 14987
     * В случае обнаружения неверного формата файла бросить любое исключение.
     */

    static public Pair<Integer, Integer> optimizeBuyAndSell(String inputName) {
        Timer.start();
        ArrayList<Integer> input = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(inputName)));
            String line;
            while ((line = br.readLine()) != null) input.add(Integer.valueOf(line));
            br.close();
        } catch (IOException e) {
            throw new IllegalArgumentException("Нету файла по указанному пути или файл содержит недопустимые символы.");
        }

        Pair<Integer, Integer> end = new Pair<>(0, 1);
        int value = input.get(0) - input.get(1);
        for (int j = 0; j < input.size(); j++)
            for (int k = j + 1; k < input.size(); k++)
                if ((input.get(j) - input.get(k) < value)) {
                    value = input.get(j) - input.get(k);
                    end = new Pair<>(j + 1, k + 1);
                }
        Timer.stop("optimizeBuyAndSell");
        return end;
    }

    // HashMap<Integer, Pair<Integer, Integer>> delta = new HashMap<>();
    //        for (int j = 0; j < input.size(); j++)
    //            for (int k = j + 1; k < input.size(); k++)
    //                delta.put(input.get(j) - input.get(k), new Pair<>(j, k));
    //
    //        Pair<Integer, Integer> end = new Pair<>(0, 1);
    //        int value = input.get(0) - input.get(1);
    //        for (Map.Entry<Integer, Pair<Integer, Integer>> entry : delta.entrySet()) {
    //            Integer key = entry.getKey();
    //            Pair<Integer, Integer> num = entry.getValue();
    //            if (key < value) {
    //                value = key;
    //                end = num;
    //            }
    //        }
    //
    //        //value = input.get(j) - input.get(k);
    //        Pair<Integer, Integer> last = new Pair<>(end.getFirst() + 1, end.getSecond() + 1);
    //        Timer.stop("getPrimes");
    //        return last;

    /**
     * Задача Иосифа Флафия.
     * Простая
     * <p>
     * Образовав круг, стоят menNumber человек, пронумерованных от 1 до menNumber.
     * <p>
     * 1 2 3
     * 8   4
     * 7 6 5
     * <p>
     * Мы считаем от 1 до choiceInterval (например, до 5), начиная с 1-го человека по кругу.
     * Человек, на котором остановился счёт, выбывает.
     * <p>
     * 1 2 3
     * 8   4
     * 7 6 х
     * <p>
     * Далее счёт продолжается со следующего человека, также от 1 до choiceInterval.
     * Выбывшие при счёте пропускаются, и человек, на котором остановился счёт, выбывает.
     * <p>
     * 1 х 3
     * 8   4
     * 7 6 Х
     * <p>
     * Процедура повторяется, пока не останется один человек. Требуется вернуть его номер (в данном случае 3).
     * <p>
     * 1 Х 3
     * х   4
     * 7 6 Х
     * <p>
     * 1 Х 3
     * Х   4
     * х 6 Х
     * <p>
     * х Х 3
     * Х   4
     * Х 6 Х
     * <p>
     * Х Х 3
     * Х   х
     * Х 6 Х
     * <p>
     * Х Х 3
     * Х   Х
     * Х х Х
     * <p>
     * Общий комментарий: решение из Википедии для этой задачи принимается,
     * но приветствуется попытка решить её самостоятельно.
     */
    static public int josephTask(int menNumber, int choiceInterval) {
        throw new NotImplementedError();
    }

    /**
     * Наибольшая общая подстрока.
     * Средняя
     * <p>
     * Дано две строки, например ОБСЕРВАТОРИЯ и КОНСЕРВАТОРЫ.
     * Найти их самую длинную общую подстроку -- в примере это СЕРВАТОР.
     * Если общих подстрок нет, вернуть пустую строку.
     * При сравнении подстрок, регистр символов *имеет* значение.
     * Если имеется несколько самых длинных общих подстрок одной длины,
     * вернуть ту из них, которая встречается раньше в строке first.
     */
    static public String longestCommonSubstring(String firs, String second) {
        throw new NotImplementedError();
    }

    /**
     * Число простых чисел в интервале
     * Простая
     * <p>
     * Рассчитать количество простых чисел в интервале от 1 до limit (включительно).
     * Если limit <= 1, вернуть результат 0.
     * <p>
     * Справка: простым считается число, которое делится нацело только на 1 и на себя.
     * Единица простым числом не считается.
     */
    @Contract(pure = true)
    static public int calcPrimesNumber(int limit) {
        Timer.start();
        if (limit < 2) return 0;
        ArrayList<Integer> primes = new ArrayList<>();
        primes.add(2);
        for (int i = 3; primes.size() < limit; i += 2)
            if (isPrime(i, primes)) {
                primes.add(i);
                if (i >= limit)
                    break;
            }
        Timer.stop("calcPrimesNumber");
        return primes.size() - 1;
    }

    @Contract(pure = true)
    private static boolean isPrime(int n, @NotNull List<Integer> primes) {
        double sqrt = Math.sqrt(n);
        for (int prime : primes) {
            if (prime > sqrt) return true;
            if (n % prime == 0) return false;
        }
        return true;
    }

    /**
     * Балда
     * Сложная
     * <p>
     * В файле с именем inputName задана матрица из букв в следующем формате
     * (отдельные буквы в ряду разделены пробелами):
     * <p>
     * И Т Ы Н
     * К Р А Н
     * А К В А
     * <p>
     * В аргументе words содержится множество слов для поиска, например,
     * ТРАВА, КРАН, АКВА, НАРТЫ, РАК.
     * <p>
     * Попытаться найти каждое из слов в матрице букв, используя правила игры БАЛДА,
     * и вернуть множество найденных слов. В данном случае:
     * ТРАВА, КРАН, АКВА, НАРТЫ
     * <p>
     * И т Ы Н     И т ы Н
     * К р а Н     К р а н
     * А К в а     А К В А
     * <p>
     * Все слова и буквы -- русские или английские, прописные.
     * В файле буквы разделены пробелами, строки -- переносами строк.
     * Остальные символы ни в файле, ни в словах не допускаются.
     */
    static public Set<String> baldaSearcher(String inputName, Set<String> words) {
        throw new NotImplementedError();
    }
}
