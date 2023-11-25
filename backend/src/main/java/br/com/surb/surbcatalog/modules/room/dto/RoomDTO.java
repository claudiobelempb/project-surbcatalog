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

    private RoomDTO(UUID roomId, String name, Integer seats, Boolean active, OffsetDateTime createdAt, OffsetDateTime updatedAt) {
        this.roomId = roomId;
        this.name = name;
        this.seats = seats;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public RoomDTO(RoomDTOBuilder builder){
        roomId = builder.roomId;
        name = builder.name;
        seats = builder.seats;
        active = builder.active;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
    }

    public UUID getRoomId() {
        return roomId;
    }

    public String getName() {
        return name;
    }

    public Integer getSeats() {
        return seats;
    }

    public Boolean getActive() {
        return active;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public static RoomDTOBuilder newRoomDTO() {
        return new RoomDTOBuilder();
    }

    public static final class RoomDTOBuilder {
        private UUID roomId;
        private String name;
        private Integer seats;
        private Boolean active;
        private OffsetDateTime createdAt;
        private OffsetDateTime updatedAt;

        private RoomDTOBuilder() {
        }

        public RoomDTOBuilder roomId(UUID roomId) {
            this.roomId = roomId;
            return this;
        }

        public RoomDTOBuilder name(String name) {
            this.name = name;
            return this;
        }

        public RoomDTOBuilder seats(Integer seats) {
            this.seats = seats;
            return this;
        }

        public RoomDTOBuilder active(Boolean active) {
            this.active = active;
            return this;
        }

        public RoomDTOBuilder createdAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public RoomDTOBuilder updatedAt(OffsetDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public RoomDTO build() {
            return new RoomDTO(this);
        }
    }
}
