interface Task {
    titulo: string;
    descricao: string;
    concluido: boolean;
    dataCriacao: Date;
    dataConclusao: Date | null;
  }
  
  export class TaskService {
    async getTasks(): Promise<Task[]> {
      const response = await fetch('/api/tarefas');
      if (!response.ok) throw new Error('Erro ao buscar tarefas');
      return response.json();
    }
  
    async createTask(task: Task): Promise<void> {
      const response = await fetch('/api/tarefas', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(task),
      });
      if (!response.ok) throw new Error('Erro ao criar tarefa');
    }
  }
  