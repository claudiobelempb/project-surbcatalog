package br.com.surb.surbcatalog.modules.user.dto;

import br.com.surb.surbcatalog.modules.role.dto.RoleDTO;
import br.com.surb.surbcatalog.modules.role.entities.Role;
import br.com.surb.surbcatalog.modules.user.entities.User;
import br.com.surb.surbcatalog.shared.AppConstants.AppConfigConstants;
import br.com.surb.surbcatalog.shared.AppConstants.AppValidatorConstants;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class UserDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -5908003197666529037L;

    private String userId;
    private String apiKey;
    @NotBlank(message = AppValidatorConstants.REQUIRED_FIELD)
    @Size(min = 5, max = 60, message = AppValidatorConstants.MIN_MAX)
    private String firstName;
    @NotBlank(message = AppValidatorConstants.REQUIRED_FIELD)
    @Size(min = 5, max = 60, message = AppValidatorConstants.MIN_MAX)
    private String lastName;
    @Email(message = AppValidatorConstants.INVALID_EMAIL)
    private String email;
    private Boolean active;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    private final Set<RoleDTO> roles = new HashSet<>();

    public UserDTO() {
    }

    public UserDTO(String userId, String apiKey, String firstName, String lastName, String email, Boolean active, OffsetDateTime createdAt, OffsetDateTime updatedAt) {
        this.userId = userId;
        this.apiKey = apiKey;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UserDTO(User entity) {
        userId = entity.getUserId();
        apiKey = entity.getApiKey();
        firstName = entity.getFirstName();
        lastName = entity.getLastName();
        email = entity.getEmail();
        active = entity.getActive();
        createdAt = entity.getCreatedAt();
        updatedAt = entity.getUpdatedAt();
        entity.getRoles().forEach(role -> this.roles.add(RoleDTO.builder().roleId(role.getRoleId()).authority(role.getAuthority()).build()));
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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

    public Set<RoleDTO> getRoles() {
        return roles;
    }

}
