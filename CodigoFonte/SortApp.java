// Alunos:
//          FERNANDA DOS SANTOS BORGES - 202311140014
//          JONAS JUNIOR SILVA BRAGANÇA - 202311140011

import java.util.Scanner;
import java.util.Random;

public class SortApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Solicita ao usuário a quantidade de valores que ele deseja ordenar
            System.out.println("Escolha a quantidade de valores: 10, 100, 1000, 10000");
            int n = scanner.nextInt(); // Recebe a quantidade de valores do usuário
            
            // Solicita ao usuário o tipo de disposição dos valores (Aleatórios ou Decrescentes)
            System.out.println("Escolha a disposição dos valores: 1 - Aleatórios, 2 - Decrescentes");
            int ordem = scanner.nextInt(); // Recebe a opção de disposição do usuário
            
            // Pergunta se o usuário deseja ver o vetor de entrada antes da ordenação
            System.out.println("Deseja ver os valores do vetor de entrada? 1 - Sim, 2 - Não");
            int opcaoExibir = scanner.nextInt(); // Recebe a resposta do usuário

            // Gera o array de acordo com a quantidade e disposição escolhida
            int[] array = gerarArray(n, ordem);

            // Exibe o vetor de entrada se o usuário optar por isso
            if (opcaoExibir == 1) {
                System.out.println("Vetor de entrada: ");
                exibirArray(array); // Chama a função para exibir o array
            }

            // Cria clones do array original para que diferentes algoritmos de ordenação possam ser usados separadamente
            int[] clone1 = array.clone(); // Clone para BubbleSort
            int[] clone2 = array.clone(); // Clone para MergeSort
            int[] clone3 = array.clone(); // Clone para RadixSort

            // Solicita ao usuário que escolha qual algoritmo de ordenação deseja executar
            System.out.println("Escolha o algoritmo: 1 - BubbleSort, 2 - MergeSort, 3 - RadixSort");
            int escolha = scanner.nextInt(); // Recebe a escolha do usuário

            // Executa o algoritmo de ordenação com base na escolha do usuário
            switch (escolha) {
                case 1:
                    BubbleSort.ordenar(clone1); // Chama a função ordenar para BubbleSort
                    System.out.println("Valores depois da ordenação (BubbleSort): ");
                    exibirArray(clone1); // Exibe o array ordenado
                    break;
                case 2:
                    MergeSort.ordenar(clone2); // Chama a função ordenar para MergeSort
                    System.out.println("Valores depois da ordenação (MergeSort): ");
                    exibirArray(clone2); // Exibe o array ordenado
                    break;
                case 3:
                    RadixSort.ordenar(clone3); // Chama a função ordenar para RadixSort
                    System.out.println("Valores depois da ordenação (RadixSort): ");
                    exibirArray(clone3); // Exibe o array ordenado
                    break;
                default:
                    // Caso o usuário escolha uma opção inválida
                    System.out.println("Opção inválida");
            }
        }
    }

    // Método para gerar o array de números com base nas opções do usuário
    private static int[] gerarArray(int n, int ordem) {
        int[] array = new int[n]; // Cria um array com 'n' elementos
        Random random = new Random(); // Objeto para gerar números aleatórios

        // Gera números aleatórios se a opção escolhida for 1
        if (ordem == 1) { // Aleatórios
            for (int i = 0; i < n; i++) {
                array[i] = random.nextInt(n) + 1; // Preenche o array com valores aleatórios entre 1 e n
            }
        } 
        // Gera números em ordem decrescente se a opção escolhida for 2
        else if (ordem == 2) { // Decrescentes
            for (int i = 0; i < n; i++) {
                array[i] = n - i; // Preenche o array com valores de n até 1 (decrescente)
            }
        }
        
        return array; // Retorna o array gerado
    }

    // Método para exibir os valores do array no console
    private static void exibirArray(int[] array) {
        // Percorre cada elemento do array e exibe no console
        for (int i : array) {
            System.out.print(i + " "); // Imprime os valores separados por espaço
        }
        System.out.println(); // Quebra a linha ao final da exibição
    }
}
