package Staff.Api.restaurant.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Staff.Api.restaurant.dao.StaffDao;
import Staff.Api.restaurant.entity.Shift;
import Staff.Api.restaurant.entity.Staff;


@Service

public class StaffService {
	
	private static final Logger logger = LoggerFactory.getLogger(StaffService.class);
	
	@Autowired
	private StaffDao staffDao;
	
	@Autowired
	private ShiftService shiftService;
	
	public List<Staff> getAllStaff() {
		return staffDao.findAll();
	}
	public Optional<Staff> getStaffById(Long id) {
		return staffDao.findById(id);
	}
	public Staff addStaff(Staff staff) {
		return staffDao.save(staff);
	}
	
	public void deleteStaff(Long id) {
		staffDao.deleteById(id);
	}
	
	public Staff updateStaff(Staff staff) {
		logger.info("Updating staff with id: {}", staff.getId());
		logger.info("Shifts in request: {}", staff.getShifts());
	
		Staff existingStaff = staffDao.findById(staff.getId()).orElse(null);
		if(existingStaff!= null) {
			logger.info("Existing staff: {}", existingStaff);
			existingStaff.setFirstName(staff.getFirstName());
			existingStaff.setLastName(staff.getLastName());
			existingStaff.setHourlyPay(staff.getHourlyPay());
			existingStaff.setStaffType(staff.getStaffType());
			existingStaff.setDepartment(staff.getDepartment());
			
			List<Shift> shifts = new ArrayList<>();
			if(staff.getShifts() != null) {
				for(Shift shift: staff.getShifts()) {
					Shift existingShift = shiftService.getShiftById(shift.getId()).orElse(null);
					if(existingShift != null) shifts.add(existingShift);
				}
			}
			existingStaff.setShifts(shifts);
			Staff updatedStaff = staffDao.save(existingStaff);
			logger.info("Updated Staff: {}", updatedStaff);
			return updatedStaff;
			
			}
			return null;
		} 
	
	public Staff addShiftToStaff(Long staffId, Long shiftId) {
		Staff staff = staffDao.findById(staffId).orElse(null);
		Shift shift = shiftService.getShiftById(shiftId).orElse(null);
		if (staff != null && shift != null) {
			staff.addShift(shift);
			return staffDao.save(staff);
		} return null;
	} 
	public Staff removeShiftFromStaff(Long staffId, Long shiftId) {
		Staff staff = staffDao.findById(staffId).orElse(null);
		Shift shift = shiftService.getShiftById(shiftId).orElse(null);
		if(staff != null && shift != null) {
			staff.removeShift(shift);
			return staffDao.save(staff);
		} return null;
	}

}
