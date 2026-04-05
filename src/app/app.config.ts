import { ApplicationConfig, provideZoneChangeDetection, isDevMode } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideStore } from '@ngrx/store';
import { provideEffects } from '@ngrx/effects';
import { provideStoreDevtools } from '@ngrx/store-devtools';
import { productReducer } from './products/reducers/product.reducer';
import { ProductEffects } from './products/effects/product.effects';
import { cartReducer } from './carts/reducers/cart.reducer';

export const appConfig: ApplicationConfig = {
  providers: [provideZoneChangeDetection({ eventCoalescing: true }),
  provideRouter(routes),
  provideStore({ products: productReducer, cart: cartReducer }),
  provideEffects([ProductEffects]),
  provideStoreDevtools({ maxAge: 25 })]
};
