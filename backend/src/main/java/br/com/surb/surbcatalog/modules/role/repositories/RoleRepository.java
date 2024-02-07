package br.com.surb.surbcatalog.modules.role.repositories;

import br.com.surb.surbcatalog.modules.role.entities.Role;
import br.com.surb.surbcatalog.modules.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {
    boolean existsByRoleId(UUID roleId);

    Optional<Role> findByRoleIdAndActive(UUID roleId, Boolean active);
    Optional<Role> findByAuthorityAndActive(String email, Boolean active);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE Role entity SET entity.active = false WHERE entity.roleId = :roleId")
    void deactive(@Param("roleId") UUID roleId);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE Role entity SET entity.active = true WHERE entity.roleId = :roleId")
    void activate(@Param("roleId") UUID roleId);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE Role entity SET entity.authority = :authority WHERE entity.roleId = :roleId")
    void update(@Param("roleId") UUID categoryId, @Param("authority") String authority);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("DELETE Role entity WHERE entity.roleId = :roleId")
    void delete(@Param("roleId") UUID roleId);
}
