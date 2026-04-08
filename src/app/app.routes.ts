import { Routes } from '@angular/router';
import { ProductDetailComponent } from './products/components/product-detail/product-detail.component';
import { HomeComponent } from './components/home/home.component';
import { CartComponent } from './carts/components/cart/cart.component';

export const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'product/:id', component: ProductDetailComponent },
    { path: 'cart', component: CartComponent }
];
