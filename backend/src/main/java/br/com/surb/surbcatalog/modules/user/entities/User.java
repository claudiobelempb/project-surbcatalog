package br.com.surb.surbcatalog.modules.user.entities;

import br.com.surb.surbcatalog.modules.role.entities.Role;
import br.com.surb.surbcatalog.shared.AppUtils.AppDateUtils;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = -6368521662983269176L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;
    private UUID apiKey;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Boolean active;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    private User(Builder builder) {
        userId = builder.userId;
        apiKey = builder.apiKey;
        firstName = builder.firstName;
        lastName = builder.lastName;
        email = builder.email;
        password = builder.password;
        active = builder.active;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
        roles = builder.roles;
    }

    private User(Builder builder, Set<Role> roles) {
        this(builder);
        this.roles.addAll(roles);
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

    public String getPassword() {
        return password;
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

    public Set<Role> getRoles() {
        return roles;
    }

    @PrePersist
    public void prePersist() {
        apiKey = UUID.randomUUID();
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
        return Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private UUID userId;
        private UUID apiKey;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private Boolean active;
        private OffsetDateTime createdAt;
        private OffsetDateTime updatedAt;
        private Set<Role> roles = new HashSet<>();

        public Builder() {
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

        public Builder password(String password) {
            this.password = password;
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

        public Builder roles(Set<Role> roles) {
            this.roles = roles;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
