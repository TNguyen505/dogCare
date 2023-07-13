import { Component, OnInit } from '@angular/core';
import { Order } from 'src/app/models/Order';
import { OrderServiceService } from 'src/app/services/order/order-service.service';

@Component({
  selector: 'app-order-info',
  templateUrl: './order-info.component.html',
  styleUrls: ['./order-info.component.scss']
})
export class OrderInfoComponent implements OnInit {
  order:Order
  id:number
  constructor(private orderService:OrderServiceService) { }

  ngOnInit(): void {
    const orderDto = localStorage.getItem('Order');
    if(orderDto){
      this.order= JSON.parse(orderDto);
      this.id=JSON.parse(orderDto).orderId      } 
      this.orderService.getOrder(this.id).subscribe((order)=>this.order=order)
  }

}
