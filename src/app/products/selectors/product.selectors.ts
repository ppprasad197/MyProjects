import { createFeatureSelector, createSelector } from '@ngrx/store';
import { ProductState } from '../product';

export const selectProductState = createFeatureSelector<ProductState>('products');
export const selectProducts = createSelector(
    selectProductState,
    (state) => state.products
);
export const selectProductLoading = createSelector(
    selectProductState,
    (state) => state.loading
);
export const selectProductById = (id: number) => createSelector(
    selectProducts, (product) =>
    product.find(p => p.id === id)
);