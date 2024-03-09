package br.com.surb.surbcatalog.modules.role.entities;

import br.com.surb.surbcatalog.modules.user.entities.User;
import br.com.surb.surbcatalog.shared.AppUtils.AppDateUtils;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tb_role")
public class Role implements Serializable, GrantedAuthority {

    @Serial
    private static final long serialVersionUID = -5041371626608434459L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String roleId;
    @Column(unique = true)
    private String authority;
    private Boolean active;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    @ManyToMany(mappedBy = "roles")
    private final Set<User> users = new HashSet<>();

    public Role(String roleId, String authoriry) {
        this.roleId = roleId;
        this.authority = authoriry;
    }


    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }


    @PrePersist
    public void prePersist() {
        roleId = String.valueOf(UUID.randomUUID());
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
}
