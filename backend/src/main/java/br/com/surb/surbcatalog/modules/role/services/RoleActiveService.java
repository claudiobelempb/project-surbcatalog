package br.com.surb.surbcatalog.modules.role.services;

import br.com.surb.surbcatalog.modules.role.dto.RoleDTO;
import br.com.surb.surbcatalog.modules.role.entities.Role;
import br.com.surb.surbcatalog.modules.role.repositories.RoleRepository;
import br.com.surb.surbcatalog.shared.AppConstants.AppExceptionConstants;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppEntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.UUID;

@Service
public class RoleActiveService {
    private final RoleRepository roleRepository;

    public RoleActiveService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional
    public void execute(String roleId){
        Objects.requireNonNull(roleId);
        Role entity = roleRepository
                .findByRoleIdAndActive(roleId, false)
                .orElseThrow(() -> new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + roleId));
        entity.setActive(false);
        roleRepository.save(entity);
        roleRepository.activate(roleId);
    }
}
