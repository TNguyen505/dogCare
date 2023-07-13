import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Order } from 'src/app/models/Order';
import { OrderServiceService } from 'src/app/services/order/order-service.service';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.scss']
})
export class OrdersComponent implements OnInit {
  public orders: any;
  p = 1;
  pageSize = 10;
  elementsPerPage=10;
  collectionSize = 0;
  constructor(private router: Router,private orderService:OrderServiceService) { }

  ngOnInit( ): void {
    this.orderService.allOrders$(this.p,this.pageSize).subscribe(
      (orders) => {
        this.orders = orders;
        this.collectionSize = orders.totalPages;
      },
      (error) => {
        console.log(error);
      }
    );
  }
  onPageChange(event: number) {
    this.p = event;
    this.orderService.allOrders$(this.p,this.pageSize).subscribe(
      (orders) => {
        this.orders = orders;
        this.collectionSize = orders.totalPages;
      },
      (error) => {
        console.log(error);
      }
    );
  }
  goToOrder(order: Order) {
    localStorage.setItem("Order", JSON.stringify(order))
    this.router.navigate(['/orderInfo']);
  }
}
