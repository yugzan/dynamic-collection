package org.yugzan.tenant.repo;

import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author yongzan
 * @date 2016/9/23
 */
@Document(collection = "#{@myTenantProvider.getTenantName()}_some")
public class MyDocument {

    @Id
    private String id;
    private String name;

    public MyDocument() {}

    public MyDocument(String id, String name) {
        this.id = Objects.requireNonNull(id, "id is null.");
        this.name = Objects.requireNonNull(name, "name is null.");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
