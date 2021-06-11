package com.example.Invoice.Service;

import com.example.Invoice.Model.City;
import com.example.Invoice.Model.Hotel;
import com.example.Invoice.Repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository CityRepository;

    public List<City> getAllCities() {
        return CityRepository.findAll();
    }

    public List<Hotel> getHotelByCity(String city) {

        return CityRepository.getHotelByCity(city);
    }
}
