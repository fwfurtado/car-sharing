package me.fwfurtado.search.changelog;

import com.github.mongobee.Mongobee;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
class MigrationConfiguration {
    @Bean
    Mongobee mongobee(MongoProperties properties, MongoTemplate template) {

        Mongobee mongobee = new Mongobee(properties.determineUri());
        mongobee.setDbName(properties.getDatabase());
        mongobee.setMongoTemplate(template);
        mongobee.setChangeLogsScanPackage(getClass().getPackage().getName());

        return mongobee;
    }
}
