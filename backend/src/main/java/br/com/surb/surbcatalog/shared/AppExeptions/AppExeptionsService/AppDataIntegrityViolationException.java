package br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService;

public class AppDataIntegrityViolationException extends RuntimeException{
  public AppDataIntegrityViolationException(String message) {
    super(message);
  }
}
