package br.com.surb.surbcatalog.modules.role.entities;

import br.com.surb.surbcatalog.shared.AppUtils.AppDateUtils;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_role")
public class Role implements Serializable {

    @Serial
    private static final long serialVersionUID = -5041371626608434459L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID roleId;
    private String authority;
    private Boolean active;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public Role() {
    }

    private Role(Builder builder) {
        roleId = builder.roleId;
        authority = builder.authority;
        active = builder.active;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
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
        Role role = (Role) o;
        return Objects.equals(roleId, role.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId);
    }

    public static Builder newBuild() {
        return new Builder();
    }

    public static final class Builder {
        private UUID roleId;
        private String authority;
        private Boolean active;
        private OffsetDateTime createdAt;
        private OffsetDateTime updatedAt;

        private Builder() {
        }

        public Builder roleId(UUID roleId) {
            this.roleId = roleId;
            return this;
        }

        public Builder authority(String authority) {
            this.authority = authority;
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

        public Role build() {
            return new Role(this);
        }
    }
}
