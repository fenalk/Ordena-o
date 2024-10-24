public class BubbleSort {
    
    // Método para ordenar um array usando o algoritmo Bubble Sort
    public static int[] ordenar(int[] array) {
        int n = array.length; // Obtém o tamanho do array
        int temporario; // Variável temporária usada para a troca de elementos
        int comparacoes = 0; // Contador para o número de comparações
        int trocas = 0; // Contador para o número de trocas realizadas

        // Captura o tempo inicial em nanossegundos, para medir a duração do algoritmo
        long tempoInicial = System.nanoTime();

        // Loop externo para controlar o número de passagens pelo array
        for (int i = 0; i < n; i++) {
            
            // Loop interno para comparar os elementos adjacentes
            for (int j = 1; j < (n - i); j++) {
                comparacoes++; // Incrementa o número de comparações a cada iteração
                
                // Verifica se o elemento anterior é maior que o próximo
                if (array[j - 1] > array[j]) {
                    trocas++; // Incrementa o contador de trocas, pois será realizada uma troca

                    // Troca os elementos se eles estiverem fora de ordem
                    temporario = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temporario;
                }
            }
        }

        // Captura o tempo final após a execução do algoritmo
        long tempoFinal = System.nanoTime();

        // Exibe o número de comparações, trocas e o tempo total de execução
        System.out.println("BubbleSort - Comparações: " + comparacoes + ", Trocas: " + trocas + ", Tempo: " + (tempoFinal - tempoInicial) + " ns");

        // Retorna o array ordenado
        return array;
    }
}
