package com.restaurant.services;

import com.restaurant.cuisines.ItalianCuisine;
import com.restaurant.cuisines.PolishCuisine;
import com.restaurant.repositories.ItalianCuisineRepository;
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
public class ItalianCuisineServiceTest {

    @Mock
    ItalianCuisineRepository italianCuisineRepository;

    @InjectMocks
    ItalianCuisineServiceImpl italianCuisineService;


    @Before
    public void init() {
        //given
        given(italianCuisineRepository.findAll()).willReturn(prepareMockData());
    }

    @Test
    public void should_get_all(){
        //given
        List<ItalianCuisine> list = new ArrayList<>();
        ItalianCuisine cuisine=new ItalianCuisine();
        cuisine.setId(6);
        cuisine.setMainCurse("Pizza");
        cuisine.setDessert("Tiramisu");
        cuisine.setPrice(30);
        list.add(cuisine);
        cuisine = new ItalianCuisine();
        cuisine.setId(7);
        cuisine.setMainCurse("Caprese");
        cuisine.setDessert("Panna Cotta");
        cuisine.setPrice(9);
        list.add(cuisine);
        cuisine = new ItalianCuisine();
        cuisine.setId(8);
        cuisine.setMainCurse("Spaghetti");
        cuisine.setDessert("Granita");
        cuisine.setPrice(50);
        list.add(cuisine);
        //when
        List<ItalianCuisine> list1 = italianCuisineService.getAll();
        //then
        Assert.assertThat(list1, Matchers.hasSize(3));
        Assert.assertEquals(list,list1);

    }

    @Test
    public void should_add(){
        //given
        ItalianCuisine cuisine=new ItalianCuisine();
        cuisine.setId(6);
        cuisine.setMainCurse("Pizza");
        cuisine.setDessert("Tiramisu");
        cuisine.setPrice(30);
        //when
        italianCuisineService.add(cuisine);
        //then
        verify(italianCuisineRepository, times(1)).save(any());
    }

    private List<ItalianCuisine> prepareMockData() {
        List<ItalianCuisine> list = new ArrayList<>();
        ItalianCuisine cuisine=new ItalianCuisine();
        cuisine.setId(6);
        cuisine.setMainCurse("Pizza");
        cuisine.setDessert("Tiramisu");
        cuisine.setPrice(30);
        list.add(cuisine);
        cuisine = new ItalianCuisine();
        cuisine.setId(7);
        cuisine.setMainCurse("Caprese");
        cuisine.setDessert("Panna Cotta");
        cuisine.setPrice(9);
        list.add(cuisine);
        cuisine = new ItalianCuisine();
        cuisine.setId(8);
        cuisine.setMainCurse("Spaghetti");
        cuisine.setDessert("Granita");
        cuisine.setPrice(50);
        list.add(cuisine);
        return list;
    }
}
