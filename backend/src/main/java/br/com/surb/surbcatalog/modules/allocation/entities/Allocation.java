package br.com.surb.surbcatalog.modules.allocation.entities;

import br.com.surb.surbcatalog.modules.room.entities.Room;
import br.com.surb.surbcatalog.modules.user.entities.User;
import br.com.surb.surbcatalog.shared.AppUtils.AppDateUtils;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_allocation")
public class Allocation implements Serializable {

    public static final List<String> SORT_FIELDS = List.of("startAt", "endAt");

    @Serial
    private static final long serialVersionUID = -3812744367957338674L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID allocationId;
    private String subject;

    private OffsetDateTime startAt;
    private OffsetDateTime endAt;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Allocation() {
    }

    private Allocation(Builder builder) {
        allocationId = builder.allocationId;
        subject = builder.subject;
        startAt = builder.startAt;
        endAt = builder.endAt;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
        active = builder.active;
        room = builder.room;
        user = builder.user;
    }

    public UUID getAllocationId() {
        return allocationId;
    }

    public String getSubject() {
        return subject;
    }

    public OffsetDateTime getStartAt() {
        return startAt;
    }

    public OffsetDateTime getEndAt() {
        return endAt;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public Boolean getActive() {
        return active;
    }

    public Room getRoom() {
        return room;
    }

    public User getUser() {
        return user;
    }

    @PrePersist
    public void prePersist() {
        createdAt = AppDateUtils.now();
        updatedAt = createdAt;
        active = true;
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = AppDateUtils.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Allocation that = (Allocation) o;
        return Objects.equals(allocationId, that.allocationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allocationId);
    }

    @Override
    public String toString() {
        return "Allocation{" +
                "allocationId=" + allocationId +
                ", subject='" + subject + '\'' +
                ", startAt=" + startAt +
                ", endAt=" + endAt +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", active=" + active +
                ", room=" + room +
                ", user=" + user +
                '}';
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private UUID allocationId;
        private String subject;
        private OffsetDateTime startAt;
        private OffsetDateTime endAt;
        private OffsetDateTime createdAt;
        private OffsetDateTime updatedAt;
        private Boolean active;
        private Room room;
        private User user;

        private Builder() {
        }

        public Builder allocationId(UUID allocationId) {
            this.allocationId = allocationId;
            return this;
        }

        public Builder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder startAt(OffsetDateTime startAt) {
            this.startAt = startAt;
            return this;
        }

        public Builder endAt(OffsetDateTime endAt) {
            this.endAt = endAt;
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

        public Builder active(Boolean active) {
            this.active = active;
            return this;
        }

        public Builder room(Room room) {
            this.room = room;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Allocation build() {
            return new Allocation(this);
        }
    }
}
