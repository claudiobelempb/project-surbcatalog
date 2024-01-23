package br.com.surb.surbcatalog.modules.allocation.services;

import br.com.surb.surbcatalog.modules.allocation.dto.AllocationDTO;
import br.com.surb.surbcatalog.modules.allocation.entities.Allocation;
import br.com.surb.surbcatalog.modules.allocation.mapper.AllocationMapper;
import br.com.surb.surbcatalog.modules.allocation.repositories.AllocationRepository;
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
public class AllocationFindAllService {
    private final AllocationRepository allocationRepository;
    //private final int maxLimit;

    public AllocationFindAllService(AllocationRepository allocationRepository) {
        this.allocationRepository = allocationRepository;
    }


    @Transactional(readOnly = true)
    public Page<AllocationDTO> execute(UUID userId, UUID roomId, LocalDate startAt, LocalDate endAt, Pageable pageable) {

        //Pageable pageable = AppPageUtils.appNewPageable(page, limit, maxLimit, orderBy, Allocation.SORT_FIELDS);
        //System.out.println("MAX" + this.maxLimit);

        Page<Allocation> allocations = allocationRepository
                .findAllwitnFilters(
                        userId,
                        roomId,
                        Objects.isNull(startAt) ? null : startAt.atTime(LocalTime.MIN).atOffset(DEFAULT_TIMEZONE),
                        Objects.isNull(endAt) ? null : endAt.atTime(LocalTime.MAX).atOffset(DEFAULT_TIMEZONE),
                        pageable

                );
        return allocations
                .map((a) -> AllocationMapper.fromDTO(a));
    }
}
