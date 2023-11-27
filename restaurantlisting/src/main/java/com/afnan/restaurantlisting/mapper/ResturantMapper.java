package com.afnan.restaurantlisting.mapper;

import com.afnan.restaurantlisting.dto.*;
import com.afnan.restaurantlisting.dto.RestaurantRequestDto;
import com.afnan.restaurantlisting.dto.RestaurantResponseDto;
import com.afnan.restaurantlisting.model.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ResturantMapper {
    ResturantMapper INSTANCE = Mappers.getMapper(ResturantMapper.class);

    RestaurantRequestDto mapRestaurantToRestaurantRequestDto(Restaurant restaurant);
    RestaurantResponseDto mapRestaurantToRestaurantResponseDto(Restaurant restaurant);
    Restaurant mapRestaurantRequestDtoToRestaurant(RestaurantRequestDto restaurantRequestDto);
    Restaurant mapRestaurantResponseDtoToRestaurant(RestaurantResponseDto restaurantResponseDto);
}
