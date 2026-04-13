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

export const selectGroupedCartItems = createSelector(
  selectCartItems,
  (state) => {
    const grouped: any = {};

    state.forEach(item => {
      if (grouped[item.id]) {
        grouped[item.id].qty += 1;
      } else {
        grouped[item.id] = { ...item, qty: 1 };
      }
    });
    return Object.values(grouped);
  }
);