package br.com.surb.surbcatalog.modules.room.repositories;

import br.com.surb.surbcatalog.modules.room.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface RoomRepository extends JpaRepository<Room, UUID> {
}
