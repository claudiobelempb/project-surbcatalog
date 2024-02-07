package br.com.surb.surbcatalog.modules.role.dto;

import br.com.surb.surbcatalog.modules.role.entities.Role;
import br.com.surb.surbcatalog.modules.user.dto.UserDTO;
import br.com.surb.surbcatalog.modules.user.entities.User;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class RoleDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -1098897813427276436L;

    private UUID roleId;
    private String authority;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private Boolean active;
    private final Set<UserDTO> users = new HashSet<>();

    public RoleDTO() {
    }

    public RoleDTO(UUID roleId, String authority, OffsetDateTime createdAt, OffsetDateTime updatedAt, Boolean active) {
        this.roleId = roleId;
        this.authority = authority;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.active = active;
    }

    public RoleDTO(Role entity) {
        roleId = entity.getRoleId();
        authority = entity.getAuthority();
        createdAt = entity.getCreatedAt();
        updatedAt = entity.getUpdatedAt();
        active = entity.getActive();
    }

    public RoleDTO(Role entity, Set<User> users) {
        this(entity);
        users.forEach(user -> this.users.add(new UserDTO(user)));
    }

    public UUID getRoleId() {
        return roleId;
    }

    public void setRoleId(UUID roleId) {
        this.roleId = roleId;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Set<UserDTO> getUsers() {
        return users;
    }
}
