package br.com.surb.surbcatalog.shared.AppProperties;

import br.com.surb.surbcatalog.shared.AppEnums.TemplateType;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties(prefix = "appConfig.email.templates")
public class AppTemplateConfigProperties {
    private final Map<String, AppEmailTemplate> appEmailTemplateMap;


    public AppTemplateConfigProperties(Map<String, AppEmailTemplate> appEmailTemplateMap) {
        this.appEmailTemplateMap = appEmailTemplateMap;
    }

    public AppEmailTemplate getEmailTemplate(TemplateType templateType) {
        return appEmailTemplateMap.get(templateType.getTemplateName());
    }
}
