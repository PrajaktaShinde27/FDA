import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import {CustomerLogin} from '../customer-login';
import { RestaurantserviceService } from '../restaurantservice.service';

@Component({
  selector: 'app-customer-registration',
  templateUrl: './customer-registration.component.html',
  styleUrls: ['./customer-registration.component.css']
})
export class CustomerRegistrationComponent implements OnInit {
customer:CustomerLogin=new CustomerLogin("","");
  cust!: Observable<CustomerLogin>;
submitted=false;
  constructor(private restaurantService:RestaurantserviceService,private router:Router) { }

  ngOnInit(): void {
  }

  /* onSubmit(){
this.submitted=true;
this.cust=this.restaurantService.RegisterationOfCustomer(this.customer);
this.cust?.subscribe(data=>alert("Registeration Successful"));
this.router.navigate(['/customer']);
  } */
  onSubmit(){
    this.submitted=true;
  this.restaurantService.RegisterationOfCustomer(this.customer).subscribe(data=>alert("customer added successfully"));
  this.router.navigate(['/customerlogin']);
 //this.customer=new CustomerLogin("","");
  }
}



  

  

  
