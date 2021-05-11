import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Cart } from '../cart';
import { Item } from '../item';
import { Payment } from '../payment';
import { RestaurantserviceService } from '../restaurantservice.service';

@Component({
  selector: 'app-payment-id-exist',
  templateUrl: './payment-id-exist.component.html',
  styleUrls: ['./payment-id-exist.component.css']
})
export class PaymentIdExistComponent implements OnInit {

  payment:Payment=new Payment(0,"",0,new Date,new Cart(0,0,new Item(0,"",0)));
 
  Cpayment!: Observable<Payment>;
  Cpayment1!: Observable<Payment>;
  submitted=false;
  error:any;
  signupForm:any;

  constructor(private restaurantservice:RestaurantserviceService,private router:Router) { }

  ngOnInit(): void {

    this.signupForm = new FormGroup({
      payment_id: new FormControl('482',[ Validators.required, Validators.pattern('^[0-9]+$')]),
      
});
  }



  onSubmit()
{
  console.log(this.signupForm);
    console.log(this.signupForm.get('payment_id').value);

    this.submitted=true;
    this.restaurantservice.getPayById(this.payment.payment_id).subscribe(data=>alert("payment details found"),
   // error=>{alert(error.error.message)},
    );
}
  
}