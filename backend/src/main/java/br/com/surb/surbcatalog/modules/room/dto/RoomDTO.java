package br.com.surb.surbcatalog.modules.room.dto;

import java.io.Serial;
import java.io.Serializable;
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

    public RoomDTO() {
    }

    private RoomDTO(Builder builder) {
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

    public static Builder newBuilderDTO() {
        return new Builder();
    }

    public static final class Builder {
        private UUID roomId;
        private String name;
        private Integer seats;
        private Boolean active;
        private OffsetDateTime createdAt;
        private OffsetDateTime updatedAt;

        private Builder() {
        }

        public Builder roomId(UUID roomId) {
            this.roomId = roomId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder seats(Integer seats) {
            this.seats = seats;
            return this;
        }

        public Builder active(Boolean active) {
            this.active = active;
            return this;
        }

        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder updatedAt(OffsetDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public RoomDTO build() {
            return new RoomDTO(this);
        }
    }
}
