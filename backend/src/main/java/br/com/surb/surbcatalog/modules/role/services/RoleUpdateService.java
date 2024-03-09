package br.com.surb.surbcatalog.modules.role.services;

import br.com.surb.surbcatalog.modules.role.dto.RoleDTO;
import br.com.surb.surbcatalog.modules.role.entities.Role;
import br.com.surb.surbcatalog.modules.role.repositories.RoleRepository;
import br.com.surb.surbcatalog.shared.AppConstants.AppExceptionConstants;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppEntityNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.UUID;

@Service
public class RoleUpdateService {
    private final RoleRepository roleRepository;

    public RoleUpdateService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional
    public RoleDTO execute(String roleId, RoleDTO dto) {
        try {
            Objects.requireNonNull(roleId);
            Role entity = roleRepository
                    .findByRoleIdAndActive(roleId, true)
                    .orElseThrow(() -> new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + roleId));
            entity.setAuthority(dto.getAuthority());
            entity = roleRepository.save(entity);
            return RoleDTO.builder().roleId(entity.getRoleId()).authority(entity.getAuthority()).build();
        } catch (EntityNotFoundException e) {
            throw new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + roleId);
        }
    }
}
