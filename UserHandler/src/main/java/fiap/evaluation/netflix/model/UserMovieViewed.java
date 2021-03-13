package fiap.evaluation.netflix.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "usermovieviewed")
public class UserMovieViewed {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idusermovieviewed")
	private int userMovieViewedId;

	
    public int getUserMovieViewedId() {
        return userMovieViewedId;
    }

    public void setUserMovieViewedId(int userMovieViewedId) {
        this.userMovieViewedId = userMovieViewedId;
    }

    @Column(name="iduser")
	@JsonProperty("userId")
	private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    @Column(name="idmovie")
	@JsonProperty("movieId")
	private int movieId;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
}
