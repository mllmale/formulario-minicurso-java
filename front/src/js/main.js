const API_URL = 'http://localhost:8081/api/usuarios';

export function sendData(dados) {
    return {
        url: API_URL, // URL correta para cadastrar (POST)
        options: {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(dados)
        }
    };
}

export function findAll() {
    return {
        url: API_URL,
        options: {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        }
    };
}

export function deleteByCpf(cpf) {
    return {
        url: `${API_URL}/cpf/${cpf}`,
        options: {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json'
            }
        }
    };
}

export function findByCpf(cpf) {
    return {
        url: `${API_URL}/cpf/${cpf}`, // URL correta para buscar por CPF (GET)
        options: {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        }
    };
}

export function PreenhcerEndereco(cep) {
    return {
        url: `${API_URL}/${cep}`, // URL correta para buscar por CPF (GET)
        options: {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        }
    };
}