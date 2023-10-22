package problems;

import adt.linkedList.SingleLinkedListNode;

public class LinkedListRemoveDuplicatesImpl<T> implements LinkedListRemoveDuplicates<T> {

    /**
     * Restricoes extras:
     * - Você NÃO pode usar recursão
     * - Você pode criar métodos auxiliares se achar necessário, desde que sejam
     * criados
     * nesta classe
     */
    public void removeDuplicates(SingleLinkedListNode<T> node) {
        SingleLinkedListNode<T> atual = node;
        while (!atual.isNIL()) {
            SingleLinkedListNode<T> aux = atual;
            while (!aux.isNIL()) {
                if (atual.getData().equals(aux.getNext().getData())) {
                    aux.setNext(aux.getNext().getNext());
                } else {
                    aux = aux.getNext();
                }
            }
            atual = atual.getNext();
        }
    }

    public void rotate(SingleLinkedListNode<T> node, int k) {

        SingleLinkedListNode<T> last = head;
        
    }
}
