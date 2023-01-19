package com.as2.salary.WorkHourService.Repository;

import org.springframework.data.couchbase.repository.CouchbaseRepository;

public interface WorkHourRepo extends CouchbaseRepository<EmployeeLeaveEntity, String> {

}
