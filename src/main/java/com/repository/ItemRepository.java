package com.repository;



import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import com.model.Item;


public interface ItemRepository extends JpaRepository<Item,Integer>{

	Optional<Item> findByitemName(String itemName);

	//@Query("select sum(Item.cost) from Item where Item.items_cart_id=cart_id")
	//int findByTotalCost(int cart_id);

	
	
	
	
	
	//@NamedNativeQuery
//	@Query(value="select sum(item.cost) from item  inner join cart on cart.cart_id=:item.items_cart_id where cart.cart_id=:cid") 
	//@Query("select sum(cost) from Item where cid=?1")
	//@Query("select sum(cost) from Item where items_cart_id=cid")
//	@Query("select sum(item.cost) from item where items_cart_id=?1")
	//public int findByTotalCost(int cid);

	
	
	
}
