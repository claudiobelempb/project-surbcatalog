package br.com.surb.surbcatalog.modules.role.services;

import br.com.surb.surbcatalog.modules.role.dto.RoleDTO;
import br.com.surb.surbcatalog.modules.role.entities.Role;
import br.com.surb.surbcatalog.modules.role.repositories.RoleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleFindAllService {

    private final RoleRepository roleRepository;

    public RoleFindAllService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional(readOnly = true)
    public Page<RoleDTO> execute(Pageable pageable) {
        Page<Role> roles = roleRepository.findAll(pageable);
        return roles.map((role) -> RoleDTO.builder().roleId(role.getRoleId()).authority(role.getAuthority()).build());
    }
}
