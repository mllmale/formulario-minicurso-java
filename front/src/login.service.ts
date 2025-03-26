interface User {
    email: string;
    password: string;
  }
  
  export class LoginService {
    async login(email: string, password: string): Promise<User | null> {
      const response = await fetch('/api/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ email, password }),
      });
      if (!response.ok) throw new Error('Falha no login');
      return response.json();
    }
  }
  