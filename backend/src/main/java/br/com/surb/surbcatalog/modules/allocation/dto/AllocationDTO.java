package br.com.surb.surbcatalog.modules.allocation.dto;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;
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

    public UUID getAllocationId() {
        return allocationId;
    }

    public void setAllocationId(UUID allocationId) {
        this.allocationId = allocationId;
    }

    public AllocationDTO allocationId(UUID allocationId) {
        this.allocationId = allocationId;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public AllocationDTO subject(String subject) {
        this.subject = subject;
        return this;
    }

    public OffsetDateTime getStartAt() {
        return startAt;
    }

    public void setStartAt(OffsetDateTime startAt) {
        this.startAt = startAt;
    }

    public AllocationDTO startAt(OffsetDateTime startAt) {
        this.startAt = startAt;
        return this;
    }

    public OffsetDateTime getEndAt() {
        return endAt;
    }

    public void setEndAt(OffsetDateTime endAt) {
        this.endAt = endAt;
    }

    public AllocationDTO endAt(OffsetDateTime endAt) {
        this.endAt = endAt;
        return this;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public AllocationDTO createdAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public AllocationDTO updatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public AllocationDTO active(Boolean active) {
        this.active = active;
        return this;
    }

    public UUID getRoomId() {
        return roomId;
    }

    public void setRoomId(UUID roomId) {
        this.roomId = roomId;
    }

    public AllocationDTO roomId(UUID roomId) {
        this.roomId = roomId;
        return this;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public AllocationDTO userId(UUID userId) {
        this.userId = userId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllocationDTO that = (AllocationDTO) o;
        return Objects.equals(allocationId, that.allocationId) && Objects.equals(subject, that.subject) && Objects.equals(startAt, that.startAt) && Objects.equals(endAt, that.endAt) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt) && Objects.equals(active, that.active) && Objects.equals(roomId, that.roomId) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allocationId, subject, startAt, endAt, createdAt, updatedAt, active, roomId, userId);
    }

    @Override
    public String toString() {
        return "AllocationDTO{" +
                "allocationId=" + allocationId +
                ", subject='" + subject + '\'' +
                ", startAt=" + startAt +
                ", endAt=" + endAt +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", active=" + active +
                ", roomId=" + roomId +
                ", userId=" + userId +
                '}';
    }
}
