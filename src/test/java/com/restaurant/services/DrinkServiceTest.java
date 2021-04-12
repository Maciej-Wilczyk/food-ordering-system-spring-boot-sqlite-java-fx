package com.restaurant.services;

import com.restaurant.drinks.Drink;
import com.restaurant.repositories.DrinkRepository;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DrinkServiceTest {

    @Mock
    DrinkRepository drinkRepository;

    @InjectMocks
    DrinkServiceImpl drinkService;


    @Before
    public void init(){
        //given
        given(drinkRepository.findAll()).willReturn(prepareMockData());
    }


    @Test
    public void should_get_all(){
        //given
        List<Drink> list = new ArrayList<>();
        Drink drink = new Drink();
        drink.setId(0);
        drink.setDrink("tea");
        drink.setPrice(3);
        list.add(drink);
        drink = new Drink();
        drink.setId(1);
        drink.setDrink("water");
        drink.setPrice(2);
        list.add(drink);
        //when
        List<Drink> list1 = drinkService.getAll();
        //then
        Assert.assertThat(list1, Matchers.hasSize(2));
        Assert.assertEquals(list,list1);

    }

    @Test
    public void should_add(){
        //given
        Drink drink = new Drink();
        drink.setId(0);
        drink.setDrink("tea");
        drink.setPrice(3);
        //when
        drinkService.add(drink);
        //then
        verify(drinkRepository, times(1)).save(any());
    }

    private List<Drink> prepareMockData(){
        List<Drink> list = new ArrayList<>();
        Drink drink = new Drink();
        drink.setId(0);
        drink.setDrink("tea");
        drink.setPrice(3);
        list.add(drink);
        drink = new Drink();
        drink.setId(1);
        drink.setDrink("water");
        drink.setPrice(2);
        list.add(drink);
        return list;
    }

}
