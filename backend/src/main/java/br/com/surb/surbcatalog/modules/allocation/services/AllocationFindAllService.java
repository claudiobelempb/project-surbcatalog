package br.com.surb.surbcatalog.modules.allocation.services;

import br.com.surb.surbcatalog.modules.allocation.dto.AllocationDTO;
import br.com.surb.surbcatalog.modules.allocation.entities.Allocation;
import br.com.surb.surbcatalog.modules.allocation.mapper.AllocationMapper;
import br.com.surb.surbcatalog.modules.allocation.repositories.AllocationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import static br.com.surb.surbcatalog.shared.AppUtils.AppDateUtils.DEFAULT_TIMEZONE;

@Service
public class AllocationFindAllService {
    private final AllocationRepository allocationRepository;

    public AllocationFindAllService(AllocationRepository allocationRepository) {
        this.allocationRepository = allocationRepository;
    }

    @Transactional(readOnly = false)
    public List<AllocationDTO> execute(UUID userId, UUID roomId, LocalDate startAt, LocalDate endAt) {
        List<Allocation> allocations = allocationRepository
                .findAllwitnFilters(
                        userId,
                        roomId,
                        Objects.isNull(startAt) ? null : startAt.atTime(LocalTime.MIN).atOffset(DEFAULT_TIMEZONE),
                        Objects.isNull(endAt) ? null : endAt.atTime(LocalTime.MAX).atOffset(DEFAULT_TIMEZONE)
                );
        return allocations
                .stream()
                .map((a) -> AllocationMapper.entityToAllocationDTO(a))
                .collect(Collectors.toList());
    }
}
