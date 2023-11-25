package br.com.surb.surbcatalog.modules.allocation.repositories;

import br.com.surb.surbcatalog.modules.allocation.entities.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation, UUID> {
    Optional<Allocation> findBySubjectAndActive(String subject, boolean active);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE Allocation a SET a.active = false WHERE a.allocationId = :allocationId")
    void deactivate(@Param("allocationId") UUID allocationId);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE Allocation a SET a.active = true WHERE a.allocationId = :allocationId")
    void activate(@Param("allocationId") UUID allocationId);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE Allocation a " +
            "SET a.subject = :subject, a.startAt = :startAt, a.endAt = :endAt " +
            "WHERE a.allocationId = :allocationId")
    void update(
            @Param("allocationId") UUID allocationId,
            @Param("subject") String subject,
            @Param("startAt") OffsetDateTime startAt,
            @Param("endAt") OffsetDateTime endAt);
}
