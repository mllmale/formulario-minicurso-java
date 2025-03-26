import { TaskService } from './task.service'; 
import { LoginService } from './login.service'; 

const taskService = new TaskService();
const loginService = new LoginService();

const loginForm = document.getElementById('login-form') as HTMLFormElement;
const taskForm = document.getElementById('task-form') as HTMLFormElement;
const taskListUl = document.getElementById('task-list-ul') as HTMLUListElement;
const loginContainer = document.getElementById('login-container') as HTMLDivElement;
const taskContainer = document.getElementById('task-container') as HTMLDivElement;

loginForm.addEventListener('submit', async (event) => {
  event.preventDefault();

  const email = (document.getElementById('email') as HTMLInputElement).value;
  const password = (document.getElementById('password') as HTMLInputElement).value;

  try {
    const user = await loginService.login(email, password);
    if (user) {
      loginContainer.classList.add('hidden');
      taskContainer.classList.remove('hidden');
      loadTasks();
    }
  } catch (error) {
    alert('Falha no login');
  }
});

taskForm.addEventListener('submit', async (event) => {
  event.preventDefault();

  const titulo = (document.getElementById('titulo') as HTMLInputElement).value;
  const descricao = (document.getElementById('descricao') as HTMLTextAreaElement).value;
  const concluido = (document.getElementById('concluido') as HTMLInputElement).checked;

  const newTask = { titulo, descricao, concluido, dataCriacao: new Date(), dataConclusao: concluido ? new Date() : null };
  await taskService.createTask(newTask);
  loadTasks();
});

async function loadTasks() {
  const tasks = await taskService.getTasks();
  taskListUl.innerHTML = '';

  tasks.forEach((task) => {
    const li = document.createElement('li');
    li.textContent = `${task.titulo} - ${task.descricao}`;
    if (task.concluido) {
      li.classList.add('completed');
    }
    taskListUl.appendChild(li);
  });
}
