package br.com.surb.surbcatalog.modules.role.services;

import br.com.surb.surbcatalog.modules.role.dto.RoleDTO;
import br.com.surb.surbcatalog.modules.role.entities.Role;
import br.com.surb.surbcatalog.modules.role.repositories.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleCreateService {

    private final RoleRepository roleRepository;

    public RoleCreateService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional
    public RoleDTO execute(RoleDTO roleDTO) {
        Role role = new Role();
        role.setAuthority(roleDTO.getAuthority());
        roleRepository.save(role);
        return new RoleDTO(role);
    }
}
