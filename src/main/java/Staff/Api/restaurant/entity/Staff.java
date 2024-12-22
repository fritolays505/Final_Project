package Staff.Api.restaurant.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "staff")

public class Staff {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String firstName;
	private String lastName;
	
	@Enumerated(EnumType.STRING)
	private StaffType staffType;
	private double hourlyPay;
	
	
	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department;
	
	@ManyToMany
	@JoinTable(name = "staff_shift", joinColumns = @JoinColumn(name = "staff_id"),
	inverseJoinColumns = @JoinColumn(name = "shift_id")
	)
	@JsonIgnore
	private List<Shift> shifts;
	
	@JsonCreator
	public Staff( 
			@JsonProperty("id") Long id,
			@JsonProperty("firstName") String firstName,
			@JsonProperty("lastName") String lastName,
			@JsonProperty("staffType") StaffType staffType,
			@JsonProperty("hourlyPay") double hourlyPay,
			@JsonProperty("department") Department department,
			@JsonProperty("shifts") List<Shift> shifts
			) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.staffType = staffType;
		this.hourlyPay = hourlyPay;
		this.department = department;
		if(shifts != null) {
			this.shifts = shifts;
		} else {
			this.shifts = null;
		}
	}
	
	public Staff() {
		
	}
	
	public void addShift(Shift shift) {
		if(this.shifts == null)
			this.shifts = new java.util.ArrayList<>();
			this.shifts.add(shift);
	}
	
	public void removeShift(Shift shift) {
		if(this.shifts != null) {
			this.shifts.remove(shift);
		}
	}
	
	public enum StaffType{
		SERVER, BARTENDER, HOST, KITCHEN, MANAGEMENT
	}

}
