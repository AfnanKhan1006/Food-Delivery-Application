package com.afnan.restaurantlisting.service;

import com.afnan.restaurantlisting.dto.*;
import com.afnan.restaurantlisting.dto.RestaurantRequestDto;
import com.afnan.restaurantlisting.dto.RestaurantResponseDto;
import com.afnan.restaurantlisting.mapper.ResturantMapper;
import com.afnan.restaurantlisting.model.Restaurant;
import com.afnan.restaurantlisting.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService{
    private final RestaurantRepository restaurantRepository;
    @Override
    public List<RestaurantResponseDto> findAllRestaurants() {
        List<Restaurant> restaurantList = restaurantRepository.findAll();
        return restaurantList.stream().map(ResturantMapper.INSTANCE::mapRestaurantToRestaurantResponseDto).collect(Collectors.toList());
    }

    @Override
    public RestaurantResponseDto createRestaurant(RestaurantRequestDto restaurantRequestDto) {
        Restaurant restaurant = ResturantMapper.INSTANCE.mapRestaurantRequestDtoToRestaurant(restaurantRequestDto);
        Restaurant createdRestaurant = restaurantRepository.save(restaurant);
        return  ResturantMapper.INSTANCE.mapRestaurantToRestaurantResponseDto(createdRestaurant);
    }

    @Override
    public RestaurantResponseDto getResturantById(Long id) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        return ResturantMapper.INSTANCE.mapRestaurantToRestaurantResponseDto(restaurant.get());
    }
}
