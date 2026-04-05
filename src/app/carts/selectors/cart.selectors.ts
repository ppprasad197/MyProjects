import { createFeatureSelector, createSelector } from '@ngrx/store';
import { CartState } from '../reducers/cart.reducer';

export const selectCartState = createFeatureSelector<CartState>('cart');

export const selectCartItems = createSelector(
    selectCartState,
    (state) => state.items
);

export const selectCartCount = createSelector(
    selectCartState,
    (state) => state.items.length
);
export const selectProductCount = (productId: number) =>
  createSelector(selectCartItems, (items) =>
    items.filter(p => p.id === productId).length
  );