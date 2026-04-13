import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Store } from '@ngrx/store';
import { selectCartCount, selectGroupedCartItems, selectProductCount } from '../../selectors/cart.selectors';
import { Observable } from 'rxjs';
import { CommonModule } from '@angular/common';
import { Product } from '../../../products/product';
import { addToCart } from '../../../products/actions/product.actions';
import { decreaseQuantity, removeFromCart } from '../../actions/cart.actions';

@Component({
  selector: 'app-cart',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './cart.component.html',
  styleUrl: './cart.component.css'
})
export class CartComponent {
  cartItems!: Observable<any[]>;

  constructor(private store: Store) { }

  ngOnInit() {
    this.cartItems = this.store.select(selectGroupedCartItems);
  }

  addToCart(product: Product) {
    this.store.dispatch(addToCart({ product }));
  }

  decreaseQuantity(id: number) {
    this.store.dispatch(decreaseQuantity({ productId: id }));
  }

  getCount(id: number) {
    console.log(this.store.select(selectProductCount(id)));
    return this.store.select(selectProductCount(id));
  }

  removeFromCart(id: number) {
    this.store.dispatch(removeFromCart({ productId: id }));
  }
}
