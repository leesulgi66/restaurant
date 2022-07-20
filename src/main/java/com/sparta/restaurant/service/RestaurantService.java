package com.sparta.restaurant.service;

import com.sparta.restaurant.dto.RestaurantDto;
import com.sparta.restaurant.model.Restaurant;
import com.sparta.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RestaurantService {

    public final RestaurantRepository restaurantRepository;

    public Restaurant checkPrice(RestaurantDto restaurantDto) {

        return getRestaurant(restaurantDto);
    }

    private Restaurant getRestaurant(RestaurantDto restaurantDto) {
        if (!(restaurantDto.getMinOrderPrice() >= 1000 && restaurantDto.getMinOrderPrice() <= 100000)) {
            throw new IllegalArgumentException("올바른 가격을 입력 해 주세요");
        }
        if (!(restaurantDto.getMinOrderPrice() % 100 == 0)) {
            throw new IllegalArgumentException("100원 단위로 입력 해 주세요.");
        }
        if (!(restaurantDto.getDeliveryFee() >= 0 && restaurantDto.getDeliveryFee() <= 10000)) {
            throw new IllegalArgumentException("잘못된 배달 가격입니다.");
        }
        if (!(restaurantDto.getDeliveryFee() % 500 == 0)) {
            throw new IllegalArgumentException("500원 단위로 입력 해 주세요.");
        }

        Restaurant restaurant = new Restaurant(restaurantDto);

        return restaurantRepository.save(restaurant);
    }

}




