package lesson2;

import kotlin.NotImplementedError;
import kotlin.Pair;
import lesson1.Timer;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.nio.charset.StandardCharsets;
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
     * <p>
     * Ресурсоемкость - O(N)
     * Трудоемкость - ..............     * Трудоемкость - .....................     * Трудоемкость - ............................
     */
    @NotNull
    @Contract("_ -> new")
    static public Pair<Integer, Integer> optimizeBuyAndSell(String inputName) {
        Timer.start();
        ArrayList<Integer> input = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(inputName)));
            String line;
            while ((line = br.readLine()) != null) input.add(Integer.valueOf(line));
            br.close();
        } catch (IOException e) {
            throw new IllegalArgumentException("Нету файла по указанному пути или файл не соответсвует формату.");
        }

        ArrayList<Integer> delta = new ArrayList<>();
        for (int i = 0; i < input.size() - 1; i++) delta.add(input.get(i + 1) - input.get(i));

        int max = 0;
        int sum = 0;
        int begin = 0;
        int end = 0;
        int maxBegin = 0;
        for (int j = 0; j < delta.size(); j++) {
            sum += delta.get(j);
            if (sum > max) {
                max = sum;
                maxBegin = begin;
                end = j;
            }
            if (sum < 0) {
                sum = 0;
                begin = j + 1;
            }
        }

        Timer.stop("optimizeBuyAndSell");
        return (new Pair<>(maxBegin + 1, end + 2));
    }

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
     * <p>
     * N - длина первой строки, М - длина второй строки
     * Ресурсоемкость - O(min(N,M))
     * Трудоемкость - O(MN)
     */
    @Contract("null, _ -> !null; !null, null -> !null")
    static public String longestCommonSubstring(String first, String second) {
        if (first == null || second == null || first.length() == 0 || second.length() == 0) {
            return "";
        }
        String outMaxName = "";
        int maxLen = 0;
        int fl = first.length();
        int sl = second.length();
        StringBuilder temp = new StringBuilder();
        int distance = 0;
        for (int i = 0; i < fl; i++)
            for (int j = 0; j < sl; j++)
                if (first.charAt(i) == second.charAt(j)) {
                    distance++;
                    for (int k = 0; k < Math.min(fl - i, sl - j); k++) {
                        if (first.charAt(i + k) == second.charAt(j + k)) {
                            temp.append(first.charAt(i + k));
                            distance++;
                        } else {
                            if (distance > maxLen) {
                                maxLen = distance;
                                outMaxName = String.valueOf(temp);
                            }
                            temp = new StringBuilder();
                            distance = 0;
                            break;
                        }
                    }
                }
        return outMaxName;
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
     * <p>
     * Трудоёмкость O(N*sqrt(N)), ресурсоёмкость O(1)
     */
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
     * <p>
     * N - количество строк в матрице,
     * М - количество столбцов в матрице,
     * K - количество слов в файле
     * L - длина самого длинного слова
     * Худшая ресурсоемкость - O(MN+K)
     * Худшая трудоемкость - O(KMN*3^(L-1))
     */
    @NotNull
    static public Set<String> baldaSearcher(String inputName, Set<String> words) {
        Timer.start();
        ArrayList<String[]> input = new ArrayList<>();
        HashSet<String> end = new HashSet<>();
        ArrayList<ArrayList<Boolean>> wasUsed = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader
                    (new FileInputStream(inputName), StandardCharsets.UTF_8));
            String line;
            while ((line = br.readLine()) != null) {
                input.add(line.split(" "));
                wasUsed.add(new ArrayList<>());
            }
            br.close();
        } catch (IOException e) {
            throw new IllegalArgumentException("Нету файла по указанному пути или файл не соответсвует формату.");
        }
        for (ArrayList<Boolean> zzz : wasUsed)
            for (int i = 0; i < input.get(0).length; i++)
                zzz.add(false);

        for (String word : words) {
            for (int x = 0; x < input.size(); x++)
                for (int y = 0; y < input.get(0).length; y++)
                    if (input.get(x)[y].toUpperCase().equals(word.split("")[0].toUpperCase())) {
                        wasUsed.get(x).set(y, true);
                        if (encounter(input, word.split(""), x, y, 0, wasUsed)) {
                            end.add(word);
                            x = input.size();
                            break;
                        }
                    } else for (ArrayList<Boolean> zzz : wasUsed)
                        for (int i = 0; i < input.get(0).length; i++)
                            zzz.set(i, false);
        }
        Timer.stop("baldaSearcher");
        return end;
    }

    private static boolean encounter(ArrayList<String[]> inside, @NotNull String[] word,
                                     Integer x, Integer y, Integer leng,
                                     ArrayList<ArrayList<Boolean>> wasUsed) {
        if (leng + 1 == word.length) return true;
        if (x > 0)
            if (!wasUsed.get(x - 1).get(y))
                if (inside.get(x - 1)[y].toUpperCase().equals(word[leng + 1].toUpperCase())) {//вверх
                    leng++;
                    wasUsed.get(x).set(y, true);
                    if (encounter(inside, word, x - 1, y, leng, wasUsed)) {
                        return true;
                    } else leng--;
                }
        if (x < inside.size() - 1)
            if (!wasUsed.get(x + 1).get(y))
                if (inside.get(x + 1)[y].toUpperCase().equals(word[leng + 1].toUpperCase())) {//вниз
                    leng++;
                    wasUsed.get(x).set(y, true);
                    if (encounter(inside, word, x + 1, y, leng, wasUsed)) return true;
                    else leng--;
                }
        if (y > 0)
            if (!wasUsed.get(x).get(y - 1))
                if (inside.get(x)[y - 1].toUpperCase().equals(word[leng + 1].toUpperCase())) {//влево
                    leng++;
                    wasUsed.get(x).set(y, true);
                    if (encounter(inside, word, x, y - 1, leng, wasUsed)) return true;
                    else leng--;
                }
        if (y < inside.get(0).length - 1)
            if (!wasUsed.get(x).get(y + 1))
                if (inside.get(x)[y + 1].toUpperCase().equals(word[leng + 1].toUpperCase())) {//вправо
                    leng++;
                    wasUsed.get(x).set(y, true);
                    return encounter(inside, word, x, y + 1, leng, wasUsed);
                }
        return false;
    }
}
