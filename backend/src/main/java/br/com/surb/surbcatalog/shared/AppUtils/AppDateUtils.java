package br.com.surb.surbcatalog.shared.AppUtils;

import java.time.*;
import java.util.Date;

import static java.time.ZoneId.systemDefault;

public final class AppDateUtils {

    public static final ZoneOffset DEFAULT_TIMEZONE = ZoneOffset.of("-03:00");
    private AppDateUtils(){}

    public static OffsetDateTime now(){
        return OffsetDateTime.now(DEFAULT_TIMEZONE);
    }

    public static boolean isOverLapping(
            OffsetDateTime start,
            OffsetDateTime end,
            OffsetDateTime newStart,
            OffsetDateTime newEnd
    ){
        return start.isBefore(newEnd) && end.isAfter(newStart);
        //return start.compareTo(newEnd) < 0 && end.compareTo(newStart) > 0;
    }

    public static Date generateExpirationDate(int expirationMinutes){
        LocalDateTime now = LocalDateTime.now().plusMinutes(expirationMinutes);
        return Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
    }
}
