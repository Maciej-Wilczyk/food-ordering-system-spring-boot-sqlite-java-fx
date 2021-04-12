package com.restaurant.services;

import com.restaurant.cuisines.MexicanCuisine;
import com.restaurant.cuisines.PolishCuisine;
import com.restaurant.repositories.MexicanCuisineRepository;
import com.restaurant.repositories.PolishCuisineRepository;
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
public class MexicanCuisineServiceTest {

    @Mock
    MexicanCuisineRepository mexicanCuisineRepository;

    @InjectMocks
    MexicanCuisineServiceImpl mexicanCuisineService;

    @Before
    public void init(){
        //given
        given(mexicanCuisineRepository.findAll()).willReturn(prepareMockData());
    }

    @Test
    public void should_get_all(){
        //given
        List<MexicanCuisine> list = new ArrayList<>();
        MexicanCuisine cuisine = new MexicanCuisine();
        cuisine.setId(0);
        cuisine.setMainCurse("Quesadilla");
        cuisine.setDessert("Lime Pie");
        cuisine.setPrice(17);
        list.add(cuisine);
        cuisine = new MexicanCuisine();
        cuisine.setId(1);
        cuisine.setMainCurse("Tortilli'a");
        cuisine.setDessert("Tres Leches");
        cuisine.setPrice(12);
        list.add(cuisine);
        cuisine = new MexicanCuisine();
        cuisine.setId(2);
        cuisine.setMainCurse("Burrito");
        cuisine.setDessert("Natilla de nuez");
        cuisine.setPrice(45);
        list.add(cuisine);
        //when
        List<MexicanCuisine> list1 = mexicanCuisineService.getAll();
        //then
        Assert.assertThat(list1, Matchers.hasSize(3));
        Assert.assertEquals(list,list1);

    }

    @Test
    public void should_add(){
        //given
        MexicanCuisine cuisine = new MexicanCuisine();
        cuisine.setId(0);
        cuisine.setMainCurse("Quesadilla");
        cuisine.setDessert("Lime Pie");
        cuisine.setPrice(17);
        //when
        mexicanCuisineService.add(cuisine);
        //then
        verify(mexicanCuisineRepository, times(1)).save(any());
    }

    private List<MexicanCuisine> prepareMockData(){
        List<MexicanCuisine> list = new ArrayList<>();
        MexicanCuisine cuisine = new MexicanCuisine();
        cuisine.setId(0);
        cuisine.setMainCurse("Quesadilla");
        cuisine.setDessert("Lime Pie");
        cuisine.setPrice(17);
        list.add(cuisine);
        cuisine = new MexicanCuisine();
        cuisine.setId(1);
        cuisine.setMainCurse("Tortilli'a");
        cuisine.setDessert("Tres Leches");
        cuisine.setPrice(12);
        list.add(cuisine);
        cuisine = new MexicanCuisine();
        cuisine.setId(2);
        cuisine.setMainCurse("Burrito");
        cuisine.setDessert("Natilla de nuez");
        cuisine.setPrice(45);
        list.add(cuisine);
        return list;
    }
}
