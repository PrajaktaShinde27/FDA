import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Item } from '../item';
import { Restaurant } from '../restaurant';
import {RestaurantOwnerLogin} from '../restaurant-owner-login';
import { RestaurantserviceService } from '../restaurantservice.service';

@Component({
  selector: 'app-restaurantownerregistration',
  templateUrl: './restaurantownerregistration.component.html',
  styleUrls: ['./restaurantownerregistration.component.css']
})
export class RestaurantownerregistrationComponent implements OnInit {

  restaurantOwner:RestaurantOwnerLogin=new RestaurantOwnerLogin("","");
  makereg!: Observable<RestaurantOwnerLogin>;
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
          name: new FormControl('madhu', Validators.required),
          pass: new FormControl(null, [Validators.required]),
         
    
     });
    }
     onSubmit() {
      console.log(this.registrationForm);
      console.log(this.registrationForm.get('name').value);
      this.submitted=true;

      this.makereg=this.httpClientService.RegisterationOfRestaurantOwner(this.restaurantOwner);
   this.makereg.subscribe(data=>alert("Creation done"),
                       error=>alert("RestName not exists. Enter correct cartId"),
                       
                        );                                                                        
   this.router.navigate(['/restownerlogin']);
   
}
// onSubmit(){
//       this.submitted=true;
//     this.httpClientService.RegisterationOfRestaurantOwner(this.restaurantOwner).subscribe(data=>alert("RestaurantOwner registered successfully"));
//    this.router.navigate(['/restownerlogin']);
//    //this.customer=new CustomerLogin("","");
//     }

}







//   restaurantOwner:RestaurantOwnerLogin=new RestaurantOwnerLogin("","");
//   restowner!: Observable<RestaurantOwnerLogin>;
// submitted=false;

//   constructor(private restaurantService:RestaurantserviceService,private router:Router) { }

//   ngOnInit(): void {
//   }

//   onSubmit(){
//     this.submitted=true;
//   this.restaurantService.RegisterationOfRestaurantOwner(this.restaurantOwner).subscribe(data=>alert("RestaurantOwner registered successfully"));
//  this.router.navigate(['/restownerlogin']);
//  //this.customer=new CustomerLogin("","");
//   }

// }









  

  
  




  

  

  
