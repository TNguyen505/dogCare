import { Order } from './models/Order';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { SignInComponent } from './components/sign-in/sign-in.component';
import { SignUpComponent } from './components/sign-up/sign-up.component';
import { OrderComponent } from './components/order/order.component';
import { OrdersComponent } from './components/orders/orders.component';
import { OrderInfoComponent } from './components/order-info/order-info.component';
import { ContactComponent } from './components/contact/contact.component';

const routes: Routes = [{
  path: '',
  redirectTo: '/home',
  pathMatch: 'full',
  title: 'Home || DogDayCare'
},
{
  path: 'home',
  component: HomeComponent,
  title: 'Home || DogDayCare'
},
{
  path: 'login',
  component: SignInComponent,
  title: 'login || DogDayCare'
},
{
  path: 'signup',
  component: SignUpComponent,
  title: 'signup || DogDayCare'
},
{
  path: 'place/order',
  component: OrderComponent,
  title: 'place order || DogDayCare'
},
{
  path: 'orders',
  component: OrdersComponent,
  title: 'orders || DogDayCare'
},
{
  path: 'orderInfo',
  component: OrderInfoComponent,
  title: 'orderInfo || DogDayCare'
},
{
  path: 'contacts',
  component: ContactComponent,
  title: 'contacts || DogDayCare'
},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
