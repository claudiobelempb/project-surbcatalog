package br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService;

public class AppIllegalArgumentException extends RuntimeException {
    public AppIllegalArgumentException(String msg) {
        super(msg);
    }

}
