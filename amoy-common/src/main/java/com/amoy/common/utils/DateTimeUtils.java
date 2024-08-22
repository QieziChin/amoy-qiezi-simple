package com.amoy.common.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeUtils {

    /**
     * 分割范围
     * @param time
     * @return
     */
    public static long[] range(String time){
        String[] dt = time.split("~");
        long[] result = {Long.parseLong(dt[0]), Long.parseLong(dt[1])};
        return result;
    }

    public static String getPast(String time){
        Locale brazil = new Locale("pt", "BR");

        //String welcomeMessage = messageSource.getMessage("welcome_message", null, brazil);
        //System.out.println(welcomeMessage);

        DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
        LocalDateTime datetime = LocalDateTime.parse("2024-08-18T14:17:10.055Z", formatter);

        Period period = Period.between(datetime.toLocalDate(), LocalDate.now());
        Duration duration = Duration.between(datetime, LocalDateTime.now(ZoneId.of("Z")));

        if (period.getYears() > 0){
            return "Há " + period.getYears() + " ano" + (period.getYears() == 1 ? "" : "s");
        } else if (period.getMonths() > 0) {
            return "Há " + period.getMonths() + " mês" + (period.getMonths() == 1 ? "" : "s");
        } else if (period.getDays() > 0){
            return "Há " + period.getDays() + " dia" + (period.getDays() == 1 ? "" : "s");
        } else if (duration.toHours() > 0) {
            return "Há " + duration.toHours() + " hora" + (duration.toHours() == 1 ? "" : "s");
        } else if (duration.toMinutes() > 0) {
            return "Há " + duration.toMinutes() + " minuto" + (duration.toMinutes() == 1 ? "" : "s");
        } else {
            return "Agora";
        }
    }

}
