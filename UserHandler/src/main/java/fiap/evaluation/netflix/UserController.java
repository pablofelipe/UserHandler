package fiap.evaluation.netflix;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fiap.evaluation.netflix.model.User;
import fiap.evaluation.netflix.model.UserMovieToWatch;
import fiap.evaluation.netflix.model.UserMovieViewed;
import fiap.evaluation.netflix.repository.UserMovieToWatchRepository;
import fiap.evaluation.netflix.repository.UserMovieViewedRepository;
import fiap.evaluation.netflix.repository.UserRepository;

@RestController
@RequestMapping(value = "v1/UserController")
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserMovieViewedRepository userMovieViewedRepository;

	@Autowired
	UserMovieToWatchRepository userMovieToWatchRepository;
	
	@RequestMapping(value = "/findUserById/{id}",method = RequestMethod.GET)
	public Optional<User> findUserById(@PathVariable("id") int id) {
	
		return userRepository.findById(id);
	}
	
	@RequestMapping(value = "/findUserByName/{name}",method = RequestMethod.GET)
	public User findUserByName(@PathVariable("name")String name) {
		
		return userRepository.findByName(name);
	}
	
	@RequestMapping(value = "/findAllUsers",method = RequestMethod.GET)
	public List<User> findAllUsers() {
		
		return userRepository.findAll();
	}
	
	@RequestMapping(value = "/createUser",method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody User user) {
	
		if (null == user) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		User userSaved = userRepository.save(user);
		
		return ResponseEntity.ok(userSaved);
	}

	//Possibilidade de visualizar os filmes e séries que já foram assistidos begin
	//Marcar como assistido
	@RequestMapping(value = "/markMovieViewed",method = RequestMethod.POST)
	public ResponseEntity<?> markMovieViewed(@RequestBody UserMovieViewed userMovieViewed) {
	
		if (null == userMovieViewed) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		Optional<User> user = userRepository.findById(userMovieViewed.getUserId());
		
		if (null == user) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		UserMovieViewed userMovieSaved = userMovieViewedRepository.save(userMovieViewed); 
		
		return ResponseEntity.ok(userMovieSaved);
	}

	//Visualizar assistido
	@RequestMapping(value = "/findAllMoviesViewed",method = RequestMethod.GET)
	public List<UserMovieViewed> findAllMoviesViewed() {
		
		return userMovieViewedRepository.findAll();
	}
	//Possibilidade de visualizar os filmes e séries que já foram assistidos end
	
	//Possibilidade de marcar um filme ou série para ser visto no futuro begin
	//Marcar para assistir
	@RequestMapping(value = "/markMovieWatch",method = RequestMethod.POST)
	public ResponseEntity<?> markMovieWatch(@RequestBody UserMovieToWatch userMovieWatch) {
	
		if (null == userMovieWatch) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		Optional<User> user = userRepository.findById(userMovieWatch.getUserId());
		
		if (null == user) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		UserMovieToWatch userMovieSaved = userMovieToWatchRepository.save(userMovieWatch); 
		
		return ResponseEntity.ok(userMovieSaved);
	}

	//Visualizar a assistir
	@RequestMapping(value = "/findAllMoviesWatch",method = RequestMethod.GET)
	public List<UserMovieToWatch> findAllMoviesWatch() {
		
		return userMovieToWatchRepository.findAll();
	}
	//Possibilidade de marcar um filme ou série para ser visto no futuro end
}
