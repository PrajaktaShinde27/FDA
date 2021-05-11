import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Item } from '../item';
import { Restaurant } from '../restaurant';
import { RestaurantserviceService } from '../restaurantservice.service';

@Component({
  selector: 'app-rest-register',
  templateUrl: './rest-register.component.html',
  styleUrls: ['./rest-register.component.css']
})
export class RestRegisterComponent implements OnInit {

  restaurant:Restaurant=new Restaurant(0,"","","",new Item(0,"",0));
  makereg!: Observable<Restaurant>;
submitted=false;

  signupForm: any;
  //public error=null;
  //public error=null;
  error: any;

  constructor(private httpClientService:RestaurantserviceService,private router:Router) {

   }


  // onClick() {
  //   this.submitted = true;
  //     this.Crest=this.httpClientService.createRestaurant(this.restaurant);
  //     this.Crest.subscribe(data=>alert("restaurant registeration successfully."));
  //     this.router.navigate(['/resthomepage']);
  //    // location.reload();
  
  // }

  registrationForm: any;
  
  ngOnInit() {
    this.registrationForm = new FormGroup({
          rname: new FormControl('madhu', Validators.required),
          address: new FormControl('kukatpally', Validators.required),
          contactNo:new FormControl('9100718922', Validators.required),
    
     });
    }
     onSubmit() {
      console.log(this.registrationForm);
      console.log(this.registrationForm.get('rest_name').value);
      this.submitted=true;

      this.makereg=this.httpClientService.createRestaurant(this.restaurant);
   this.makereg.subscribe(data=>alert("Creation done"),
                       error=>alert("RestName not exists. Enter correct cartId"),
                       
                        );                                                                        
   this.router.navigate(['/home']);
   
}


}