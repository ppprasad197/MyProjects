import { Injectable } from '@angular/core';
import { of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor() { }

  getProducts() {
    return of([
      {
        id: 1,
        name: 'Laptop',
        price: 50000,
        image: 'assets/laptop.jpg', 
        liked: false
      },
      {
        id: 2,
        name: 'Phone',
        price: 20000,
        image: 'assets/mobile.jpg', 
        liked: false
      }
    ]);
  }
}
