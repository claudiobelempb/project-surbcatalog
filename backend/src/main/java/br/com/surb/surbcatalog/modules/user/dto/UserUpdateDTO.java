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

public class UserUpdateDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 3673800532696994621L;
    private final UUID userId;
    private final UUID apiKey;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Boolean active;
    private final OffsetDateTime createdAt;
    private final OffsetDateTime updatedAt;
    private final Set<RoleDTO> roles = new HashSet<>();

    public UserUpdateDTO(UUID userId, UUID apiKey, String firstName, String lastName, String email, Boolean active, OffsetDateTime createdAt, OffsetDateTime updatedAt) {
        this.userId = userId;
        this.apiKey = apiKey;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UserUpdateDTO(User entity) {
        userId = entity.getUserId();
        apiKey = entity.getApiKey();
        firstName = entity.getFirstName();
        lastName = entity.getLastName();
        email = entity.getEmail();
        active = entity.getActive();
        createdAt = entity.getCreatedAt();
        updatedAt = entity.getUpdatedAt();
    }

    public UserUpdateDTO(User entity, Set<Role> roles) {
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
