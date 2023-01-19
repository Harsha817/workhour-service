package com.as2.salary.WorkHourService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.as2.salary.WorkHourService.Repository.EmployeeLeaveEntity;
import com.as2.salary.WorkHourService.Service.WorkHourService;
import com.as2.salary.WorkHourService.model.EmployeeLeave;
import java.util.Optional;

@RestController
@RequestMapping("/empLeave")
public class WorkHourController {

    @Autowired
    WorkHourService workHourService;

    @PostMapping("/add")
    public String saveDate(@RequestBody EmployeeLeaveEntity empLeave) {
        return workHourService.saveData(empLeave);
    }
    @PostMapping("/find")
    @ResponseStatus
    public Optional<EmployeeLeaveEntity> getEmployeeLeaveByEmployeeIdAndYearMonth(@RequestBody EmployeeLeave employeeLeave){
        return this.workHourService.getEmployeeLeaveByEmployeeIdAndYearMonth(employeeLeave);
    }

    @GetMapping("/{empId}")
    public Number getEmployeeLeaveCount(@PathVariable String empId) {
        return workHourService.getEmployeeLeaveCount(empId);
    }
}
