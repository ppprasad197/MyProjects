import { createReducer, on } from '@ngrx/store';
import * as ProductActions from '../actions/product.actions';
import { ProductState } from '../product';

export const productFeatureKey = 'product';

export const initialState: ProductState = {
  products: [],
  loading: false
};

export const productReducer = createReducer(
  initialState,
  on(ProductActions.loadProducts, (state) => ({
    ...state,
    loading: true
  })),

  on(ProductActions.loadProductsSuccess, (state, { products }) => ({
    ...state,
    products,
    loading: false
  })),

  on(ProductActions.likeProduct, (state, { productId }) => ({
    ...state,
    products: state.products.map(p =>
      p.id === productId ? { ...p, liked: !p.liked } : p
    )
  }))
);

