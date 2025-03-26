import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './user.model'; 

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private apiUrl = 'http://localhost:8080/usuarios'; // Substitua pelo seu URL de API

  constructor(private http: HttpClient) {}

  // Método para criar um novo usuário
  criarUsuario(user: User): Observable<User> {
    return this.http.post<User>(this.apiUrl, user);
  }

  // Método para listar os usuários
  listarUsuarios(): Observable<User[]> {
    return this.http.get<User[]>(this.apiUrl);
  }
}
