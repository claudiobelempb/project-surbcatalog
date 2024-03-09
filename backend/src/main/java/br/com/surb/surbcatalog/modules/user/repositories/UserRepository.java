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
public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByuserId(String userId);

    Optional<User> findByUserIdAndActive(String userId, Boolean active);

    Optional<User> findByEmailAndActive(String email, Boolean active);

    /*
    SELECT  tb_user.email AS username, tb_user.password, tb_role.role_id, tb_role.authority
    FROM tb_user
    INNER JOIN tb_user_role ON tb_user.user_id = tb_user_role.user_id
    INNER JOIN tb_role ON tb_role.role_id = tb_user_role.role_id
    WHERE tb_user.email = 'claudio.c.lima@hotmail.com' AND tb_user.active = true
    */
    @Query(nativeQuery = true, value = "SELECT tb_user.user_id AS userId, tb_user.first_name AS firstName, tb_user.email AS username, tb_user.password, tb_role.role_id AS roleId, tb_role.authority " +
            "    FROM tb_user " +
            "    INNER JOIN tb_user_role ON tb_user.user_id = tb_user_role.user_id " +
            "    INNER JOIN tb_role ON tb_role.role_id = tb_user_role.role_id " +
            "    WHERE tb_user.email = :email AND tb_user.active = :active")
    List<UserDetailsPojection> seachUserAndRolesByEmailAndActive(String email, Boolean active);

    Optional<User> findByFirstNameAndActive(String firstName, Boolean active);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE User entity SET entity.active = false WHERE entity.userId = :userId")
    void deactivate(@Param("userId") String userId);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE User entity SET entity.active = true WHERE entity.userId = :userId")
    void activate(@Param("userId") String userId);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE User entity SET entity.firstName = :firstName WHERE entity.userId = :userId")
    void update(@Param("userId") String userId, @Param("firstName") String firstName);
}
