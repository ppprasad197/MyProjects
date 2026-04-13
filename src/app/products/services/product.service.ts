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
        quantity: 11,
        price: 50000,
        image: 'assets/laptop.jpg',
        liked: false,
        description: "This is best you will get"
      },
      {
        id: 2,
        name: 'Phone',
        quantity: 8,
        price: 20000,
        image: 'assets/mobile.jpg',
        liked: false,
        description: "This is best you will get"
      }
    ]);
  }
}
