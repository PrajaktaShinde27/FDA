import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from '../customer';
import { RestaurantserviceService } from '../restaurantservice.service';

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})
export class UpdateCustomerComponent implements OnInit {

  customer: Customer=new Customer(0,"","","","","");
  
  
  customer_id: number=0;


  constructor(private cutomerService: RestaurantserviceService , private router:Router,private route:ActivatedRoute) { }
  ngOnInit(): void {
    this.customer_id = this.route.snapshot.params['customer_id'];
    
    
     this.cutomerService.
     getCustomerById(this.customer_id).subscribe((data: Customer)=>
      {this.customer=data},
       (      error: any) =>console.log(error));
    
   

   
  }
  onSubmit()
{
  this.cutomerService.updateCustomer(this.customer_id).subscribe();
  this.router.navigate(['/custhomepage']);

}
}
