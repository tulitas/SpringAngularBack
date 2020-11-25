package backend.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {

    LocalDateTime time = LocalDateTime.now();
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private String formatedTime = time.format(timeFormatter);

    public String getFormatedTime() {
        return formatedTime;
    }

    public void setFormatedTime(String formatedTime) {
        this.formatedTime = formatedTime;
    }

    @Override
    public String toString() {
        return "DateTime{" +
                "formatedTime='" + formatedTime + '\'' +
                '}';
    }
}
