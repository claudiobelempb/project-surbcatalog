package br.com.surb.surbcatalog.modules.allocation.services;

import br.com.surb.surbcatalog.modules.allocation.dto.AllocationDTO;
import br.com.surb.surbcatalog.modules.allocation.entities.Allocation;
import br.com.surb.surbcatalog.modules.allocation.mapper.AllocationMapper;
import br.com.surb.surbcatalog.modules.allocation.repositories.AllocationRepository;
import br.com.surb.surbcatalog.shared.AppConstants.AppConfigConstants;
import br.com.surb.surbcatalog.shared.AppUtils.AppPageUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import java.util.UUID;

import static br.com.surb.surbcatalog.shared.AppUtils.AppDateUtils.DEFAULT_TIMEZONE;

@Service
public class AllocationFindAllPageService {
    private final AllocationRepository allocationRepository;
    private final AllocationMapper allocationMapper;
    private final int maxSize;

    public AllocationFindAllPageService(AllocationRepository allocationRepository, AllocationMapper allocationMapper, @Value(AppConfigConstants.ALLOCATION_MAX_SIZE) int maxSize) {
        this.allocationRepository = allocationRepository;
        this.allocationMapper = allocationMapper;
        this.maxSize = maxSize;
    }


    @Transactional(readOnly = true)
    public Page<AllocationDTO> execute(UUID userId, UUID roomId, LocalDate startAt, LocalDate endAt, String orderBy, Integer size, Integer page) {

        Pageable pageable = AppPageUtils.appPageable(page, size, maxSize, orderBy, Allocation.SORT_FIELDS);

        Page<Allocation> allocations = allocationRepository
                .findAllPagewitnFilters(
                        userId,
                        roomId,
                        Objects.isNull(startAt) ? null : startAt.atTime(LocalTime.MIN).atOffset(DEFAULT_TIMEZONE),
                        Objects.isNull(endAt) ? null : endAt.atTime(LocalTime.MAX).atOffset(DEFAULT_TIMEZONE),
                        pageable
                );
        return allocations
                .map((a) ->AllocationMapper.fromDTO(a));
    }
}
