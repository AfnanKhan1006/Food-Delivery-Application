package com.afnan.restaurantlisting.dto;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantResponseDto {
    private Long id;
    private String name;
    private String address;
    private String city;
    private String description;
}
