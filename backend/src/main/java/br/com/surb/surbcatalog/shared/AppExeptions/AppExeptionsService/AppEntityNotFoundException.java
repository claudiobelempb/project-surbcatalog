package br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService;

public class AppEntityNotFoundException extends RuntimeException{
  public AppEntityNotFoundException(String message) {
    super(message);
  }
}
