package br.com.surb.surbcatalog.shared.AppValidator;

import org.springframework.data.util.Streamable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppValidationErrors implements Streamable<AppValidError> {

    private final List<AppValidError> appValidErrors;

    public AppValidationErrors() {
        this.appValidErrors = new ArrayList<>();
    }

    public AppValidationErrors addErrors(String field, String errorCode) {
        return addErrors(new AppValidError(field, errorCode));
    }

    public AppValidationErrors addErrors(AppValidError validationError) {
        appValidErrors.add(validationError);
        return this;
    }

    public AppValidError getErrorIndex(int index) {
        return appValidErrors.get(index);
    }

    public int getNumberOfErrors() {
        return appValidErrors.size();
    }

    public boolean hasErrors() {
        return !appValidErrors.isEmpty();
    }

    @Override
    public String toString() {
        return "AppValidateErrors{" + "validationErrorsList=" + appValidErrors + '}';
    }

    @Override
    public Iterator<AppValidError> iterator() {
        return appValidErrors.iterator();
    }

}
