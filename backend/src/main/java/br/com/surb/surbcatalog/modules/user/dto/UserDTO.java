package br.com.surb.surbcatalog.modules.user.dto;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;

public class UserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -4188542304189279824L;

    private UUID userId;
    private String apiKey;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean active;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public UserDTO() {
    }

    private UserDTO(UserDTOBuilder builder) {
        userId = builder.userId;
        apiKey = builder.apiKey;
        firstName = builder.firstName;
        lastName = builder.lastName;
        email = builder.email;
        active = builder.active;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getApiKey() {
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

    public static UserDTOBuilder newUserDTO() {
        return new UserDTOBuilder();
    }

    public static final class UserDTOBuilder {
        private UUID userId;
        private String apiKey;
        private String firstName;
        private String lastName;
        private String email;
        private Boolean active;
        private OffsetDateTime createdAt;
        private OffsetDateTime updatedAt;

        private UserDTOBuilder() {
        }

        public UserDTOBuilder userId(UUID userId) {
            this.userId = userId;
            return this;
        }

        public UserDTOBuilder apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public UserDTOBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserDTOBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserDTOBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserDTOBuilder active(Boolean active) {
            this.active = active;
            return this;
        }

        public UserDTOBuilder createdAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public UserDTOBuilder updatedAt(OffsetDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public UserDTO build() {
            return new UserDTO(this);
        }
    }
}
