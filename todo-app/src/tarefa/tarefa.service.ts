import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Tarefa } from './tarefa.model';

@Injectable({
  providedIn: 'root',
})
export class TarefaService {
  private apiUrl = 'http://localhost:8080/tarefas'; // Substitua pelo seu URL de API

  constructor(private http: HttpClient) {}

  // Método para criar uma nova tarefa
  criarTarefa(tarefa: Tarefa): Observable<Tarefa> {
    return this.http.post<Tarefa>(this.apiUrl, tarefa);
  }

  // Método para listar as tarefas
  listarTarefas(): Observable<Tarefa[]> {
    return this.http.get<Tarefa[]>(this.apiUrl);
  }

  // Método para deletar tarefa por ID
  deletarTarefa(id: string): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
