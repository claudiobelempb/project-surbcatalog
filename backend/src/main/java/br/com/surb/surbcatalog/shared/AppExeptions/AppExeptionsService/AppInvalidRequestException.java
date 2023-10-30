package br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService;


import br.com.surb.surbcatalog.shared.AppValidator.AppValidateErrors;

public class AppInvalidRequestException extends RuntimeException {

  private final AppValidateErrors validationErrors;

  public AppInvalidRequestException(AppValidateErrors validationErrors) {
    super(validationErrors.toString());
    this.validationErrors = validationErrors;
  }

  public AppValidateErrors getValidateErrors() {
    return validationErrors;
  }
}