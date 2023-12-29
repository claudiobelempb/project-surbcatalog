package br.com.surb.surbcatalog.modules.role.dto;

import br.com.surb.surbcatalog.modules.role.entities.Role;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;

public class RoleDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 4481838943638259330L;

    private UUID roleId;
    private String authority;
    private Boolean active;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public RoleDTO() {
    }

    public RoleDTO(UUID roleId, String authority, Boolean active, OffsetDateTime createdAt, OffsetDateTime updatedAt) {
        this.roleId = roleId;
        this.authority = authority;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public RoleDTO(Role entity) {
        roleId = entity.getRoleId();
        authority = entity.getAuthority();
        active = entity.getActive();
        createdAt = entity.getCreatedAt();
        updatedAt = entity.getUpdatedAt();
    }

    public UUID getRoleId() {
        return roleId;
    }

    public String getAuthority() {
        return authority;
    }

    public Boolean getActive() {
        return active;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

}
