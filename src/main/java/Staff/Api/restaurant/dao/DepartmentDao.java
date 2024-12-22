package Staff.Api.restaurant.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import Staff.Api.restaurant.entity.Department;

public interface DepartmentDao extends JpaRepository<Department, Long> {

}
