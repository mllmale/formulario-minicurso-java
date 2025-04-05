package com.Tarefas.to_do_list.iniciando;

import java.util.*; // Importa todas as classes utilitárias como ArrayList, LinkedList, etc.

public class TiposDeListas {
    public static void main(String[] args) {

        // --------------------- ArrayList ---------------------
        // ArrayList é a lista mais comum em Java.
        // Ela é baseada em array interno, e cresce dinamicamente.
        List<String> nomes = new ArrayList<>();
        nomes.add("Letícia");
        nomes.add("Carlos");
        nomes.add("Ana");

        System.out.println("ArrayList:");
        for (String nome : nomes) {
            System.out.println("- " + nome);
        }

        // --------------------- LinkedList ---------------------
        /*
         * A LinkedList é uma implementação de lista baseada em uma **estrutura encadeada**,
         * onde cada elemento (nó) aponta para o próximo.
         *
         * ➕ Vantagens:
         * - Inserções e remoções no início ou meio da lista são rápidas (O(1) em alguns casos),
         *   pois não é necessário deslocar os elementos como em um ArrayList.
         *
         * ➖ Desvantagens:
         * - Acesso por índice (ex: get(2)) é mais lento do que no ArrayList, pois a lista precisa percorrer os nós até encontrar o elemento.
         *
         * Ideal quando: você precisa **inserir ou remover elementos frequentemente**, especialmente no início da lista.
         */
        List<Integer> numeros = new LinkedList<>();
        numeros.add(10);
        numeros.add(5);
        numeros.add(20);
        numeros.add(15);

        System.out.println("\nLinkedList:");
        for (int numero : numeros) {
            System.out.println("- " + numero);
        }

// --------------------- Vector ---------------------
        /*
         * O Vector é uma implementação antiga de lista baseada em array, semelhante ao ArrayList,
         * mas com uma diferença importante: ele é **sincronizado**, ou seja,
         * seguro para uso em ambientes com múltiplas threads (concorrência).
         *
         * ➕ Vantagens:
         * - Pode ser usado com segurança em aplicações multi-threaded sem necessidade de sincronização manual.
         *
         * ➖ Desvantagens:
         * - Desempenho inferior ao ArrayList em aplicações de thread única (por causa da sincronização automática).
         * - Praticamente substituído por Collections.synchronizedList(new ArrayList<>()) e outras abordagens modernas.
         *
         * Ideal quando: você precisa de uma lista em ambientes multi-thread,
         * mas para novos projetos, geralmente é melhor usar outras coleções sincronizadas.
         */
        Vector<Double> notas = new Vector<>();
        notas.add(7.5);
        notas.add(8.0);
        notas.add(9.3);

        System.out.println("\nVector:");
        for (double nota : notas) {
            System.out.println("- Nota: " + nota);
        }

        // --------------------- Usando List como interface ---------------------
        // Podemos usar a interface List para criar listas de qualquer tipo.
        // Isso permite usar o mesmo código para várias implementações.
        List<Character> letras = new ArrayList<>();
        letras.add('A');
        letras.add('B');
        letras.add('C');

        System.out.println("\nList com caracteres:");
        for (char letra : letras) {
            System.out.println("- Letra: " + letra);
        }

        // --------------------- Ordenação de Lista ---------------------
        // Usamos Collections.sort() para ordenar listas que implementam Comparable
        System.out.println("\nLinkedList antes da ordenação: " + numeros);
        Collections.sort(numeros); // ordena os inteiros em ordem crescente
        System.out.println("LinkedList depois da ordenação: " + numeros);

        // --------------------- Outras operações úteis ---------------------
        // Verifica se contém um elemento
        if (nomes.contains("Letícia")) {
            System.out.println("\nLetícia está na lista de nomes.");
        }

        // Remove um elemento
        nomes.remove("Carlos");
        System.out.println("Nomes após remoção: " + nomes);

        // Tamanho da lista
        System.out.println("Tamanho da lista de nomes: " + nomes.size());
    }
}
