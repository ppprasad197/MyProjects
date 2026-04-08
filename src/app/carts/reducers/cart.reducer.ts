import { createReducer, on } from '@ngrx/store';
import { Product } from '../../products/product';
import * as ProductActions from '../../products/actions/product.actions';
import * as CartActions from '../actions/cart.actions';

export const cartFeatureKey = 'cart';

export interface CartState {
  items: Product[];
}

export const initialState: CartState = {
  items: []
};

export const cartReducer = createReducer(
  initialState,

  on(ProductActions.addToCart, (state, { product }) => {
    return {
      ...state,
      items: [...state.items, { ...product }]
    };
  }),

  on(ProductActions.resetCart, () => initialState),

  on(CartActions.removeFromCart, (state, { productId }) => ({
    ...state,
    items: state.items.filter(p => p.id !== productId)
  })),

  on(CartActions.decreaseQuantity, (state, { productId }) => {
    const count = state.items.findIndex(p => p.id === productId);
    if (count === -1) return state;

    const totalItems = [...state.items];
    totalItems.splice(count, 1);

    return {
      ...state,
      items: totalItems
    }
  })
);

