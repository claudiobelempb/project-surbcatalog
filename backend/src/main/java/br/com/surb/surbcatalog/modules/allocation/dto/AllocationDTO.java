package br.com.surb.surbcatalog.modules.allocation.dto;

import br.com.surb.surbcatalog.modules.allocation.entities.Allocation;

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

    public AllocationDTO(UUID allocationId, String subject, OffsetDateTime startAt, OffsetDateTime endAt, OffsetDateTime createdAt, OffsetDateTime updatedAt, Boolean active, UUID roomId, UUID userId) {
        this.allocationId = allocationId;
        this.subject = subject;
        this.startAt = startAt;
        this.endAt = endAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.active = active;
        this.roomId = roomId;
        this.userId = userId;
    }

    public AllocationDTO(Allocation entity) {
        allocationId = entity.getAllocationId();
        subject = entity.getSubject();
        startAt = entity.getStartAt();
        endAt = entity.getEndAt();
        createdAt = entity.getCreatedAt();
        updatedAt = entity.getUpdatedAt();
        active = entity.getActive();
        roomId = entity.getRoom().getRoomId();
        userId = entity.getUser().getUserId();
    }

    public UUID getAllocationId() {
        return allocationId;
    }

    public void setAllocationId(UUID allocationId) {
        this.allocationId = allocationId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public OffsetDateTime getStartAt() {
        return startAt;
    }

    public void setStartAt(OffsetDateTime startAt) {
        this.startAt = startAt;
    }

    public OffsetDateTime getEndAt() {
        return endAt;
    }

    public void setEndAt(OffsetDateTime endAt) {
        this.endAt = endAt;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public UUID getRoomId() {
        return roomId;
    }

    public void setRoomId(UUID roomId) {
        this.roomId = roomId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
