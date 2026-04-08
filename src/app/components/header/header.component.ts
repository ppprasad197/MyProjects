import { Component } from '@angular/core';
import { Store } from '@ngrx/store';
import { selectCartCount } from '../../carts/selectors/cart.selectors';
import { Router, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {
  cartCount: any;

  constructor(private store: Store, private router: Router) {
    this.cartCount = this.store.select(selectCartCount);
  }

  goToCart() {
    this.router.navigate(['/cart']);
  }
}
