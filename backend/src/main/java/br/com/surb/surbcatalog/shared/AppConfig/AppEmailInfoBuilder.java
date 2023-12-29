package br.com.surb.surbcatalog.shared.AppConfig;

import br.com.surb.surbcatalog.modules.email.entities.Attachment;
import br.com.surb.surbcatalog.modules.email.entities.EmailInfo;
import br.com.surb.surbcatalog.shared.AppEnums.TemplateType;
import br.com.surb.surbcatalog.shared.AppProperties.AppEmailConfigProperties;
import br.com.surb.surbcatalog.shared.AppProperties.AppEmailTemplate;
import br.com.surb.surbcatalog.shared.AppProperties.AppTemplateConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class AppEmailInfoBuilder {
    private final AppEmailConfigProperties appEmailConfigProperties;
    private final AppTemplateConfigurationProperties appTemplateConfigurationProperties;

    public AppEmailInfoBuilder(AppEmailConfigProperties appEmailConfigProperties, AppTemplateConfigurationProperties appTemplateConfigurationProperties) {
        this.appEmailConfigProperties = appEmailConfigProperties;
        this.appTemplateConfigurationProperties = appTemplateConfigurationProperties;
    }

    public EmailInfo createEmailInfo(
            String email,
            TemplateType templateType,
            Map<String, Object> templateData
    ) {
        return createEmailInfo(email, templateType, templateData, null);
    }

    public EmailInfo createEmailInfo(
            String email,
            TemplateType templateType,
            Map<String, Object> templateData,
            List<Attachment> attachments
    ) {
        AppEmailTemplate emailTemplate = appTemplateConfigurationProperties.getEmailTemplate(templateType);
        return EmailInfo
                .newBuilder()
                .from(appEmailConfigProperties.getFrom())
                .subject(emailTemplate.getSubject())
                .to(List.of(email))
                .template(emailTemplate.getTemplateName())
                .templateData(templateData)
                .attachments(attachments)
                .build();
    }
}
