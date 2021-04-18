package com;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.model.Cart;
import com.model.Item;
import com.repository.CartRepository;
import com.repository.ItemRepository;
import com.service.CartService;
import com.service.ItemService;


@SpringBootTest
public class CartIAndtemTests {
	
	  //For Cart

	  @Autowired
	  private CartService cs;

	  @MockBean
	  private CartRepository crepo;

	  @Test
	  public void cartDetails() throws Exception
	  {
	  	Cart cart=new Cart();
	  	cart.setCart_id(57);
	    	cart.setTotal_cost(100);
	  	
	  	Optional<Cart> Cart1=Optional.ofNullable(cart);
	  		
	  	  Mockito.when(crepo.findById(57)).thenReturn(Cart1);
	  	  assertThat(cs.getCartDetails(57)).isEqualTo(cart);
	  	
	  	
	  }
	 
	  
	// For Item
	  
	  @Autowired
		private ItemService itemservice;
		
		@MockBean
		private ItemRepository irepo;
		
		
		@Test		
	public void testGetAllItem(){

			Item items=new Item();
			items.setItemId(10);
			items.setItemName("Chicken Biryani");
			items.setCost(200);
			//items.setQuantity(1);
			Item items1=new Item();
			items1.setItemId(11);
			items1.setItemName("mutton biryani");
			items1.setCost(250);
			//items1.setQuantity(1);
			
			List<Item> ItemsList = new ArrayList<>(); 
			ItemsList.add(items);
			ItemsList.add(items1);
			
		    Mockito.when(irepo.findAll()).thenReturn(ItemsList);
		    
		    assertThat(itemservice.getListOfItems()).isEqualTo(ItemsList);
		}

		
		

}
