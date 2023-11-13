package br.com.surb.surbcatalog.modules.room.repositories;

import br.com.surb.surbcatalog.modules.room.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface RoomRepository extends JpaRepository<Room, UUID> {
    //Optional<Room> findByIdAndActive(UUID uuid, Boolean active);
    Optional<Room> findByNameAndActive(String name, Boolean active);
}
