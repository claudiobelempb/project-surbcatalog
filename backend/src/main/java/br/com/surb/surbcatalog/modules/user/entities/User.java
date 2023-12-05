package br.com.surb.surbcatalog.modules.user.entities;

import br.com.surb.surbcatalog.shared.AppUtils.AppDateUtils;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = -6368521662983269176L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;
    private String apiKey;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean active;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public User() {
    }

    private User(UserBuilder userBuilder) {
        userId = userBuilder.userId;
        apiKey = userBuilder.apiKey;
        firstName = userBuilder.firstName;
        lastName = userBuilder.lastName;
        email = userBuilder.email;
        active = userBuilder.active;
        createdAt = userBuilder.createdAt;
        updatedAt = userBuilder.updatedAt;
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

    @PrePersist
    public void prePersist() {
        createdAt = AppDateUtils.now();
        updatedAt = createdAt;
        active = true;
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = AppDateUtils.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(apiKey, user.apiKey) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email) && Objects.equals(active, user.active) && Objects.equals(createdAt, user.createdAt) && Objects.equals(updatedAt, user.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, apiKey, firstName, lastName, email, active, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", apiKey='" + apiKey + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", active=" + active +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public static UserBuilder newUserBuilder() {
        return new UserBuilder();
    }

    public static final class UserBuilder {
        private UUID userId;
        private String apiKey;
        private String firstName;
        private String lastName;
        private String email;
        private Boolean active;
        private OffsetDateTime createdAt;
        private OffsetDateTime updatedAt;

        private UserBuilder() {
        }

        public UserBuilder userId(UUID userId) {
            this.userId = userId;
            return this;
        }

        public UserBuilder apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public UserBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder active(Boolean active) {
            this.active = active;
            return this;
        }

        public UserBuilder createdAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public UserBuilder updatedAt(OffsetDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
