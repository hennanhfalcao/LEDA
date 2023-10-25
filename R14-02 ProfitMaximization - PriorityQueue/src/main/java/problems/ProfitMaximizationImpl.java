package problems;

import java.util.PriorityQueue;

public class ProfitMaximizationImpl implements ProfitMaximization {

    /**
     * Implementacao de heap sobrejacente. PriorityQueue é uma min-heap que
     * pode trabalhar com um comparator interno e permite elementos duplicados
     *
     * O método poll() é semelhante a extrair o root da PriorityQueue
     * O método add(elem) insere in elemento na heap
     */
    private PriorityQueue<Integer> heap;

    // comparator invertido para que a priorityqueue funcione como max-heap
    public ProfitMaximizationImpl(PriorityQueue<Integer> heap) {
        this.heap = new PriorityQueue<Integer>((o1, o2) -> (o2 - o1));
    }

    public int maximize(Integer[] array, int amount) {
        int acumulado = 0;
        int venda = 0;
        // preenche a priority queue
        for (int i = 0; i < array.length; i++) {
            this.heap.add(array[i]);
        }
        // o laço roda enquanto a quantidade de vendas for menor que a quantidade
        // estipulada
        while (venda < amount) {
            // preço da venda atual
            int preco = this.heap.poll();
            // acumula o valor vendido
            acumulado += preco;
            // adiciona o valor do preço decrementado de 1 na heap
            this.heap.add(--preco);
            // incrementa a quantidade de vendas
            venda++;
        }
        return acumulado;
    }
}
