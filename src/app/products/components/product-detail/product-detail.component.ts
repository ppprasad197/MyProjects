import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { selectProductById } from '../../selectors/product.selectors';
import { CommonModule } from '@angular/common';
import { Product } from '../../product';

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
    console.log("ng on in it from pdc");
    this.productId = Number(this.route.snapshot.paramMap.get('id'));
    this.product = this.store.select(selectProductById(this.productId));
    console.log(this.product + ' ' + this.productId);
  }
}
