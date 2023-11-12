package br.com.surb.surbcatalog.shared.AppUtils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public final class AppResponseEntityUtils {
    private AppResponseEntityUtils(){}

    public static <T> ResponseEntity<T> ok(T body){
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }
    public static <T> ResponseEntity<T> created(T body){
        return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }
}
