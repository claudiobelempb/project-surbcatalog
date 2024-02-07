package br.com.surb.surbcatalog.modules.user.repositories;

import br.com.surb.surbcatalog.modules.user.entities.User;
import br.com.surb.surbcatalog.modules.user.projections.UserDetailsPojection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByuserId(UUID userId);

    Optional<User> findByUserIdAndActive(UUID userId, Boolean active);

    Optional<User> findByEmailAndActive(String email, Boolean active);

    /*
    SELECT  tb_user.email AS username, tb_user.password, tb_role.role_id, tb_role.authority
FROM tb_user
INNER JOIN tb_user_role ON tb_user.user_id = tb_user_role.user_id
INNER JOIN tb_role ON tb_role.role_id = tb_user_role.role_id
WHERE tb_user.email = 'claudio.c.lima@hotmail.com'
    */
    @Query(nativeQuery = true, value =
            "SELECT tb_user.email AS username, tb_user.password, tb_role.roleId, tb_role.authority " +
                    "FROM tb_user " +
                    "INNER JOIN tb_user_role ON tb_user.userId = tb_user_role.user_id " +
                    "INNER JOIN tb_role ON tb_role_id = tb_user_role.role_id " +
                    "WHERE tb_user.email = :email ")
    List<UserDetailsPojection> seachUserAndRolesByEmail(String email);

    Optional<User> findByFirstNameAndActive(String firstName, Boolean active);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE User entity SET entity.active = false WHERE entity.userId = :userId")
    void deactivate(@Param("userId") UUID userId);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE User entity SET entity.active = true WHERE entity.userId = :userId")
    void activate(@Param("userId") UUID userId);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE User entity SET entity.firstName = :firstName WHERE entity.userId = :userId")
    void update(@Param("userId") UUID userId, @Param("firstName") String firstName);
}
