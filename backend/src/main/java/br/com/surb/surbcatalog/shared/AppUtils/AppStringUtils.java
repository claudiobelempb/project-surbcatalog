package br.com.surb.surbcatalog.shared.AppUtils;

import org.apache.logging.log4j.util.Strings;

import java.util.List;

public final class AppStringUtils {
    public static String join(List<String> list) {
        return Strings.join(list, ',');
    }
}
