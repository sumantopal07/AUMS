import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HTTP_INTERCEPTORS,
  HttpResponse,
  HttpErrorResponse,
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { Router } from '@angular/router';
import { NotificationService } from '../Services/Notification/notification.service';

@Injectable()
export class InterceptorInterceptor implements HttpInterceptor {
  constructor(private router: Router,private notification: NotificationService) {}
  intercept(
    request: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    const re = '/login';
    if (request.url.search(re) === -1) {
      const token = JSON.parse(localStorage.getItem('user')).accessToken;
      request = request.clone({
        setHeaders: {
          Authorization: `Bearer ${token}`
        },
      });
    }
    return next.handle(request).pipe(
      tap(
        () => {},
        (err: any) => {
          if (err instanceof HttpErrorResponse) {
            if (err.status >= 400 && err.status <= 599) {
              this.router.navigate(['']);
              this.notification.success(
                'Permision Denied'
              );
            }
            return;
          }
        }
      )
    );
  }
}
export const interceptors = [
  { provide: HTTP_INTERCEPTORS, useClass: InterceptorInterceptor, multi: true },
];
