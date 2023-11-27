package com.afnan.restaurantlisting.controller;

import com.afnan.restaurantlisting.dto.*;
import com.afnan.restaurantlisting.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1.0/restaurants")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<List<RestaurantResponseDto>> findAllRestaurants(){
        List<RestaurantResponseDto> allRestaurants = restaurantService.findAllRestaurants();
        return new ResponseEntity<>(allRestaurants,HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<RestaurantResponseDto>  findRestaurantById(@PathVariable ("id") Long id){
        RestaurantResponseDto restaurantResponseDto = restaurantService.getResturantById(id);
        if(restaurantResponseDto != null){
            return ResponseEntity.ok(restaurantResponseDto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<RestaurantResponseDto> createRestaurant(@RequestBody RestaurantRequestDto restaurantDto){
        RestaurantResponseDto createdRestaurant = restaurantService.createRestaurant(restaurantDto);
        return new ResponseEntity<>(createdRestaurant,HttpStatus.CREATED);
    }
}
