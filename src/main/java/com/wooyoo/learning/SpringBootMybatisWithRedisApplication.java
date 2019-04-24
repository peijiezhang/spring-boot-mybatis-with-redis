package com.wooyoo.learning;

import com.wooyoo.learning.data.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

import javax.servlet.annotation.WebFilter;
import java.util.Map;

@SpringBootApplication
@ServletComponentScan("com.wooyoo")
@EnableConfigurationProperties(value = Person.class)
//@ImportResource("cl")
@PropertySource(value = "classpath:db/db.properties",encoding = "utf-8")
public class SpringBootMybatisWithRedisApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(SpringBootMybatisWithRedisApplication.class, args);

        Map<String, DataSourceProperties> dataSourceProperties = configurableApplicationContext.getBeansOfType(DataSourceProperties.class);
        Map<String, Person> personMap = configurableApplicationContext.getBeansOfType(Person.class);

        System.out.println(dataSourceProperties);
        System.out.println(personMap);

    }
}
