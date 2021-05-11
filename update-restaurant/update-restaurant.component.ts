import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Item } from '../item';
import { Restaurant } from '../restaurant';
import { RestaurantserviceService } from '../restaurantservice.service';

@Component({
  selector: 'app-update-restaurant',
  templateUrl: './update-restaurant.component.html',
  styleUrls: ['./update-restaurant.component.css']
})
export class UpdateRestaurantComponent implements OnInit {

  rid!: number;
  restaurant!: Restaurant;
  Urest!: Observable<Restaurant>;
  restid!: string;
  
  constructor(private route: ActivatedRoute,private router: Router,
    private httpClientService: RestaurantserviceService) { }

  ngOnInit(): void {
    this.restid = this.route.snapshot.params['id'];
    this.rid=Number.parseInt(this.restid);
    this.restaurant=new Restaurant(this.rid,"","","",new Item(this.rid,"",0));
    console.log(this.rid);
    this.httpClientService.getARestaurantById(this.rid).subscribe(data => {
      console.log(data)
      this.restaurant=data;
    },error => console.log(error)); 
  
  }


  onSubmit() {
    this.Urest=this.httpClientService.updateRestaurant(this.restaurant);
  this.Urest.subscribe(data=>{alert("Restaurant updated successfully.");},
  error => alert("Restaurant does not exist in the database cannot be updated"));
  this.router.navigate(['resthomepage']);
  }
  list(){
    this.router.navigate(['resthomepage']);
  }

}
