import { NgModule } from '@angular/core';
import { FormsModule ,ReactiveFormsModule} from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PaymentComponent } from './payment/payment.component';
import {HttpClientModule} from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './component/header/header.component';
import { FooterComponent } from './component/footer/footer.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { ContactusComponent } from './contactus/contactus.component';
import { PolicyComponent } from './policy/policy.component';
import { CustomerRegistrationComponent } from './customer-registration/customer-registration.component';
import { RestaurantownerregistrationComponent } from './restaurantownerregistration/restaurantownerregistration.component';
import { CustomerloginComponent } from './customerlogin/customerlogin.component';

import { RestaurantownerloginComponent } from './restaurantownerlogin/restaurantownerlogin.component';
import { HomePageComponent } from './home-page/home-page.component';
import { RestOwnerRestViewDetailsComponent } from './rest-owner-rest-view-details/rest-owner-rest-view-details.component';
import { AllRestaurantsComponent } from './all-restaurants/all-restaurants.component';
import { MenuComponent } from './menu/menu.component';
import { RestHomePageComponent } from './rest-home-page/rest-home-page.component';
import { AddItemInRestComponent } from './add-item-in-rest/add-item-in-rest.component';
import { UpdateItemComponent } from './update-item/update-item.component';
import { UpdateRestaurantComponent } from './update-restaurant/update-restaurant.component';
import { RestRegisterComponent } from './rest-register/rest-register.component';
import { CreateCustomerComponent } from './create-customer/create-customer.component';
import { CustomerHomePageComponent } from './customer-home-page/customer-home-page.component';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';

import { CustomersListComponent } from './customers-list/customers-list.component';
import { PaymentIdExistComponent } from './payment-id-exist/payment-id-exist.component';
import { MakepayementComponent } from './makepayement/makepayement.component';


@NgModule({
  declarations: [
    AppComponent,
    PaymentComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    AboutusComponent,
    ContactusComponent,
    PolicyComponent,
    CustomerRegistrationComponent,
    RestaurantownerregistrationComponent,
    CustomerloginComponent,
    RestaurantownerloginComponent,
    HomePageComponent,
    RestOwnerRestViewDetailsComponent,
    AllRestaurantsComponent,
    MenuComponent,
    RestHomePageComponent,
    AddItemInRestComponent,
    UpdateItemComponent,
    UpdateRestaurantComponent,
    RestRegisterComponent,
    CreateCustomerComponent,
    CustomerHomePageComponent,
    UpdateCustomerComponent,
 
    CustomersListComponent,
      PaymentIdExistComponent,
      MakepayementComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
