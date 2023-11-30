package br.com.surb.surbcatalog.modules.allocation.repositories;

import br.com.surb.surbcatalog.modules.allocation.entities.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation, UUID> {
    Optional<Allocation> findBySubjectAndActive(String subject, boolean active);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE Allocation a SET a.active = false WHERE a.allocationId = :allocationId")
    void deactivate(@Param("allocationId") UUID allocationId);

    /*----------------------------------------------------------------*/
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE Allocation a SET a.active = true WHERE a.allocationId = :allocationId")
    void activate(@Param("allocationId") UUID allocationId);

    /*----------------------------------------------------------------*/
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE Allocation a " +
            "SET a.subject = :subject, a.startAt = :startAt, a.endAt = :endAt " +
            "WHERE a.allocationId = :allocationId")
    void update(
            @Param("allocationId") UUID allocationId,
            @Param("subject") String subject,
            @Param("startAt") OffsetDateTime startAt,
            @Param("endAt") OffsetDateTime endAt);

    /*----------------------------------------------------------------*/
    /*
    SELECT  * FROM tb_allocation WHERE
    (user_id = '84794b77-dd91-4050-9831-7de6007d103e') AND
    (room_id = 'fd1616cf-38b2-40d0-8241-96ebd303435d') AND
    (start_at >= '2023-11-27 11:54:28.48+00') AND
    (end_at <= '2023-11-27 11:54:28.48+00')
    */
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("SELECT a FROM Allocation a WHERE" +
            "(:userId IS NULL OR a.user.userId = :userId) AND " +
            "(:roomId IS NULL OR a.room.roomId = :roomId) AND " +
            "(:startAt IS NULL OR a.startAt >= :startAt) AND " +
            "(:endAt IS NULL OR a.endAt <= :endAt)"
    )
    List<Allocation> findAllwitnFilters(
            @Param("userId") UUID userId,
            @Param("roomId") UUID roomId,
            @Param("startAt") OffsetDateTime startAt,
            @Param("endAt") OffsetDateTime endAt);
}
