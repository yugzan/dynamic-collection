package org.yugzan.tenant.test;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yugzan.tenant.MyTenantProvider;
import org.yugzan.tenant.repo.MyDocument;
import org.yugzan.tenant.repo.MyRepository;

/**
 * @author yongzan
 * @date 2016/9/23
 */
@Service
public class InsertTest {
    
    @Autowired
    private MyRepository repo;
    
    @Autowired
    private MyTenantProvider provider;
    
    public void insert(){
        provider.setTenantName(  "random_"+ new Random().nextInt(100)  );
        repo.save( new MyDocument("1", "joys") );
    }

}
