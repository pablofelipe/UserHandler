package fiap.evaluation.netflix.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="iduser")
	@JsonProperty("userId")
	private int userId;
    

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    @Column(name="name")
	@JsonProperty("name")
	private String name;
	
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
