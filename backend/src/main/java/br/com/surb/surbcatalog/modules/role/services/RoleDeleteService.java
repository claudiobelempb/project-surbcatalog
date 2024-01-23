package br.com.surb.surbcatalog.modules.role.services;

import br.com.surb.surbcatalog.modules.role.repositories.RoleRepository;
import br.com.surb.surbcatalog.shared.AppConstants.AppExceptionConstants;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppDataIntegrityViolationException;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppEntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class RoleDeleteService {
    private final RoleRepository roleRepository;

    public RoleDeleteService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional
    public void execute(UUID roleId) {
        try {
            roleRepository.delete(roleId);
        } catch (EmptyResultDataAccessException e) {
            throw new AppEntityNotFoundException(AppExceptionConstants.RESOURCE_NOT_FOUND + roleId);
        } catch (DataIntegrityViolationException e) {
            throw new AppDataIntegrityViolationException(AppExceptionConstants.DATA_INTEGRITY_VIOLATION + roleId);
        }
    }
}
