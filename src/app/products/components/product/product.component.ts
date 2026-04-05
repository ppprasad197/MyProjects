import { Component } from '@angular/core';
import { Store } from '@ngrx/store';
import { addToCart, likeProduct, loadProducts } from '../../actions/product.actions';
import { selectProducts } from '../../selectors/product.selectors';
import { Product } from '../../product';
import { CommonModule } from '@angular/common';
import { selectCartCount, selectProductCount } from '../../../carts/selectors/cart.selectors';

@Component({
  selector: 'app-product',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './product.component.html',
  styleUrl: './product.component.css'
})
export class ProductComponent {
  products: any;
  cartCount: any;

  constructor(private store: Store) {
    store.dispatch(loadProducts());
    this.products = store.select(selectProducts);
    this.cartCount = store.select(selectCartCount);
  }

  like(id: number) {
    this.store.dispatch(likeProduct({ productId: id }));
  }

  addToCart(product: Product) {
    this.store.dispatch(addToCart({ product }));
    // this.store.dispatch(addToCart({ product: { ...product } }));
  }

  getCount(id: number) {
  return this.store.select(selectProductCount(id));
}


}
