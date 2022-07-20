package com.sparta.restaurant.model;

import com.sparta.restaurant.dto.FoodRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
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

    public Food(FoodRequestDto foodRequestDto, Restaurant restaurantId){
        this.name = foodRequestDto.getName();
        this.price = foodRequestDto.getPrice();
        this.restaurant = restaurantId;
    }
}
