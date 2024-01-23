package br.com.surb.surbcatalog.modules.user.repositories;

import br.com.surb.surbcatalog.modules.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByuserId(UUID userId);

    Optional<User> findByUserIdAndActive(UUID userId, Boolean active);

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
