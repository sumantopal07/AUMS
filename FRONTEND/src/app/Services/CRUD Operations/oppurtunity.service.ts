import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {
  FormArray,
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import OppModel from '../../Models/OppModel.model';

@Injectable({
  providedIn: 'root',
})
export class OppurtunityService {
  constructor(private http: HttpClient, private fb: FormBuilder) {}
  private apiServerUrl = environment.BaseUrl;

  private id: number;
  private formBuilder: any;

  public form: FormGroup = new FormGroup({
    id: new FormControl(null),
    email: new FormControl(null),
    client: new FormControl('', Validators.required),
    date: new FormControl('', Validators.required),
    demand: new FormControl('',  [Validators.min(0)]),
    description: new FormControl('', Validators.required),
    minExp: new FormControl('', [Validators.min(0)]),
    location: new FormControl('', Validators.required),
    skill: new FormControl('', Validators.required),
  });

  public addOpps(opp: OppModel): Observable<OppModel>{
    return this.http.post<OppModel>(`${this.apiServerUrl}/addOppurtunity`, opp);
  }


  public updateOpps(opp: OppModel): Observable<OppModel>{
    return this.http.put<OppModel>(`${this.apiServerUrl}/updateOppurtunity`, opp);
  }

  public getOpps(): Observable<OppModel[]> {
    return this.http.get<OppModel[]>(`${this.apiServerUrl}/getOppurtunities`);
  }

  public deleteOpps(oppId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/delete/${oppId}`);
  }

  setId = (opp: OppModel): void => {
    this.id = opp.oppId;
  }

  getId = (): number => this.id;
  getForm = (): FormGroup => this.form;

  initializeFormGroup(): void {
    this.form.setValue({
      id: null,
      email : JSON.parse(localStorage.getItem('user')).email,
      client: null,
      date: null,
      demand: null,
      description: null,
      minExp: null,
      location: null,
      skill: null,
    });
  }
  populateForm(opp: OppModel, id: number): void {
    this.form.setValue({
      id: opp.oppId,
      email : JSON.parse(localStorage.getItem('user')).email,
      client: opp.client,
      date: opp.date,
      demand: opp.demand,
      description: opp.description,
      minExp: opp.minExp,
      location: opp.location,
      skill: opp.skill,
    });
  }
  populateFormId(opp): void {
    this.id = opp.id;
  }
}
