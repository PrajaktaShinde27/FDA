import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import {PaymentComponent} from './payment/payment.component';
import {ContactusComponent} from './contactus/contactus.component';
import {AboutusComponent} from './aboutus/aboutus.component';
import {PolicyComponent} from './policy/policy.component';
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
import { MakepayementComponent } from './makepayement/makepayement.component';
import { PaymentIdExistComponent } from './payment-id-exist/payment-id-exist.component';

const routes: Routes = [
  { path: '', component:HomePageComponent, pathMatch: 'full' },
  {path:'home',component:HomeComponent},
  {path:'homepage',component:HomePageComponent},
  {path:'pay',component:PaymentComponent},
  {path:'contactUs',component:ContactusComponent},
  {path:'aboutUs',component:AboutusComponent},
  {path:'terms',component:PolicyComponent},
  {path:'customereg',component:CustomerRegistrationComponent},
  {path:'restownerreg',component:RestaurantownerregistrationComponent},
  {path:'customerlogin',component:CustomerloginComponent},
  {path:'restownerlogin',component:RestaurantownerloginComponent},
  {path :'restviewdetails',component:RestOwnerRestViewDetailsComponent},
  {path :'allrest',component:AllRestaurantsComponent},
  {path:'items',component:MenuComponent},
  {path:'resthomepage',component:RestHomePageComponent},
  {path:'additemtorest',component:AddItemInRestComponent},
  {path:'updaterest/:id',component:UpdateRestaurantComponent  },
  {path:'restregister',component:RestRegisterComponent},
  { path: 'update/:id',component:UpdateItemComponent},
  {path:'createcust',component:CreateCustomerComponent},
  {path:'custhomepage',component:CustomerHomePageComponent},
  {path:'updatecust',component:UpdateCustomerComponent},
  {path:'custolist',component:CustomersListComponent},
  {path:'makepay',component:MakepayementComponent},
  {path:'payidexist',component:PaymentIdExistComponent}
  
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }


