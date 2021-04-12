package com.restaurant.services;

import com.restaurant.cuisines.Cuisine;
import com.restaurant.cuisines.PolishCuisine;
import com.restaurant.repositories.CuisineRepository;
import com.restaurant.repositories.PolishCuisineRepository;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import  org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class PolishCuisineServiceTest {

    @Mock
    PolishCuisineRepository polishCuisineRepository;

    @InjectMocks
    PolishCuisineServiceImpl polishCuisineCuisineService;

    @Before
    public void init(){
        //given
        given(polishCuisineRepository.findAll()).willReturn(prepareMockData());
    }

    @Test
    public void getAll(){
        //given
        List<PolishCuisine> list = new ArrayList<>();
        PolishCuisine cuisine = new PolishCuisine();
        cuisine.setId(0);
        cuisine.setMainCurse("Pork Chop");
        cuisine.setDessert("Apple Pie");
        cuisine.setPrice(25);
        list.add(cuisine);
        cuisine = new PolishCuisine();
        cuisine.setId(1);
        cuisine.setMainCurse("Dumplings");
        cuisine.setDessert("Cheese Cake");
        cuisine.setPrice(20);
        list.add(cuisine);
        cuisine = new PolishCuisine();
        cuisine.setId(2);
        cuisine.setMainCurse("Cabbage Stew");
        cuisine.setDessert("Poppy Seed Cake");
        cuisine.setPrice(15);
        list.add(cuisine);
        //when
        List<PolishCuisine> list1 = polishCuisineCuisineService.getAll();
        //then
        Assert.assertThat(list1, Matchers.hasSize(3));
        Assert.assertEquals(list,list1);

    }

    @Test
    public void add(){
        //given
        PolishCuisine cuisine = new PolishCuisine();
        cuisine.setId(0);
        cuisine.setMainCurse("Pork Chop");
        cuisine.setDessert("Apple Pie");
        cuisine.setPrice(25);
        //when
        polishCuisineCuisineService.add(cuisine);
        //then
        verify(polishCuisineRepository, times(1)).save(any());
    }

    private List<PolishCuisine> prepareMockData(){
        List<PolishCuisine> list = new ArrayList<>();
        PolishCuisine cuisine = new PolishCuisine();
        cuisine.setId(0);
        cuisine.setMainCurse("Pork Chop");
        cuisine.setDessert("Apple Pie");
        cuisine.setPrice(25);
        list.add(cuisine);
        cuisine = new PolishCuisine();
        cuisine.setId(1);
        cuisine.setMainCurse("Dumplings");
        cuisine.setDessert("Cheese Cake");
        cuisine.setPrice(20);
        list.add(cuisine);
        cuisine = new PolishCuisine();
        cuisine.setId(2);
        cuisine.setMainCurse("Cabbage Stew");
        cuisine.setDessert("Poppy Seed Cake");
        cuisine.setPrice(15);
        list.add(cuisine);
        return list;
    }
}
