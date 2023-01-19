package com.as2.salary.WorkHourService.model;

import com.couchbase.client.core.deps.com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

public class EmployeeLeave {
	private String empId;
    private Number yearMonth;
    private Number count;

    public EmployeeLeave() {}

    public EmployeeLeave(EmployeeLeaveBuilder builder) {
        this.empId = builder.empId;
        this.yearMonth = builder.yearMonth;
        this.count = builder.count;
    }

    public String getEmpId() {
        return empId;
    }

    public Number getYearMonth() {
        return yearMonth;
    }

    public Number getCount() {
        return count;
    }

    @JsonPOJOBuilder(withPrefix = "set")
    public static class EmployeeLeaveBuilder {
        protected String empId;
        protected int yearMonth;
        protected int count;

        public EmployeeLeaveBuilder setEmpId(String empId) {
            this.empId = empId;
            return this;
        }

        public EmployeeLeaveBuilder setYearMonth(int yearMonth) {
            this.yearMonth = yearMonth;
            return this;
        }

        public EmployeeLeaveBuilder setCount(int count) {
            this.count = count;
            return this;
        }

        public EmployeeLeave build() {
            return new EmployeeLeave(this);
        }
    }
}
