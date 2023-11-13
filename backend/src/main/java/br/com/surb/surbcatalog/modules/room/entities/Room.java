package br.com.surb.surbcatalog.modules.room.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_room")
public class Room implements Serializable {

    @Serial
    private static final long serialVersionUID = -7554392593466417214L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID roomId;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer seats;

    private Boolean active;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant createdAt;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant updatedAt;

    public Room() {
    }

    private Room(UUID roomId, String name, Integer seats, Boolean active, Instant createdAt, Instant updatedAt) {
        this.roomId = roomId;
        this.name = name;
        this.seats = seats;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    @PrePersist
    public void prePersist(){
        createdAt = Instant.now();
        active = true;
    }

    @PreUpdate
    public void preUpdate(){
        updatedAt = Instant.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(roomId, room.roomId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId);
    }

    public static RoomBuilder newRoomBuilder() {
        return new RoomBuilder();
    }

    public static final class RoomBuilder {
        private UUID roomId;
        private String name;
        private Integer seats;
        private Boolean active;
        private Instant createdAt;
        private Instant updatedAt;

        private RoomBuilder() {
        }

        public RoomBuilder roomId(UUID roomId) {
            this.roomId = roomId;
            return this;
        }

        public RoomBuilder name(String name) {
            this.name = name;
            return this;
        }

        public RoomBuilder seats(Integer seats) {
            this.seats = seats;
            return this;
        }

        public RoomBuilder active(Boolean active) {
            this.active = active;
            return this;
        }

        public RoomBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public RoomBuilder updatedAt(Instant updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Room build() {
            return new Room(roomId, name, seats, active, createdAt, updatedAt);
        }
    }
}