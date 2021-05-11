import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../customer';
import { RestaurantserviceService } from '../restaurantservice.service';

@Component({
  selector: 'app-customers-list',
  templateUrl: './customers-list.component.html',
  styleUrls: ['./customers-list.component.css']
})
export class CustomersListComponent implements OnInit {

  customer:Customer = new Customer(0,"","","","","",);
 

  customers:Customer[] | undefined; //defining property & it is the type of Customer Array



  constructor(private customerService: RestaurantserviceService , private router:Router) { }

  ngOnInit(): void {

    this.getCustomers();

    
  }
  
  private getCustomers()
  {
    this.customerService.getCustomersList().subscribe(data =>
      {
        this.customers=data;

      })
  }


  

  
   deleteCustomer(customer_id:number){

    {
     this.customerService.deleteCustomer(customer_id).subscribe(data=>{
       alert("deleted Successfully"),(error: any)=>console.log(error)
       console.log(data); 
      this.getCustomers();
      }
       );

  // this.customerService.deleteCustomer(customer_id).subscribe(data=> alert("Deleted successfully"),error=>console.log(error));
   
  //  this.router.navigate(['customers']);

  }
  }

  updateCustomer(customer_id:number){
    this.router.navigate(['updatecust',customer_id]);

  }
 
}
