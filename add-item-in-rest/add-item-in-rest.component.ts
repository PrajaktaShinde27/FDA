import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Item } from '../item';
import { RestaurantserviceService } from '../restaurantservice.service';

@Component({
  selector: 'app-add-item-in-rest',
  templateUrl: './add-item-in-rest.component.html',
  styleUrls: ['./add-item-in-rest.component.css']
})
export class AddItemInRestComponent implements OnInit {

  item:Item=new Item(0,"",0);
  Citem: Observable<Item> | undefined ;
submitted=false;


makepay!: Observable<Item>;
signupForm: any;
//public error=null;
//public error=null;
error: any;


constructor(private restaurantservice:RestaurantserviceService,private router:Router) { }

ngOnInit() {

  this.signupForm = new FormGroup({
    cost: new FormControl('482',[ Validators.required, Validators.pattern('^[0-9]+$')]),
    itemName:new FormControl('biryani',Validators.required),
    

});

}


  onSubmit() {
    this.submitted = true;
      this.makepay=this.restaurantservice.createItems(this.item);
      this.makepay.subscribe(data=>alert("Items Added to Restarant successfully."));
      this.router.navigate(['/resthomepage']);
     // location.reload();
  
  }
}
