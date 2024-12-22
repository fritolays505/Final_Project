package Staff.Api.restaurant.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Staff.Api.restaurant.entity.Shift;
import Staff.Api.restaurant.service.ShiftService;

@RestController
@RequestMapping("/shifts")
public class ShiftController {
	
	@Autowired
	ShiftService shiftService;
	
	@GetMapping
	public List<Shift> getAllShifts() {
		return shiftService.getAllShifts();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Shift>> getShiftById(@PathVariable Long id) {
		return new ResponseEntity<>(shiftService.getShiftById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Shift> addShift(@RequestBody Shift shift) {
		return new ResponseEntity<>(shiftService.addShift(shift), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteShift(@PathVariable Long id) {
		shiftService.deleteShift(id);
		return new ResponseEntity<>("Deleted Shift", HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Shift> updateShift(@RequestBody Shift shift) {
		return new ResponseEntity<>(shiftService.updateShift(shift), HttpStatus.OK);
	}

}
