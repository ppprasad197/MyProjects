import { createReducer, on } from '@ngrx/store';
import { Product } from '../../products/product';
import * as ProductActions from '../../products/actions/product.actions';

export const cartFeatureKey = 'cart';

export interface CartState {
  items: Product[];
}

export const initialState: CartState = {
  items: []
};

export const cartReducer = createReducer(
  initialState,
  // on(ProductActions.addToCart, (state, { product }) => {
  //   return {
  //     ...state,
  //     // items: [...state.items, product]
  //     items: [...state.items, { ...product }]
  //   }
  // })

  on(ProductActions.addToCart, (state, { product }) => {

    const exists = state.items.find(p => p.id === product.id);

    if (exists) return state;

    return {
      ...state,
      items: [...state.items, { ...product }]
    };
  })
);

