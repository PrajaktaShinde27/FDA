import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import {CustomerLogin} from '../customer-login';
import { RestaurantserviceService } from '../restaurantservice.service';


@Component({
  selector: 'app-customerlogin',
  templateUrl: './customerlogin.component.html',
  styleUrls: ['./customerlogin.component.css']
})
export class CustomerloginComponent implements OnInit {
  customer:CustomerLogin=new CustomerLogin("","");
  cust!: Observable<CustomerLogin>;
submitted=false;

  constructor(private restaurantService:RestaurantserviceService,private router:Router) { }

  ngOnInit(): void {
  }
  onSubmit(){
    this.submitted=true;
  this.restaurantService.LoginOfCustomer(this.customer).subscribe(data=>alert("Login successful"));
  this.router.navigate(['/custhomepage']);
 //this.customer=new CustomerLogin("","");
  }

}
