import { Component, OnInit } from '@angular/core';
import { UserService } from './user.service';
import { User } from './user.model';

@Component({
  selector: 'app-gerenciar-usuarios',
  templateUrl: './gerenciar-usuarios.component.html',
})
export class GerenciarUsuariosComponent implements OnInit {
  usuarios: User[] = [];

  constructor(private userService: UserService) {}

  ngOnInit(): void {
    this.listarUsuarios();
  }

  listarUsuarios(): void {
    this.userService.listarUsuarios().subscribe((usuarios) => {
      this.usuarios = usuarios;
    });
  }
}
