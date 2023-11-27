package com.afnan.restaurantlisting.service;

import com.afnan.restaurantlisting.dto.*;
import com.afnan.restaurantlisting.dto.RestaurantRequestDto;
import com.afnan.restaurantlisting.dto.RestaurantResponseDto;
import org.springframework.http.ResponseEntity;

import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

public interface RestaurantService {

    List<RestaurantResponseDto> findAllRestaurants();

    RestaurantResponseDto createRestaurant(RestaurantRequestDto restaurantRequestDto);

    RestaurantResponseDto getResturantById(Long id);
}
