package com.Tarefas.to_do_list.iniciando;

class Pessoa {
    private String nome;
    private int idade;

    // Construtor
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    // Método decorado (simulando "decorator" como prefixo/sufixo)
    public String apresentar() {
        return "*** " + nome.toUpperCase() + " - " + idade + " anos ***";
    }
}

public class ExemploClasseMetodo {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Letícia", 21);

        // Usando getters
        System.out.println("Nome: " + p1.getNome());
        System.out.println("Idade: " + p1.getIdade());

        // Apresentação com "decorator"
        System.out.println(p1.apresentar());
    }
}
