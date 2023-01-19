package com.as2.salary.WorkHourService.Service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.as2.salary.WorkHourService.Repository.EmployeeLeaveEntity;
import com.as2.salary.WorkHourService.Repository.WorkHourRepo;
import com.as2.salary.WorkHourService.model.EmployeeLeave;
import com.google.common.base.Objects;
import java.util.Optional;

@Service
public class WorkHourService {
	
	@Autowired
	WorkHourRepo repo;

    public String saveData(EmployeeLeaveEntity empLeave) {
        repo.save(empLeave);
        return "saved";
    }

    public Number getEmployeeLeaveCount(String id) {
        return repo.findById(id).orElseThrow().getCount();
    }
    
    public Optional<EmployeeLeaveEntity> getEmployeeLeaveByEmployeeIdAndYearMonth(EmployeeLeave workHourRequest){
        Optional<EmployeeLeaveEntity> result = repo.findById(workHourRequest.getEmpId())
                .stream()
                .filter(EmployeeLeave -> Objects.equal(EmployeeLeave.getYearMonth(),
                        workHourRequest.getYearMonth().intValue())).findFirst();


        return result;
    }

    public int getDaysInMonth(String id) {
        int yearMonth = (int) repo.findById(id).orElseThrow().getYearMonth();
        int year = Integer.parseInt(("" + yearMonth).substring(0, 4));
        int month = yearMonth % 100;
        if (month == 2) {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
                return 29;
            return 28;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11)
            return 30;
        return 31;
    }
	
	
}
