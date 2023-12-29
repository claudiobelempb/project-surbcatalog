package br.com.surb.surbcatalog.modules.allocation.services;

import br.com.surb.surbcatalog.modules.allocation.entities.Allocation;
import br.com.surb.surbcatalog.modules.email.services.EmailSendService;
import br.com.surb.surbcatalog.shared.AppConfig.AppEmailInfoBuilder;
import br.com.surb.surbcatalog.shared.AppEnums.TemplateType;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AllocationNotificationService {
    private static final String ALLOCATION = "allocation";
    private final EmailSendService emailSendService;
    private final AppEmailInfoBuilder appEmailInfoBuilder;

    public AllocationNotificationService(EmailSendService emailSendService, AppEmailInfoBuilder appEmailInfoBuilder) {
        this.emailSendService = emailSendService;
        this.appEmailInfoBuilder = appEmailInfoBuilder;
    }

    public void notifyAllocationCreate(Allocation allocation) {
        notify(allocation, TemplateType.CREATED);
    }

    public void notifyAllocationUpdate(Allocation allocation) {
        notify(allocation, TemplateType.UPDATED);
    }

    public void notifyAllocationDelete(Allocation allocation) {
        notify(allocation, TemplateType.DELETED);
    }

    private void notify(Allocation allocation, TemplateType templateType) {
        /*EmailInfo emailInfo = appEmailInfoBuilder.createEmailInfo(
                allocation.getUser().getEmail(),
                templateType,
                Map.of(ALLOCATION, allocation));*/
        emailSendService.send(
                appEmailInfoBuilder.createEmailInfo(
                        allocation.getUser().getEmail(),
                        templateType,
                        Map.of(ALLOCATION, allocation)
                )
        );
    }
}
