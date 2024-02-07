package br.com.surb.surbcatalog.shared.AppValidator;

import org.springframework.data.util.Streamable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppValidErrors implements Streamable<AppValidFieldMessage> {

    private final List<AppValidFieldMessage> appValidFieldMessages;

    public AppValidErrors() {
        this.appValidFieldMessages = new ArrayList<>();
    }

    public AppValidErrors addErrors(String field, String messageError) {
        return addErrors(new AppValidFieldMessage(field, messageError));
    }

    public AppValidErrors addErrors(AppValidFieldMessage appValidFieldMessage) {
        appValidFieldMessages.add(appValidFieldMessage);
        return this;
    }

    public AppValidFieldMessage getErrorIndex(int index) {
        return appValidFieldMessages.get(index);
    }

    public int getNumberOfErrors() {
        return appValidFieldMessages.size();
    }

    public boolean hasErrors() {
        return !appValidFieldMessages.isEmpty();
    }

    @Override
    public String toString() {
        return "AppValidateErrors{" + "validationErrorsList=" + appValidFieldMessages + '}';
    }

    @Override
    public Iterator<AppValidFieldMessage> iterator() {
        return appValidFieldMessages.iterator();
    }

}
