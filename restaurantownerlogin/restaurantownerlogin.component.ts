import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import {RestaurantOwnerLogin} from '../restaurant-owner-login';
import { RestaurantserviceService } from '../restaurantservice.service';

@Component({
  selector: 'app-restaurantownerlogin',
  templateUrl: './restaurantownerlogin.component.html',
  styleUrls: ['./restaurantownerlogin.component.css']
})
export class RestaurantownerloginComponent implements OnInit {
  restaurantOwner:RestaurantOwnerLogin=new RestaurantOwnerLogin("","");
  restowner!: Observable<RestaurantOwnerLogin>;
submitted=false;

  constructor(private restaurantService:RestaurantserviceService,private router:Router) { }

  ngOnInit(): void {
  }

  onSubmit(){
    // this.submitted=true;
  this.restaurantService.LoginOfRestaurantOwner(this.restaurantOwner).subscribe(data=>alert("RestaurantOwner registered successfully"));
  // alert("RestaurantOwner registered successfully");
  // data = JSON.parse(JSON.stringify(data))
 this.router.navigate(['/restregister']);
 //this.customer=new CustomerLogin("","");
  }

}
