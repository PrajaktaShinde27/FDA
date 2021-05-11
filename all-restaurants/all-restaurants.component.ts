import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Item } from '../item';
import { Restaurant } from '../restaurant';
import { RestaurantserviceService } from '../restaurantservice.service';

@Component({
  selector: 'app-all-restaurants',
  templateUrl: './all-restaurants.component.html',
  styleUrls: ['./all-restaurants.component.css']
})
export class AllRestaurantsComponent implements OnInit {

  restaurants:Restaurant[]|any;
  drestaurants:Restaurant[] | any;
  restaurant:Restaurant= new Restaurant(0,"","","",new Item(0,"",0));

  rest:Observable<Restaurant>|any;
  drest:Observable<Restaurant>|any;
  urest:Observable<Restaurant>|any;

  constructor(private httpClientService:RestaurantserviceService,private router:Router) { }

  ngOnInit(): void {
    this.rest=this.httpClientService.getRestaurant();
      this.rest.subscribe((data: any)=>this.restaurants=data);
  }

  


}
