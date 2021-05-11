import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Cart } from '../cart';
import { Item } from '../item';
import { Payment } from '../payment';
import { RestaurantserviceService } from '../restaurantservice.service';

@Component({
  selector: 'app-makepayement',
  templateUrl: './makepayement.component.html',
  styleUrls: ['./makepayement.component.css']
})
export class MakepayementComponent implements OnInit {

  payment:Payment=new Payment(0,"",0,new Date,new Cart(0,0,new Item(0,"",0)));
  makepay!: Observable<Payment>;
  submitted=false;
  signupForm: any;
  //public error=null;
  //public error=null;
  error: any;
  ;

  constructor(private restaurantservice:RestaurantserviceService,private router:Router) { }

  ngOnInit() {

    this.signupForm = new FormGroup({
      cart_id: new FormControl('482',[ Validators.required, Validators.pattern('^[0-9]+$')]),
      payment_mode:new FormControl('cash/online',Validators.required),
});

  }

  onSubmit()
  {
  
    console.log(this.signupForm);
    console.log(this.signupForm.get('cart_id').value);
   // alert("Welcome "+this.signupForm.get('cart_id').value + "  Form Submitted Successfully");

    this.submitted=true;
   
   this.makepay=this.restaurantservice.makePayment(this.payment);
   this.makepay.subscribe(data=>alert("Payment done"),
                      //  error=>this.errorMsg=error
                       // this.error=err.error.error
                       error=>alert("CartId not exists. Enter correct cartId"),
                       
                       /* err=>{
                         
                         console.log(err);
                         this.error=err.error.error.message;
                         
                         
                       } */
                        );
                        
                        
                        

   this.router.navigate(['/custhomepage']);
   
}
}