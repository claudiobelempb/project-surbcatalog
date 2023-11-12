package br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService;

public class AppMethodArgumentNotValidException extends RuntimeException{
    public AppMethodArgumentNotValidException(String msg){
        super(msg);
    }
}
