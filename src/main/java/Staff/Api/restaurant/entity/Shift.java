package Staff.Api.restaurant.entity;

import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="shift")
public class Shift {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalTime startTime;
	private LocalTime endTime;
	
	@ManyToMany(mappedBy = "shifts")
	@JsonIgnore
	private List<Staff> staffList;

}
