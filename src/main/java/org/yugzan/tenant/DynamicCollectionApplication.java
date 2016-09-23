package org.yugzan.tenant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.yugzan.tenant.test.InsertTest;

@SpringBootApplication
public class DynamicCollectionApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DynamicCollectionApplication.class, args);
	}
	
    @Autowired
    private InsertTest test;
    
    @Override
    public void run(String... args) throws Exception {
        test.insert();
    }
}
