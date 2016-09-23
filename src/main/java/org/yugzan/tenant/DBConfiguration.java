package org.yugzan.tenant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.WriteConcern;

/**
 * @author yongzan
 * @date 2015/8/24
 * 
 */

@Configuration
@EnableMongoRepositories(
        mongoTemplateRef = "mongoDynamicCollection",
        basePackages = "org.yugzan.tenant")
public class DBConfiguration {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ApplicationContext appContext;

    @Value("${mongo.host:127.0.0.1}")
    private String host;

    @Value("${mongo.port:27017}")
    private int port;

    @Value("${mongo.db.name:mydb}")
    private String dbname;


    @Bean
    public MongoDbFactory mongoFactory() throws Exception {
        MongoClient client;
        String mongoUri = String.format("mongodb://%s:%s", host, port);
        client = new MongoClient(new MongoClientURI(mongoUri));
        client.setWriteConcern(WriteConcern.ACKNOWLEDGED);
        return new SimpleMongoDbFactory(client, dbname);
    }

    @Bean
    public MongoTemplate mongoDynamicCollection() throws Exception {
        final MongoDbFactory factory = mongoFactory();
        final MongoMappingContext mongoMappingContext = new MongoMappingContext();
        mongoMappingContext.setApplicationContext(appContext);
        DbRefResolver dbRefResolver = new DefaultDbRefResolver(factory);
        // Learned from web, prevents Spring from including the _class attribute
        final MappingMongoConverter converter =
                new MappingMongoConverter(dbRefResolver, mongoMappingContext);
        return new MongoTemplate(factory, converter);
    }


}
