package lesson1;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

public class TimeCompare implements Comparator<TimeClass> {
    public int compare(@NotNull TimeClass a, @NotNull TimeClass b) {
        if (a.getHour() == b.getHour())
            if (a.getMin() == b.getMin())
                return Integer.compare(a.getSec(), b.getSec());
            else return Integer.compare(a.getMin(), b.getMin());
        else
            return Integer.compare(a.getHour(), b.getHour());
    }
}
