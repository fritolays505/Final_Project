package Staff.Api.restaurant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Staff.Api.restaurant.dao.DepartmentDao;
import Staff.Api.restaurant.entity.Department;

@Service
public class DepartmentService {
	@Autowired
	DepartmentDao departmentDao;
	
	public List<Department> getAllDepartments() {
		return departmentDao.findAll();
	}
	
	public Optional<Department> getDepartmentById(Long id) {
		return departmentDao.findById(id);
	}
	
	public Department addDepartment(Department department) {
		return departmentDao.save(department);
	}
	
	public void deleteDepartment(Long id) {
		departmentDao.deleteById(id);
	}
	public Department updateDepartment(Department department) {
		return departmentDao.save(department);
	}

}
