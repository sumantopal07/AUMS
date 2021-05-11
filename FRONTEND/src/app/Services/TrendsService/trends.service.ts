import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import GraphData from 'src/app/Models/GraphData.Model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class TrendsService {
  private apiServer = environment.BaseUrl;
  constructor(private httpClient: HttpClient) {}

  public skill(): Observable<any[]> {
    return this.httpClient.get<any[]>(this.apiServer + '/skill');
  }

  public location(): Observable<any[]> {
    return this.httpClient.get<any[]>(this.apiServer + '/location');
  }

  public client(): Observable<any[]> {
    return this.httpClient.get<any[]>(this.apiServer + '/client');
  }

  public description(): Observable<any[]> {
    return this.httpClient.get<any[]>(this.apiServer + '/description');
  }
}
