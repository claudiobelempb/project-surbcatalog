package br.com.surb.surbcatalog.shared.AppValidator;

import java.util.Objects;

public final class AppValidFieldMessage {
    private String fieldName;
    private String message;

    public AppValidFieldMessage() {
    }

    public AppValidFieldMessage(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        AppValidFieldMessage that = (AppValidFieldMessage) object;
        return Objects.equals(fieldName, that.fieldName) && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fieldName, message);
    }

    @Override
    public String toString() {
        return "AppValidFieldMessage{" +
                "fieldName='" + fieldName + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
