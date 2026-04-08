import { createAction, createActionGroup, emptyProps, props } from '@ngrx/store';


export const removeFromCart = createAction(
  '[Cart] Remove item',
  props<{ productId: number }>()
);

export const decreaseQuantity = createAction(
  '[Cart] Decrease item quantity',
  props<{ productId: number }>()
)
