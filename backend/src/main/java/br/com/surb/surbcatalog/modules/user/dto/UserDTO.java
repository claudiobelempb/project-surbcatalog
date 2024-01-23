package br.com.surb.surbcatalog.modules.user.dto;

import br.com.surb.surbcatalog.modules.role.dto.RoleDTO;
import br.com.surb.surbcatalog.modules.role.entities.Role;
import br.com.surb.surbcatalog.modules.user.entities.User;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class UserDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -5908003197666529037L;

    private final UUID userId;
    private final UUID apiKey;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Boolean active;
    private final OffsetDateTime createdAt;
    private final OffsetDateTime updatedAt;
    private final Set<RoleDTO> roles = new HashSet<>();

    public UserDTO(User entity) {
        this.userId = entity.getUserId();
        this.apiKey = entity.getApiKey();
        this.firstName = entity.getFirstName();
        this.lastName = entity.getLastName();
        this.email = entity.getEmail();
        this.active = entity.getActive();
        this.createdAt = entity.getCreatedAt();
        this.updatedAt = entity.getUpdatedAt();
    }

    public UserDTO(User entity, Set<Role> roles) {
        this(entity);
        roles.forEach(role -> this.roles.add(new RoleDTO(role)));
    }

    public UUID getUserId() {
        return userId;
    }

    public UUID getApiKey() {
        return apiKey;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
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

    public Set<RoleDTO> getRoles() {
        return roles;
    }
}
