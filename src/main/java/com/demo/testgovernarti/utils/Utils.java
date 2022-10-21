package com.demo.testgovernarti.utils;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Predicate;

@Component
public class Utils {
    private final String pattern = "yyyy-MM-dd";

    public Long getGapDays(String d1, String d2) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        var firstDate = simpleDateFormat.parse(d1);
        var secondDate = simpleDateFormat.parse(d2);

        long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        return diff;
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
}
