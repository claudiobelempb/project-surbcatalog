package br.com.surb.surbcatalog.modules.room.dto;

import br.com.surb.surbcatalog.modules.room.entities.Room;
import br.com.surb.surbcatalog.modules.room.validator.RoomCreateValid;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

//@RoomCreateValid
public class RoomDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -6069228199430630795L;

    private UUID roomId;
    private String name;
    private Integer seats;
    private Boolean active;

    private Instant createdAt;

    private Instant updatedAt;

    public RoomDTO(){}

    public RoomDTO(UUID roomId, String name, Integer seats, Boolean active, Instant createdAt, Instant updatedAt) {
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

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
