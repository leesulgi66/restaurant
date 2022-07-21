package com.sparta.restaurant.model;

import com.sparta.restaurant.dto.RestaurantDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Getter

public class Restaurant {
    //@ID
    //@Column(name = "id", nullable = false, unique = true)
    //private String username;
    //ID를 인조키로 사용 할 때. (id = username)

    @GeneratedValue(strategy = GenerationType.AUTO) //자연키 생성
    @Id
    private Long id;


    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    int minOrderPrice;

    @Column(nullable = false)
    int deliveryFee;


    public Restaurant(RestaurantDto restaurantDto){
        this.name = restaurantDto.getName();
        this.minOrderPrice = restaurantDto.getMinOrderPrice();
        this.deliveryFee = restaurantDto.getDeliveryFee();
    }
}
