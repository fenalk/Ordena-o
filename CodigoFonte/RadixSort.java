public class RadixSort {
    
    // Método principal que realiza a ordenação usando o algoritmo Radix Sort
    public static int[] ordenar(int[] array) {
        // Obtém o maior valor do array para determinar o número de dígitos a serem ordenados
        int max = obterMax(array);
        int comparacoes = 0; // Contador de comparações entre os dígitos
        int trocas = 0; // Contador de trocas realizadas

        // Captura o tempo inicial em nanossegundos para medir a execução do Radix Sort
        long tempoInicial = System.nanoTime();
        
        // Loop que percorre cada dígito, começando pela unidade (exp = 1) até o dígito mais significativo
        for (int exp = 1; max / exp > 0; exp *= 10) {
            comparacoes++; // Incrementa o contador de comparações
            array = countSort(array, exp, trocas); // Chama a função countSort para ordenar com base no dígito atual
        }

        // Captura o tempo final após a execução do algoritmo
        long tempoFinal = System.nanoTime();

        // Exibe o número de comparações, trocas e o tempo total de execução do Radix Sort
        System.out.println("RadixSort - Comparações: " + comparacoes + ", Trocas: " + trocas + ", Tempo: " + (tempoFinal - tempoInicial) + " ns");

        // Retorna o array ordenado
        return array;
    }

    // Método para obter o maior valor do array, necessário para determinar o número de dígitos
    private static int obterMax(int[] array) {
        int max = array[0]; // Inicializa o maior valor como o primeiro elemento do array
        // Loop para percorrer o array e encontrar o maior número
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) { // Se o elemento atual for maior que max, atualiza max
                max = array[i];
            }
        }
        return max; // Retorna o maior número encontrado
    }

    // Método que realiza a ordenação com base em um dígito específico, usando Counting Sort
    private static int[] countSort(int[] array, int exp, int trocas) {
        int[] saida = new int[array.length]; // Array de saída onde os elementos ordenados serão armazenados
        int[] contagem = new int[10]; // Array de contagem para armazenar a frequência dos dígitos (0-9)

        // Contagem das ocorrências dos dígitos no array baseado no dígito atual (exp)
        for (int i = 0; i < array.length; i++) {
            contagem[(array[i] / exp) % 10]++; // Extrai o dígito e incrementa a contagem
        }

        // Ajusta a contagem acumulada, para determinar as posições corretas no array de saída
        for (int i = 1; i < 10; i++) {
            contagem[i] += contagem[i - 1]; // Ajusta a contagem para refletir as posições finais
        }

        // Constroi o array de saída, colocando os elementos nas posições corretas com base na contagem
        for (int i = array.length - 1; i >= 0; i--) {
            saida[contagem[(array[i] / exp) % 10] - 1] = array[i]; // Insere o valor na posição correta
            contagem[(array[i] / exp) % 10]--; // Diminui a contagem para a próxima ocorrência do dígito
            trocas++; // Incrementa o contador de trocas
        }

        // Copia os valores do array de saída de volta para o array original
        for (int i = 0; i < array.length; i++) {
            array[i] = saida[i]; // Copia o valor para o array original
        }

        return array; // Retorna o array ordenado
    }
}
