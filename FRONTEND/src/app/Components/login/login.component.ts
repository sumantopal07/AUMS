import {
  Component,
  OnInit,
  ViewChild,
  ElementRef,
  TemplateRef,
  NgZone,
  Output,
} from '@angular/core';
import { SocialAuthService, SocialUser } from 'angularx-social-login';
import { GoogleLoginProvider } from 'angularx-social-login';
import {
  FormGroup,
  FormBuilder,
  FormControl,
  Validators,
  NgModel,
} from '@angular/forms';

import { Router } from '@angular/router';
import { LoginService } from 'src/app/Services/LoginService/login.service';
import Login from 'src/app/Models/Login.Model';
import Token from 'src/app/Models/Token.model';
import { NotificationService } from 'src/app/Services/Notification/notification.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  constructor(
    private router: Router,
    private authService: SocialAuthService,
    private loginService: LoginService,
    private notificationService: NotificationService
  ) {}

  user: SocialUser | undefined;
  req: Login;

  ngOnInit(): void {}
  async signInWithGoogle(): Promise<void> {
    await this.authService.signIn(GoogleLoginProvider.PROVIDER_ID);
    this.authService.authState.subscribe((response) => {
      this.req = { email: response.email };
      this.loginService.login(this.req).subscribe(
        (token: Token) => {
          localStorage.setItem('user', JSON.stringify(token));
          this.router.navigate(['/home']);
        },
        (error) => {
          this.notificationService.success('Permission Denied!');
        }
      );
    });
  }

  signOut(): any {
    this.authService.signOut().then(() => {
      localStorage.removeItem('user');
      this.router.navigate(['']);
    });
  }
}
