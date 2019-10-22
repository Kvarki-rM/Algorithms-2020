package lesson1;
import org.jetbrains.annotations.NotNull;

class TimeClass {
    int hour;
    int min;
    int sec;
    String full;

    TimeClass(@NotNull String full) {
        this.full = full;
        String[] temp1 = full.split(" ");
        String[] temp2 = temp1[0].split(":");
        this.min = Integer.parseInt(temp2[1]);
        this.sec = Integer.parseInt(temp2[2]);

        if (temp1[1].equals("PM")) {
            this.hour = 12 + Integer.parseInt(temp2[0]);
            if (this.hour == 24)
                this.hour = 12;
        } else {
            this.hour = Integer.parseInt(temp2[0]);
            if (this.hour == 12)
                this.hour = 0;
        }
    }

}