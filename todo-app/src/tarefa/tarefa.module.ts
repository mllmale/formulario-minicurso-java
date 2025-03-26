// src/tarefa/tarefa.module.ts
import { CommonModule } from '@angular/common';  // Importe o CommonModule
import { NgModule } from '@angular/core';
import { GerenciarTarefasComponent } from './gerenciar-tarefa.component'; 

@NgModule({
  declarations: [GerenciarTarefasComponent],
  imports: [CommonModule],  // Adicione o CommonModule aqui
  exports: [GerenciarTarefasComponent]
})
export class TarefaModule {}
