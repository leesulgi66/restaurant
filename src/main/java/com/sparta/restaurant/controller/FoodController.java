package com.sparta.restaurant.controller;

import com.sparta.restaurant.dto.FoodRequestDto;
import com.sparta.restaurant.dto.RestaurantDto;
import com.sparta.restaurant.model.Food;
import com.sparta.restaurant.model.Restaurant;
import com.sparta.restaurant.repository.FoodRepository;
import com.sparta.restaurant.repository.RestaurantRepository;
import com.sparta.restaurant.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FoodController {

    public final FoodRepository foodRepository;
    public final RestaurantRepository restaurantRepository;
    public final FoodService foodService;

    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<Food> getRestaurantFood(@PathVariable Restaurant restaurantId){
        return foodRepository.findAllByRestaurant(restaurantId);
    }

    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void registerFood(@PathVariable Restaurant restaurantId,@RequestBody List<FoodRequestDto> foodRequestDto){
        foodService.checkNamePrice(restaurantId, foodRequestDto);
    }
}
