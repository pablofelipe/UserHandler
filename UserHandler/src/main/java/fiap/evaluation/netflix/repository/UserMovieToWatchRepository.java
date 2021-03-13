package fiap.evaluation.netflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fiap.evaluation.netflix.model.UserMovieToWatch;

public interface UserMovieToWatchRepository extends JpaRepository<UserMovieToWatch, Integer>{

}
