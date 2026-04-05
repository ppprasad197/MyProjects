import { createAction, createActionGroup, emptyProps, props } from '@ngrx/store';
import { Product } from '../product';

export const ProductActions = createActionGroup({
  source: 'Product',
  events: {
    'Load Products': emptyProps(),
  }
});

export const loadProducts = createAction('[Product] Load Products');
export const loadProductsSuccess = createAction('[Product] Load Products Success', props<{ products: Product[] }>());
export const likeProduct = createAction('[Product] Like Product', props<{ productId: number }>());
export const addToCart = createAction('[Product] Add to cart', props<{ product: Product }>());
