import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../../products/product';
import { Store } from '@ngrx/store';
import { addToCart, likeProduct, resetCart } from '../../products/actions/product.actions';
import * as ProductActions from '../../products/actions/product.actions';
import { selectProducts } from '../../products/selectors/product.selectors';
import { Router, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { selectProductCount } from '../../carts/selectors/cart.selectors';
import { decreaseQuantity, removeFromCart } from '../../carts/actions/cart.actions';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [RouterLink, CommonModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  products!: Observable<Product[]>;
  constructor(private store: Store, private router: Router) { }
  ngOnInit() {
    this.store.dispatch(ProductActions.loadProducts());
    this.products = this.store.select(selectProducts);
  }

  like(id: number) {
    this.store.dispatch(likeProduct({ productId: id }));
  }

  addToCart(product: Product) {
    this.store.dispatch(addToCart({ product }));
  }

  getCount(id: number) {
    console.log(this.store.select(selectProductCount(id)));
    return this.store.select(selectProductCount(id));
  }

  resetCart() {
    this.store.dispatch(resetCart());
  }

  removeFromCart(id: number) {
    this.store.dispatch(removeFromCart({ productId: id }));
  }

  decreaseQuantity(id: number) {
    this.store.dispatch(decreaseQuantity({ productId: id }));
  }

  viewDetails(id: number) {
    this.router.navigate(['/product', id]);
  }

}
