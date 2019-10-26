package lesson1.TimeCompare;

import lesson1.TimeClass;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

public class SecCompare implements Comparator<TimeClass> {
    public int compare(@NotNull TimeClass a, @NotNull TimeClass b) {
        return Integer.compare(a.getSec(), b.getSec());
    }
}
