package com.afnan.restaurantlisting.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantRequestDto {
    private Long id;
    private String name;
    private String address;
    private String city;
    private String description;
}
