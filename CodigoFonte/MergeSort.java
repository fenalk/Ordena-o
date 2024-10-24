public class MergeSort {
    // Variáveis estáticas para contar o número de comparações e trocas realizadas durante a ordenação
    private static int comparacoes = 0;
    private static int trocas = 0;

    // Método principal de ordenação que inicia o MergeSort
    public static int[] ordenar(int[] array) {
        // Captura o tempo inicial em nanossegundos para medir o tempo de execução do MergeSort
        long tempoInicial = System.nanoTime();

        // Chama o método mergeSort para iniciar a recursão e ordenação
        // Passa o array original, um array temporário, e os índices de início e fim do array
        mergeSort(array, new int[array.length], 0, array.length - 1);

        // Captura o tempo final após a execução do algoritmo
        long tempoFinal = System.nanoTime();

        // Exibe o número de comparações, trocas e o tempo total de execução do MergeSort
        System.out.println("MergeSort - Comparações: " + comparacoes + ", Trocas: " + trocas + ", Tempo: " + (tempoFinal - tempoInicial) + " ns");

        // Retorna o array já ordenado
        return array;
    }

    // Método recursivo que divide o array em duas partes e depois mescla-as ordenadamente
    private static void mergeSort(int[] array, int[] temporario, int inicioEsquerdo, int fimDireito) {
        // Caso base: se o índice do lado esquerdo for maior ou igual ao direito, não há mais divisão, então retorna
        if (inicioEsquerdo >= fimDireito) {
            return;
        }

        // Calcula o índice do meio para dividir o array em duas partes
        int meio = (inicioEsquerdo + fimDireito) / 2;

        // Chamada recursiva para ordenar a metade esquerda do array
        mergeSort(array, temporario, inicioEsquerdo, meio);

        // Chamada recursiva para ordenar a metade direita do array
        mergeSort(array, temporario, meio + 1, fimDireito);

        // Após ordenar as duas metades, chama o método para mesclá-las em ordem
        mesclarMetades(array, temporario, inicioEsquerdo, fimDireito);
    }

    // Método para mesclar duas metades do array de forma ordenada
    private static void mesclarMetades(int[] array, int[] temporario, int inicioEsquerdo, int fimDireito) {
        // Calcula o índice do fim da metade esquerda
        int fimEsquerdo = (fimDireito + inicioEsquerdo) / 2;
        // Calcula o início da metade direita
        int inicioDireito = fimEsquerdo + 1;
        // Calcula o tamanho total da seção que está sendo mesclada
        int tamanho = fimDireito - inicioEsquerdo + 1;

        // Índices que irão percorrer as duas metades (esquerda e direita)
        int esquerdo = inicioEsquerdo;
        int direito = inicioDireito;
        int indice = inicioEsquerdo;

        // Enquanto houver elementos em ambas as metades (esquerda e direita)
        while (esquerdo <= fimEsquerdo && direito <= fimDireito) {
            comparacoes++; // Conta as comparações realizadas entre os elementos

            // Verifica se o elemento da metade esquerda é menor ou igual ao da metade direita
            if (array[esquerdo] <= array[direito]) {
                // Se for, o elemento da esquerda é colocado na posição atual do array temporário
                temporario[indice] = array[esquerdo];
                esquerdo++; // Avança o índice da metade esquerda
            } else {
                // Caso contrário, coloca o elemento da metade direita no array temporário
                temporario[indice] = array[direito];
                direito++; // Avança o índice da metade direita
                trocas++; // Conta a troca realizada, já que os elementos foram movidos
            }
            indice++; // Avança o índice do array temporário
        }

        // Copia os elementos restantes da metade esquerda, se houver
        System.arraycopy(array, esquerdo, temporario, indice, fimEsquerdo - esquerdo + 1);
        // Copia os elementos restantes da metade direita, se houver
        System.arraycopy(array, direito, temporario, indice, fimDireito - direito + 1);

        // Copia os elementos do array temporário de volta para o array original
        System.arraycopy(temporario, inicioEsquerdo, array, inicioEsquerdo, tamanho);
    }
}
