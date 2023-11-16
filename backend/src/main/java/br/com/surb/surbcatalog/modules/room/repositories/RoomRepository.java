package br.com.surb.surbcatalog.modules.room.repositories;

import br.com.surb.surbcatalog.modules.room.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface RoomRepository extends JpaRepository<Room, UUID> {
    Optional<Room> findByRoomIdAndActive(UUID uuid, Boolean active);
    Optional<Room> findByNameAndActive(String name, Boolean active);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE Room r SET r.active = false WHERE r.roomId = :roomId")
    void deactivate(@Param("roomId") UUID roomId);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE Room r SET r.active = true WHERE r.roomId = :roomId")
    void activate(@Param("roomId") UUID roomId);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE Room r SET r.name = :name, r.seats = :seats WHERE r.roomId = :roomId")
    void update(@Param("roomId") UUID roomId, @Param("name") String name,@Param("seats") Integer seats);
}
