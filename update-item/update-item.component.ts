import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Item } from '../item';
import { RestaurantserviceService } from '../restaurantservice.service';

@Component({
  selector: 'app-update-item',
  templateUrl: './update-item.component.html',
  styleUrls: ['./update-item.component.css']
})
export class UpdateItemComponent implements OnInit {
  id!: number;
  item!: Item;
  Uitem!: Observable<Item>;
  itemid!: string;
  
  constructor(private route: ActivatedRoute,private router: Router,
    private httpClientService: RestaurantserviceService) { }

  ngOnInit(): void {
    this.itemid = this.route.snapshot.params['id'];
    this.id=Number.parseInt(this.itemid);
    this.item=new Item(this.id,"",0);
    console.log(this.id);
    this.httpClientService.getItemById(this.id).subscribe(data => {
      console.log(data)
      this.item=data;
    }, error => console.log(error)); 
  }

  onSubmit() {
    this.Uitem=this.httpClientService.updateItem(this.item);
  this.Uitem.subscribe(data=>{alert("Item updated successfully.");},
  error => alert("Item does not exist in the database cannot be updated"));
  this.router.navigate(['/resthomepage']);
  }
  list(){
    this.router.navigate(['resthomepage']);
  }

}
