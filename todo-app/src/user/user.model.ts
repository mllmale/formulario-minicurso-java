export interface User {
    id: string;
    nome: string;
    cpf: string;
    email: string;
    usuarioId?: string; // Caso o usuário esteja relacionado com tarefas
  }
  