package com.sparta.restaurant.controller;

import com.sparta.restaurant.dto.RestaurantDto;
import com.sparta.restaurant.model.Restaurant;
import com.sparta.restaurant.repository.RestaurantRepository;
import com.sparta.restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RestaurantController {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantService restaurantService;

    @GetMapping("/restaurants")
    List<Restaurant> getAllRestaurants(){
        return restaurantRepository.findAll();
    }

    @PostMapping("/restaurant/register")
    public Restaurant createRestaurant(@RequestBody RestaurantDto restaurantDto){
        return restaurantService.checkPrice(restaurantDto);
    }

}
