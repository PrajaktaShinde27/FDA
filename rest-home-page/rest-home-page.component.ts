import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Item } from '../item';
import { Restaurant } from '../restaurant';
import { RestaurantserviceService } from '../restaurantservice.service';

@Component({
  selector: 'app-rest-home-page',
  templateUrl: './rest-home-page.component.html',
  styleUrls: ['./rest-home-page.component.css']
})
export class RestHomePageComponent implements OnInit {

  restaurants:Restaurant[]|any;
  items!: Item[];
  rid!:number;
  item:Item=new Item(0,"",0);
  restaurant:Restaurant=new Restaurant(0,"","","",new Item(0,"",0));
  id!: number;
  EmpItems: Observable<Item[]> | undefined;
  rest:Observable<Restaurant>|any;
  CEmpItems!: Observable<Item>;
  DEmpItems!: Observable<Item>;
  UEmpItems!: Observable<Item>;
  selectedValue: number=0;
  constructor(private httpClientService:RestaurantserviceService,private router:Router) { }

  ngOnInit(): void {
    this.EmpItems=this.httpClientService.getItems();
      this.EmpItems.subscribe((data)=>this.items=data);
  }

  deleteItems(itemId:number):void{
    this.DEmpItems=this.httpClientService.deleteItems(itemId);
    alert("Item deleted Successfully");
    location.reload();
    this.DEmpItems.subscribe(()=>this.httpClientService.getItems()); 
  }
  deleteRestaurant(rid:number):void{
    this.DEmpItems=this.httpClientService.deleteItems(rid);
    alert("Restaurant deleted Successfully");
    this.router.navigate(['/restregister']);
    //location.reload();
    // this.DEmpItems.subscribe(()=>this.httpClientService.getItems()); 
  }
  updateItem(id:number):void{
    this.router.navigate(['update',id]);
}
updateRestaurant(rid:number):void{
  this.router.navigate(['updaterest',rid]);
}

// check():Restaurant
// {
//   if(this.selectedValue==76)
//   {
//     this.restaurant=this.restaurants[0];
//     return this.restaurant;
//   }
//   return this.restaurant;
// }

}
