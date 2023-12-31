package sni.intern.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sni.intern.security.domain.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
