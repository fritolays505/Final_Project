package Staff.Api.restaurant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Staff.Api.restaurant.dao.ShiftDao;
import Staff.Api.restaurant.entity.Shift;

@Service
public class ShiftService {
	
	@Autowired
	ShiftDao shiftDao;
	
	public List<Shift> getAllShifts() {
		return shiftDao.findAll();
	}
	
	public Optional<Shift> getShiftById(Long id) {
		return shiftDao.findById(id);
	}
	
	public Shift addShift(Shift shift) {
		return shiftDao.save(shift);
	}
	
	public void deleteShift(Long id) {
		shiftDao.deleteById(id);
	}
	
	public Shift updateShift(Shift shift) {
		return shiftDao.save(shift);
	}

}
