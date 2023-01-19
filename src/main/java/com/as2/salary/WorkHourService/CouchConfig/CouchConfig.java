package com.as2.salary.WorkHourService.CouchConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;

@Configuration
@PropertySource("classpath:application.properties")
public class CouchConfig extends AbstractCouchbaseConfiguration{

	
	@Autowired
	Environment env;
	
	
	@Override
	public String getConnectionString() {
		return env.getProperty("app.db.bootstrap-hosts");
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return env.getProperty("app.db.username");
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return env.getProperty("app.db.password");
	}

	@Override
	public String getBucketName() {
		// TODO Auto-generated method stub
		return env.getProperty("app.db.bucketName");
	}
	
}
