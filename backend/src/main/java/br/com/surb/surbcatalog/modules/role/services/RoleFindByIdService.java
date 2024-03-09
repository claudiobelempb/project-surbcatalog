package br.com.surb.surbcatalog.modules.role.services;

import br.com.surb.surbcatalog.modules.role.dto.RoleDTO;
import br.com.surb.surbcatalog.modules.role.entities.Role;
import br.com.surb.surbcatalog.modules.role.repositories.RoleRepository;
import br.com.surb.surbcatalog.shared.AppConstants.AppExceptionConstants;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppEntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoleFindByIdService {
    private final RoleRepository roleRepository;

    public RoleFindByIdService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional(readOnly = true)
    public RoleDTO execute(String roleId){
        Objects.requireNonNull(roleId);
        Role entity = roleRepository
                .findByRoleIdAndActive(roleId, true)
                .orElseThrow(() -> new AppEntityNotFoundException(AppExceptionConstants.NOT_FOUND + roleId));
        return RoleDTO.builder().roleId(entity.getRoleId()).authority(entity.getAuthority()).build();
    }
}
