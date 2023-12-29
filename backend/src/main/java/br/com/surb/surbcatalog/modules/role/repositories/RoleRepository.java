package br.com.surb.surbcatalog.modules.role.repositories;

import br.com.surb.surbcatalog.modules.role.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {
}
