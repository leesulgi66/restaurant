package com.sparta.restaurant.repository;

import com.sparta.restaurant.model.Food;
import com.sparta.restaurant.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {
    boolean existsByNameAndRestaurant(String name, Restaurant restaurant);
    List<Food> findAllByRestaurant(Restaurant restaurantId);
}
