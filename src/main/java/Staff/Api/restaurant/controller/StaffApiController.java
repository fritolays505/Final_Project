package Staff.Api.restaurant.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Staff.Api.restaurant.entity.Staff;
import Staff.Api.restaurant.service.StaffService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/staff")
@Slf4j

public class StaffApiController {
	
	@Autowired
	StaffService staffService;
	
	@GetMapping
	public List<Staff> getStaff(){
		return staffService.getAllStaff();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional <Staff>> getStaffById(@PathVariable Long id) {
		return new ResponseEntity<>(staffService.getStaffById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Staff> addStaff(@RequestBody Staff staff) {
		return new ResponseEntity<>(staffService.addStaff(staff), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Staff> updateStaff(@RequestBody Staff staff) {
		return new ResponseEntity<>(staffService.updateStaff(staff), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStaff(@PathVariable Long id) {
		staffService.deleteStaff(id);
		return new ResponseEntity<>("Deleted Staff Member", HttpStatus.OK);
	}
	
	@PostMapping("/{staffId}/shifts/{shiftId}")
	public ResponseEntity<Staff> addShiftToStaff(@PathVariable Long staffId, @PathVariable Long shiftId) {
		return new ResponseEntity<>(staffService.addShiftToStaff(staffId, shiftId), HttpStatus.OK);
	}
	
	@DeleteMapping("/{staffId}/shifts/{shiftId}")
	public ResponseEntity<Staff> removedShiftFromStaff(@PathVariable Long staffId, @PathVariable Long shiftId) {
		return new ResponseEntity<>(staffService.removeShiftFromStaff(staffId, shiftId), HttpStatus.OK);
	}

}
