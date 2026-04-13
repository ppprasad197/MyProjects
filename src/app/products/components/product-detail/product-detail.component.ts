import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { selectProductById } from '../../selectors/product.selectors';
import { CommonModule } from '@angular/common';
import { Product } from '../../product';
import { addToCart } from '../../actions/product.actions';
import { selectProductCount } from '../../../carts/selectors/cart.selectors';
import { decreaseQuantity } from '../../../carts/actions/cart.actions';

@Component({
  selector: 'app-product-detail',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './product-detail.component.html',
  styleUrl: './product-detail.component.css'
})
export class ProductDetailComponent {
  productId!: number;
  product!: Observable<Product | undefined>;
  constructor(private route: ActivatedRoute, private store: Store) { }
  ngOnInit() {
    this.productId = Number(this.route.snapshot.paramMap.get('id'));
    this.product = this.store.select(selectProductById(this.productId));
  }

  addToCart(product: Product) {
    this.store.dispatch(addToCart({ product }));
  }

  getCount(id: number) {
    return this.store.select(selectProductCount(id));
  }

  decreaseQuantity(id: number) {
    this.store.dispatch(decreaseQuantity({ productId: id }));
  }


}
