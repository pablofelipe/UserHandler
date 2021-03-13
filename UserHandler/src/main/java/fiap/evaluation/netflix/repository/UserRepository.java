package fiap.evaluation.netflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fiap.evaluation.netflix.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("FROM User WHERE name = ?1")
    User findByName(String userName);
}
