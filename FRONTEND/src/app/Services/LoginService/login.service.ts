import { Injectable } from '@angular/core';
import Login from '../../Models/Login.Model';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import Token from '../../Models/Token.model';


@Injectable({
  providedIn: 'root'
})
export class LoginService {
  constructor(private http: HttpClient) {}
  private apiServerUrl = environment.auth;

  public login(req: Login): Observable<Token>{
    return this.http.post<Token>(`${this.apiServerUrl}/login`, req);
  }
}
