package Staff.Api.restaurant.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import Staff.Api.restaurant.entity.Shift;

public interface ShiftDao extends JpaRepository<Shift, Long> {

}
