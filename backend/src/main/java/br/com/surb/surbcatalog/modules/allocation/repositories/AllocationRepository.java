package br.com.surb.surbcatalog.modules.allocation.repositories;

import br.com.surb.surbcatalog.modules.allocation.entities.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation, UUID> {
}
