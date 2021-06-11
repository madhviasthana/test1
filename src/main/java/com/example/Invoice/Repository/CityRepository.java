package com.example.Invoice.Repository;

import com.example.Invoice.Model.City;
import com.example.Invoice.Model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City,Integer> {

    @Query(value="select h.hotel_name from " +
            "city_tbl as c join hotel_tbl as h on c.city_code=h.city_code" +
            " where lower(c.city_name)=lower(:city_name) "
            ,nativeQuery = true)
    List<Hotel> getHotelByCity(String city);
}
//c.city_code,c.city_name,"+"