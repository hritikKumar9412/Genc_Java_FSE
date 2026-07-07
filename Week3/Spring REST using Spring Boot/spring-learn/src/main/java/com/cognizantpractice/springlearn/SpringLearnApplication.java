package com.cognizantpractice.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.cognizantpractice.springlearn.model.Country;

// Add these imports
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) throws Exception {

        SpringApplication.run(SpringLearnApplication.class, args);

        LOGGER.info("Spring Boot Application Started Successfully");

        // Call the method here
        displayDate();

      //  displayCountry();

        displayCountries();
    }

    // 👇 Create this method HERE (outside main)
    public static void displayDate() throws Exception {

        LOGGER.info("START");

        ApplicationContext context =
                new ClassPathXmlApplicationContext("date-format.xml");

        SimpleDateFormat format =
                context.getBean("dateFormat", SimpleDateFormat.class);

        Date date = format.parse("31/12/2018");

        LOGGER.debug("Parsed Date : {}", date);

        LOGGER.info("END");
    }
    @SuppressWarnings("unchecked")
    public static void displayCountries() {

        LOGGER.info("START");

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        List<Country> countries =
                (List<Country>) context.getBean("countryList");

        for (Country country : countries) {
            LOGGER.debug("{}", country);
        }

        LOGGER.info("END");
    }

    public static void displayCountry() {

        LOGGER.info("START");

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        Country country =
                context.getBean("country", Country.class);

        Country anotherCountry =
                context.getBean("country", Country.class);

        LOGGER.debug("Country : {}", country);
        LOGGER.debug("Another Country : {}", anotherCountry);
        LOGGER.debug("Same Object : {}", country == anotherCountry);

        LOGGER.info("END");
    }
}