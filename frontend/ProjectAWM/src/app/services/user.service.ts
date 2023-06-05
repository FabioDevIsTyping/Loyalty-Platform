import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Azienda } from '../classes/azienda';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private url: string

  constructor(private http: HttpClient) {
    this.url = 'http://localhost:8080/';
  }

  public findAllAziende(): Observable<Azienda[]> {
    return this.http.get<Azienda[]>(this.url + "getAziende");
  }
}
