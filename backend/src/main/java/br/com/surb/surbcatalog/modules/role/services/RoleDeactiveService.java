package br.com.surb.surbcatalog.modules.role.services;

import br.com.surb.surbcatalog.modules.role.entities.Role;
import br.com.surb.surbcatalog.modules.role.repositories.RoleRepository;
import br.com.surb.surbcatalog.shared.AppConstants.AppExceptionConstants;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppEntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.UUID;

@Service
public class RoleDeactiveService {
    private final RoleRepository roleRepository;

    public RoleDeactiveService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional
    public void execute(UUID roleId) {
        Objects.requireNonNull(roleId);
        Role entity = roleRepository.findByRoleIdAndActive(roleId, true)
                .orElseThrow(() -> new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + roleId));
        entity.setActive(false);
        roleRepository.save(entity);
        roleRepository.deactive(roleId);
    }
}
