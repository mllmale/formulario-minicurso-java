package com.Tarefas.to_do_list.iniciando;

// A classe abstrata Animal serve como uma "base genérica" para qualquer tipo de animal.
// Ela define comportamentos que os animais devem ter, como emitir som e dormir.
// A palavra-chave "abstract" indica que essa classe não pode ser instanciada diretamente,
// ou seja, não podemos criar um objeto do tipo Animal — apenas de suas subclasses.
abstract class Animal {

    // Metodo abstrato que obriga qualquer classe que herde de Animal a fornecer sua própria
    // implementação de como o som do animal será emitido (latido, miado, etc.).
    public abstract void emitirSom();

    // Metodo concreto (com implementação) que pode ser utilizado por qualquer animal.
    // Representa o comportamento comum de dormir.
    public void dormir() {
        System.out.println("Zzz...");
    }
}

// A interface Pet representa um "contrato" que define comportamentos esperados de um animal de estimação.
// Qualquer classe que implemente essa interface deve obrigatoriamente definir os métodos brincar() e alimentar().
interface Pet {

    // Metodo que deve ser implementado para mostrar como o pet brinca
    void brincar();

    // Metodo que deve ser implementado para mostrar como o pet se alimenta
    void alimentar();
}

// A classe Cachorro é uma implementação concreta (real) de um animal específico.
// Ela herda (extends) da classe Animal e implementa (implements) a interface Pet.
// Isso significa que ela deve obrigatoriamente implementar o metodo emitirSom() da classe abstrata
// e os métodos brincar() e alimentar() da interface.
class Cachorro extends Animal implements Pet {

    // Atributo privado que armazena o nome do cachorro
    private String nome;

    // Construtor da classe Cachorro. Ele é executado quando criamos um novo objeto Cachorro.
    // Ao criar um novo cachorro, passamos o nome como parâmetro.
    public Cachorro(String nome) {
        this.nome = nome;
    }

    // Implementação obrigatória do metodo abstrato emitirSom().
    // Aqui, definimos que o som emitido por um cachorro é "Au au!".
    @Override
    public void emitirSom() {
        System.out.println(nome + " diz: Au au!");
    }

    // Implementação do metodo da interface Pet que mostra o cachorro brincando.
    @Override
    public void brincar() {
        System.out.println(nome + " está brincando com a bolinha.");
    }

    // Implementação do metodo da interface Pet que mostra o cachorro se alimentando.
    @Override
    public void alimentar() {
        System.out.println(nome + " está comendo ração.");
    }
}

// A classe Main contém o metodo "main", que é o ponto de partida de qualquer programa Java.
// É aqui que a execução realmente começa.
public class Tipos {

    // Metodo principal (main): toda aplicação Java precisa de um metodo main para ser executada.
    public static void main(String[] args) {

        // Criação de um objeto do tipo Cachorro, com o nome "Bolt".
        // Isso chama o construtor da classe Cachorro.
        Cachorro dog = new Cachorro("Bolt");

        // Chamada dos métodos definidos na classe e herdados da classe abstrata e da interface.

        // O cachorro emite seu som característico (latido)
        dog.emitirSom();

        // O cachorro executa o comportamento de dormir (herdado da classe Animal)
        dog.dormir();

        // O cachorro brinca (implementação da interface Pet)
        dog.brincar();

        // O cachorro se alimenta (implementação da interface Pet)
        dog.alimentar();
    }
}
