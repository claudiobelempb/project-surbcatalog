package br.com.surb.surbcatalog.shared.AppUtils;

import org.apache.logging.log4j.util.Strings;

import java.util.List;

public final class AppStringUtils {
    /*Converte um lista e separa por virgula*/
    public static String AppStringUltilsJoin(List<String> list) {
        return Strings.join(list, ',');
    }
}
