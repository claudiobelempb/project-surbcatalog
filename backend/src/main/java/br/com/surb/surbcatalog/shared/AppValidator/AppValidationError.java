package br.com.surb.surbcatalog.shared.AppValidator;

import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsResource.AppFieldMessage;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsResource.AppStandarError;

import java.util.ArrayList;
import java.util.List;

public class AppValidationError extends AppStandarError {
  private final List<AppFieldMessage> errors = new ArrayList<>();

  public List<AppFieldMessage> getErrors() {
    return errors;
  }

  public void addError( String field, String fieldName, String message) {
    errors.add(new AppFieldMessage( field, fieldName, message));
  }
}
