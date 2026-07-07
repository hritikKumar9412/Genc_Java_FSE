package com.hritik.springsecurityjwtpractice.service;

import com.hritik.springsecurityjwtpractice.model.Countries;
import com.hritik.springsecurityjwtpractice.model.Country;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class CountryService {

    public List<Country> getCountries() {

        try {

            JAXBContext context =
                    JAXBContext.newInstance(Countries.class);

            Unmarshaller unmarshaller =
                    context.createUnmarshaller();

            InputStream inputStream =
                    new ClassPathResource("country.xml")
                            .getInputStream();

            Countries countries =
                    (Countries) unmarshaller.unmarshal(inputStream);

            return countries.getCountries();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}