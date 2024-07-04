package lk.ijse.user_service.repository;

import lk.ijse.user_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    boolean existsByEmailAndPassword(String email, String password);
}
