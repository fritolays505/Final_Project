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

import Staff.Api.restaurant.entity.Department;
import Staff.Api.restaurant.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	@Autowired
	DepartmentService departmentService;
	
	@GetMapping
	public List<Department> getAllDepartments() {
		return departmentService.getAllDepartments();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Department>> getDepartmentById(@PathVariable Long id) {
		return new ResponseEntity<>(departmentService.getDepartmentById(id), HttpStatus.CREATED);
	}
	
	@PostMapping
	public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
		return new ResponseEntity<>(departmentService.addDepartment(department), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDepartment(@PathVariable Long id) {
		departmentService.deleteDepartment(id);
		return new ResponseEntity<>("Deleted Department", HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Department> updateDepartment(@RequestBody Department department) {
		return new ResponseEntity<>(departmentService.updateDepartment(department), HttpStatus.OK);
	}

}
