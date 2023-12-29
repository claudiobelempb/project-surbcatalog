package br.com.surb.surbcatalog.modules.user.dto;

import br.com.surb.surbcatalog.modules.role.dto.RoleDTO;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class UserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -4188542304189279824L;

    private UUID userId;
    private UUID apiKey;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean active;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    private Set<RoleDTO> roles = new HashSet<>();

    public UserDTO() {
    }

    private UserDTO(Builder builder) {
        userId = builder.userId;
        apiKey = builder.apiKey;
        firstName = builder.firstName;
        lastName = builder.lastName;
        email = builder.email;
        active = builder.active;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
        roles = builder.roles;
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

    public static Builder newBuilderDTO() {
        return new Builder();
    }

    public static final class Builder {
        private UUID userId;
        private UUID apiKey;
        private String firstName;
        private String lastName;
        private String email;
        private Boolean active;
        private OffsetDateTime createdAt;
        private OffsetDateTime updatedAt;
        private Set<RoleDTO> roles;

        private Builder() {
        }

        public Builder userId(UUID userId) {
            this.userId = userId;
            return this;
        }

        public Builder apiKey(UUID apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder active(Boolean active) {
            this.active = active;
            return this;
        }

        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder updatedAt(OffsetDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder roles(Set<RoleDTO> roles) {
            this.roles = roles;
            return this;
        }

        public UserDTO build() {
            return new UserDTO(this);
        }
    }
}
