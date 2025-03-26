import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GerenciarTarefasComponent } from '../tarefa/gerenciar-tarefa.component'; 
import { GerenciarUsuariosComponent } from '../user/gerenciar-user.component'; 

const routes: Routes = [
  { path: 'tarefas', component: GerenciarTarefasComponent },
  { path: 'usuarios', component: GerenciarUsuariosComponent },
  { path: '', redirectTo: '/tarefas', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
