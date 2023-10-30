package br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService;

public class AppUnauthorizedException extends RuntimeException {
  public AppUnauthorizedException(String msg) {
    super(msg);
  }

}
