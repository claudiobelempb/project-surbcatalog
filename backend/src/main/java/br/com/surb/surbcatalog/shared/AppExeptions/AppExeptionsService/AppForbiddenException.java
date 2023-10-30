package br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService;

public class AppForbiddenException  extends RuntimeException{
  public AppForbiddenException(String msg){
    super(msg);
  }
}
