package com.sparta.restaurant.service;

import com.sparta.restaurant.dto.FoodRequestDto;
import com.sparta.restaurant.model.Food;
import com.sparta.restaurant.model.Restaurant;
import com.sparta.restaurant.repository.FoodRepository;
import com.sparta.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {

    public final RestaurantRepository restaurantRepository;
    public final FoodRepository foodRepository;

    @Transactional
    public void checkNamePrice(Restaurant restaurantId, List<FoodRequestDto> foodRequestDto) {
        HashSet<String> setFoods = new HashSet<>();
        for (FoodRequestDto food : foodRequestDto) {
            setFoods.add(food.getName()); //입력받은 음식을 set함수로 셋팅
        }
        //음식 중복 확인
        if (setFoods.size() != foodRequestDto.size()) {
            throw new IllegalArgumentException("중복된 음식을 등록 할 수 없습니다.");
        }
        if (nameBooleanCheck(restaurantId, foodRequestDto)) {
            throw new IllegalArgumentException("이미 등록된 음식이 있습니다.");
        }
        //음식 입력값 확인
        for (FoodRequestDto food : foodRequestDto){
            int price = food.getPrice(); //가격 비교
            if(price%100 != 0) {
                throw new IllegalArgumentException("100원 단위로 입력해 주세용.");
            }
            if(price < 100){
                throw new IllegalArgumentException("최소 사용가능한 가격을 입력 해 주세요.");
            }
            if(price > 1000000){
                throw new IllegalArgumentException("최대 사용가능한 가격을 입력 해 주세요.");
            }

            Food food1 = new Food(food, restaurantId);

            foodRepository.save(food1);
        }

    }

    public boolean nameBooleanCheck (Restaurant restaurantId, List<FoodRequestDto> foodRequestDto){
        for (FoodRequestDto food : foodRequestDto) {
            if (foodRepository.existsByNameAndRestaurant(food.getName(), restaurantId)) {
                return true;
            }
        }
        return false;
    }

}

