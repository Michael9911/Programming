import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl = 'http://localhost:7598/user';
  constructor( private http: HttpClient ) { }
}
