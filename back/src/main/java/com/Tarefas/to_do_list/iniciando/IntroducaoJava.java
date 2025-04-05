package com.Tarefas.to_do_list.iniciando;

public class IntroducaoJava {

    // Função para calcular a média de três notas
    public static double calcularMedia(double nota1, double nota2, double nota3) {
        double media = (nota1 + nota2 + nota3) / 3;
        return media;
    }

    public static void main(String[] args) {
        // Variáveis de vários tipos
        int idade = 21;
        double salario = 2500.75;
        float altura = 1.62f;
        long cpf = 12345678901L;
        char genero = 'F';
        String nome = "Letícia";
        boolean estudaJava = true;

        // Operações matemáticas
        double aumento = salario * 0.1;
        double novoSalario = salario + aumento;

        // Saída
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Altura: " + altura + "m");
        System.out.println("CPF: " + cpf);
        System.out.println("Gênero: " + genero);
        System.out.println("Salário com aumento: R$" + novoSalario);

        // Condicional
        if (estudaJava && idade >= 18) {
            System.out.println(nome + " pode aplicar para vaga de dev Java!");
        } else {
            System.out.println(nome + " ainda não está pronta.");
        }

        // Repetição
        System.out.println("\nContando de 1 a 5:");
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }

        // Usando a função para calcular média
        double nota1 = 8.5;
        double nota2 = 9.0;
        double nota3 = 7.5;
        double mediaFinal = calcularMedia(nota1, nota2, nota3);

        System.out.println("\nNotas: " + nota1 + ", " + nota2 + ", " + nota3);
        System.out.println("Média final: " + mediaFinal);

        // Condicional com resultado da função
        if (mediaFinal >= 7.0) {
            System.out.println("Aprovada! Parabéns, " + nome + "!");
        } else {
            System.out.println("Reprovada. Continue estudando, " + nome + "!");
        }
    }
}

