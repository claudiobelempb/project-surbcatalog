package br.com.surb.surbcatalog.modules.allocation.dto;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;

public class AllocationDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -6730784971868255686L;

    private UUID allocationId;
    private String subject;
    private OffsetDateTime startAt;
    private OffsetDateTime endAt;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private Boolean active;
    private UUID roomId;
    private UUID userId;

    public AllocationDTO() {

    }


    private AllocationDTO(Builder builder) {
        allocationId = builder.allocationId;
        subject = builder.subject;
        startAt = builder.startAt;
        endAt = builder.endAt;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
        active = builder.active;
        roomId = builder.roomId;
        userId = builder.userId;
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

    public UUID getRoomId() {
        return roomId;
    }

    public UUID getUserId() {
        return userId;
    }

    public static Builder newBuilderDTO() {
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
        private UUID roomId;
        private UUID userId;

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

        public Builder roomId(UUID roomId) {
            this.roomId = roomId;
            return this;
        }

        public Builder userId(UUID userId) {
            this.userId = userId;
            return this;
        }

        public AllocationDTO build() {
            return new AllocationDTO(this);
        }
    }
}
