package br.com.surb.surbcatalog.shared.AppProperties;

import java.util.Objects;

public class AppEmailTemplate {
    private final String subject;
    private final String templateName;

    public AppEmailTemplate(String subject, String templateName) {
        this.subject = subject;
        this.templateName = templateName;
    }

    public String getSubject() {
        return subject;
    }

    public String getTemplateName() {
        return templateName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppEmailTemplate that = (AppEmailTemplate) o;
        return Objects.equals(subject, that.subject) && Objects.equals(templateName, that.templateName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject, templateName);
    }

    @Override
    public String toString() {
        return "AppEmailTemplate{" +
                "subject='" + subject + '\'' +
                ", templateName='" + templateName + '\'' +
                '}';
    }
}
