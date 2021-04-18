package com.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import com.model.Cart;


public interface CartRepository extends JpaRepository<Cart,Integer> {

	

	
	//@Query(value="select sum(item.cost) from item  inner join cart on cart.cart_id=:item.items_cart_id ") 
	//int findByTotalCost(int cid);
}
