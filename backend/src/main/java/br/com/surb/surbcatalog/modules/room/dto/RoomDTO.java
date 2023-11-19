package br.com.surb.surbcatalog.modules.room.dto;

import br.com.surb.surbcatalog.modules.room.entities.Room;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.UUID;

//@RoomCreateValid
public class RoomDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -6069228199430630795L;

    private UUID roomId;
    private String name;
    private Integer seats;
    private Boolean active;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;

    public RoomDTO(){}

    public RoomDTO(UUID roomId, String name, Integer seats, Boolean active, OffsetDateTime createdAt, OffsetDateTime updatedAt) {
        this.roomId = roomId;
        this.name = name;
        this.seats = seats;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public RoomDTO(Room entity){
        roomId = entity.getRoomId();
        name = entity.getName();
        seats = entity.getSeats();
        active = entity.getActive();
        createdAt = entity.getCreatedAt();
        updatedAt = entity.getUpdatedAt();
    }

    public UUID getRoomId() {
        return roomId;
    }

    public void setRoomId(UUID roomId) {
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
