import { inject, Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { ProductService } from '../services/product.service';
import * as ProductActions from '../actions/product.actions';
import { map, mergeMap } from 'rxjs';


@Injectable()
export class ProductEffects {

  private action = inject(Actions);
  private productService = inject(ProductService);

  constructor(private actions$: Actions) { }

  loadProducts = createEffect(() =>
    this.action.pipe(
      ofType(ProductActions.loadProducts),
      mergeMap(() =>
        this.productService.getProducts().pipe(
          map(products => ProductActions.loadProductsSuccess({ products }))
        )
      )
    )
  );
}
