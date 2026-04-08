import { createAction, createActionGroup, emptyProps, props } from '@ngrx/store';
import { Product } from '../product';

export const loadProducts = createAction('[Product] Load Products');
export const loadProductsSuccess = createAction('[Product] Load Products Success', props<{ products: Product[] }>());
export const likeProduct = createAction('[Product] Like Product', props<{ productId: number }>());
export const addToCart = createAction('[Product] Add to cart', props<{ product: Product }>());
export const resetCart = createAction('[Product] Reset cart')
