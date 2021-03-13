package fiap.evaluation.netflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fiap.evaluation.netflix.model.UserMovieViewed;

public interface UserMovieViewedRepository extends JpaRepository<UserMovieViewed, Integer>{

}
