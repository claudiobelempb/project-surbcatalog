package br.com.surb.surbcatalog.modules.role.repositories;

import br.com.surb.surbcatalog.modules.role.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
    boolean existsByRoleId(String roleId);

    Optional<Role> findByRoleIdAndActive(String roleId, Boolean active);
    Optional<Role> findByAuthorityAndActive(String authority, Boolean active);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE Role entity SET entity.active = false WHERE entity.roleId = :roleId")
    void deactive(@Param("roleId") String roleId);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE Role entity SET entity.active = true WHERE entity.roleId = :roleId")
    void activate(@Param("roleId") String roleId);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE Role entity SET entity.authority = :authority WHERE entity.roleId = :roleId")
    void update(@Param("roleId") String categoryId, @Param("authority") String authority);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("DELETE Role entity WHERE entity.roleId = :roleId")
    void delete(@Param("roleId") String roleId);
}
