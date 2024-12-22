package Staff.Api.restaurant.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import Staff.Api.restaurant.entity.Staff;

public interface StaffDao extends JpaRepository<Staff, Long> {

}
