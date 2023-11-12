package br.com.surb.surbcatalog.shared.AppValidator;

import org.springframework.data.util.Streamable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppValidationErrors implements Streamable<AppValidError> {

  private final List<AppValidError> validationErrorsList;

  public AppValidationErrors() {
    this.validationErrorsList = new ArrayList<>();
  }

  public AppValidationErrors addErrors(String field, String errorCode) {
    return addErrors(new AppValidError(field, errorCode));
  }

  public AppValidationErrors addErrors(AppValidError validationError) {
    validationErrorsList.add(validationError);
    return this;
  }

  public AppValidError getErrorIndex(int index) {
    return validationErrorsList.get(index);
  }

  public int getErrorOfNumber() {
    return validationErrorsList.size();
  }

  public boolean hasErrors(){
    return !validationErrorsList.isEmpty();
  }

  @Override
  public String toString() {
    return "AppValidateErrors{" +
            "validationErrorsList=" + validationErrorsList +
            '}';
  }

  @Override
  public Iterator<AppValidError> iterator() {
    return validationErrorsList.iterator();
  }

}
