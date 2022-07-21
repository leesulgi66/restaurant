package com.sparta.restaurant.model;

import com.sparta.restaurant.dto.FoodDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Food {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @ManyToOne
    @JoinColumn(name = "RESTAURANT_ID", nullable = false)
    private Restaurant restaurant;

    public Food(FoodDto foodDto, Restaurant restaurantId){
        this.name = foodDto.getName();
        this.price = foodDto.getPrice();
        this.restaurant = restaurantId;
    }
}
