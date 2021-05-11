import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Payment} from './payment';
import { Observable } from 'rxjs';
import { CustomerLogin } from './customer-login';
import { RestaurantOwnerLogin } from './restaurant-owner-login';
import { Restaurant } from './restaurant';
import { Item } from './item';
import { Customer } from './customer';

@Injectable({
  providedIn: 'root'
})
export class RestaurantserviceService {
  payment!: Payment;

  constructor(private httpClient:HttpClient) { }

    private baseUrl="http://localhost:8080/api2/";

  /* public  createpayment(payment: any):Observable<Payment>
  {
    return this.httpClient.post<Payment>(`${this.baseUrl}getpayment`,payment);
  } */  

  public  getPayById(payment_id:number):Observable<Payment>{
    return this.httpClient.get<Payment>("http://localhost:8080/api1/getPayment"+payment_id);
  }

  public RegisterationOfCustomer(customer:CustomerLogin):Observable<CustomerLogin>
  {
    return this.httpClient.post<CustomerLogin>("http://localhost:8080/api2/RegisterationOfCustomer",customer);
  
  }
  public cancelPayment(payment_id:number):Observable<Payment>
  {
    return this.httpClient.delete<Payment>(`${this.baseUrl}deletePayment/`+payment_id);
  }
  public RegisterationOfRestaurantOwner(restaurantOwner:RestaurantOwnerLogin):Observable<RestaurantOwnerLogin>
  {
    return this.httpClient.post<RestaurantOwnerLogin>("http://localhost:8080/api2/RegisterationOfRestaurantOwner",restaurantOwner);
  
  }

  public LoginOfCustomer(customer:CustomerLogin):Observable<CustomerLogin>
  {
    return this.httpClient.post<CustomerLogin>("http://localhost:8080/api2/LoginOfCustomer",customer);
  
  }

  public LoginOfRestaurantOwner(restaurantOwner:RestaurantOwnerLogin):Observable<RestaurantOwnerLogin>
  {
    return this.httpClient.post<RestaurantOwnerLogin>("http://localhost:8080/api2/LoginOfRestaurantOwner",restaurantOwner);
  
  }
  public createRestaurant(restaurant: any):Observable<Restaurant>
  {
    return this.httpClient.post<Restaurant>("http://localhost:8080/restaurant/addRestaurant",restaurant);
  }
  public  getRestaurant():Observable<Restaurant[]>{
    return this.httpClient.get<Restaurant[]>("http://localhost:8080/restaurant/getRestaurant");
  }
  public getItemsByRestaurant(rid:number):Observable<Item[]>
{
  return this.httpClient.get<Item[]>("http://localhost:8080/restaurant/getItemsFromRestaurant"+rid);
}
public  getItems():Observable<Item[]>{
  return this.httpClient.get<Item[]>("http://localhost:8080/api/getItems");
}
public createItems(item: any):Observable<Item>
  {
    return this.httpClient.post<Item>("http://localhost:8080/api/addItem",item);
  }
  public deleteItems(itemId:number):Observable<Item>
  {
    return this.httpClient.delete<Item>("http://localhost:8080/api/deleteItem/"+itemId);
  }
public updateItem(item:Item):Observable<Item>
  {
    return this.httpClient.put<Item>("http://localhost:8080/api/updateItem/",item);
  }
public  getItemById(itemId:number):Observable<Item>{
    return this.httpClient.get<Item>("http://localhost:8080/api/getItem/"+itemId);
  }

public updateRestaurant(restaurant:Restaurant):Observable<Restaurant>
{
  return this.httpClient.put<Restaurant>("http://localhost:8080/restaurant/updateRestaurant/",restaurant);
}
public deleteRestaurant(rid:number):Observable<Restaurant>
{
  return this.httpClient.delete<Restaurant>("http://localhost:8080/restaurant/deleteRestaurant/"+rid);
}
public  getARestaurantById(rid:number):Observable<Restaurant>{
  //console.log(rid);
  return this.httpClient.get<Restaurant>("http://localhost:8080/restaurant/getItemsFromRestaurant/"+rid);
}
//customer
public createCustomer(customer:Customer):Observable<Object>{
  return this.httpClient.post("http://localhost:8080/api4/addCustomer",customer);
}
public updateCustomer(id:number):Observable<Customer>
{
  return this.httpClient.put<Customer>("http://localhost:8080/api4/updateCustomer/",id);
}
public getCustomerById(id:number):Observable<Customer>{
  return this.httpClient.get<Customer>("http://localhost:8080/api4/getCustomerById/"+id);
}
public getCustomersList(): Observable <Customer[]>{
  return this.httpClient.get <Customer[]>("http://localhost:8080/api4/getCustomers");
}
public deleteCustomer(customer_id:number): Observable <Object>{
  return this.httpClient.delete("http://localhost:8080/api4/deleteCustomer/"+customer_id);
}
public  makePayment(payment:Payment):Observable<Payment>{
  //return this.httpClient.get<Payment>("http://localhost:8080/api1/getPayment"+payment_id);
  return this.httpClient.post<Payment>("http://localhost:8080/api1/createpay",payment);
  //.pipe(catchError(this.errorHandler));
}
}








 
  