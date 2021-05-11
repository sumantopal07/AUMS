import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SocialAuthService } from 'angularx-social-login';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  constructor(private router: Router, private authService: SocialAuthService) {}

  ngOnInit(): void {}
  signOut(): any {
    localStorage.removeItem('user');
    this.router.navigate(['']);
  }
  trend(): any {
    this.router.navigate(['trend']);
  }
}
