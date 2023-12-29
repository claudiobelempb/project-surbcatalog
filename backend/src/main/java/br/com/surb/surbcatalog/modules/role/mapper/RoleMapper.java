package br.com.surb.surbcatalog.modules.role.mapper;

import br.com.surb.surbcatalog.modules.role.dto.RoleDTO;
import br.com.surb.surbcatalog.modules.role.entities.Role;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public abstract class RoleMapper {
    public abstract RoleDTO fromEntityToDTO(Role entity);
    public abstract Role fromDTOToEntity(RoleDTO dto);
}
