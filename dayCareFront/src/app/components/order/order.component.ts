import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { DomSanitizer } from '@angular/platform-browser';
import { ToastrService } from 'ngx-toastr';
import { HandleFile } from 'src/app/models/HandleFile';
import { Order } from 'src/app/models/Order';
import { OrderServiceService } from 'src/app/services/order/order-service.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.scss']
})
export class OrderComponent implements OnInit {
  orderForm: FormGroup;
  order:Order;
  constructor( private toastr: ToastrService,
    private orderService:OrderServiceService,
    private sanitizer:DomSanitizer) {
      this.order={
        dogName: null,
        dogBreed:null,
        dayCareDate:null,
        groomingServices:null,
        description: null,
        images:[],
      }
      this.orderForm = new FormGroup({
        dogName: new FormControl(null,),
        dogBreed: new FormControl(null),
        dayCareDate: new FormControl(null),
        groomingServices: new FormControl(null),
        description: new FormControl(null),
      });
     }

  ngOnInit(): void {
  }

  submit(){
    this.order.dogName=this.orderForm.get('dogName').value;
    this.order.dogBreed=this.orderForm.get('dogBreed').value;
    this.order.dayCareDate=this.orderForm.get('dayCareDate').value;
    this.order.groomingServices=this.orderForm.get('groomingServices').value;
    this.order.description=this.orderForm.get('description').value;
    const formData=new FormData();

    formData.append(
      'orderDto',
      new Blob([JSON.stringify(this.order)],{type:'application/json'})
    )
    for(var i=0;i<this.order.images.length;i++){
      formData.append(
        "images",
        this.order.images[i].file,
        this.order.images[i].file.name
      );
    }
    if (this.orderForm.invalid) {
      console.log("hello")
      return;
    }else{
  
      this.orderService.saveOrder(formData).subscribe(
        response => {
          console.log("successfully added booking ", response);
          this.toastr.success('added booking successfully!');

        },
        error => {
          console.log("something went wrong", error);
          this.toastr.error("An error occurred");

         }
      );
    }   
  }
  onFileSelect(event:any){
    if(event.target.files){
     const file = event.target.files[0];
     const handleFile:HandleFile={
         file:file,
         url:this.sanitizer.bypassSecurityTrustUrl(window.URL.createObjectURL(file))
     }
     this.order.images.push(handleFile)
    }
 }
 removeImage(i:number){
   this.order.images.splice(i,1);
 }
}
