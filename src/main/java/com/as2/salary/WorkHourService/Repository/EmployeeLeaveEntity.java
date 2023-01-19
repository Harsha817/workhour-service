package com.as2.salary.WorkHourService.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import com.couchbase.client.core.deps.com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@Document
public class EmployeeLeaveEntity {

    @Id
    private String empId;
    private int yearMonth;
    private int count;

    public EmployeeLeaveEntity() {}

    public EmployeeLeaveEntity(EmployeeLeaveEntityBuilder builder) {
        this.empId = builder.empId;
        this.yearMonth = builder.yearMonth;
        this.count = builder.count;
    }

    public String getEmpId() {
        return empId;
    }

    public int getYearMonth() {
        return yearMonth;
    }

    public int getCount() {
        return count;
    }

    @JsonPOJOBuilder(withPrefix = "set")
    public static class EmployeeLeaveEntityBuilder {
        protected String empId;
        protected int yearMonth;
        protected int count;

        public EmployeeLeaveEntityBuilder setEmpId(String empId) {
            this.empId = empId;
            return this;
        }

        public EmployeeLeaveEntityBuilder setYearMonth(int yearMonth) {
            this.yearMonth = yearMonth;
            return this;
        }

        public EmployeeLeaveEntityBuilder setCount(int count) {
            this.count = count;
            return this;
        }

        public EmployeeLeaveEntity build() {
            return new EmployeeLeaveEntity(this);
        }
    }
}
