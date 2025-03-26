import { Component, OnInit } from '@angular/core';
import { TarefaService } from './tarefa.service';
import { Tarefa } from './tarefa.model';

@Component({
  selector: 'app-gerenciar-tarefas',
  templateUrl: './gerenciar-tarefas.component.html',
})
export class GerenciarTarefasComponent implements OnInit {
  tarefas: Tarefa[] = [];

  constructor(private tarefaService: TarefaService) {}

  ngOnInit(): void {
    this.listarTarefas();
  }

  listarTarefas(): void {
    this.tarefaService.listarTarefas().subscribe((tarefas) => {
      this.tarefas = tarefas;
    });
  }

  excluirTarefa(id: string): void {
    this.tarefaService.deletarTarefa(id).subscribe(() => {
      this.listarTarefas();
    });
  }
}
