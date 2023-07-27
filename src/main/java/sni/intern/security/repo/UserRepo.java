package sni.intern.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sni.intern.security.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
