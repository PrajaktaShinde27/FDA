import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Item } from '../item';
import { Restaurant } from '../restaurant';
import { RestaurantserviceService } from '../restaurantservice.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  private _listFilter = '';
  //items: any;
 // values:Quantity[] = [];
  get listFilter(): string {
    return this._listFilter;
  }
  set listFilter(value: string) {
    this._listFilter = value;
    this.items = this.performFilter(value);
  }


  restaurants:Restaurant[]|any;
  item:Item=new Item(0,"",0);
  
 
  getItem:Observable<Item>|any;
  items: Item[] = [];
 
  total!:number;
  constructor(private httpClientService:RestaurantserviceService,private router:Router) { }

  ngOnInit(): void {
    this.getItem = this.httpClientService.getItems().subscribe({
      next: products => {
        this.items = products;
        this.items = this.items;
      }
    });
  this.getItem=this.httpClientService.getItems();
  this.getItem.subscribe((data: any)=>this.items=data);
  }
  clearLocal(){
    sessionStorage.clear();
  }
  performFilter(filterBy: string): Item[] {
    filterBy = filterBy.toLocaleLowerCase();
    return this.items.filter((item: Item) =>
      item.itemName.toLocaleLowerCase().includes(filterBy));
}
}