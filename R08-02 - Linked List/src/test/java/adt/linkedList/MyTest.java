package adt.linkedList;

import static org.junit.Assert.*;
import adt.linkedList.SingleLinkedListImpl;
import adt.linkedList.SingleLinkedListNode;
import org.junit.Test;

public class MyTest {

    SingleLinkedListImpl<Integer> teste = new SingleLinkedListImpl<Integer>();
    SingleLinkedListNode<Integer> node = new SingleLinkedListNode<Integer>();

    @Test
    public void test01() {
        node.setData(1);
        teste.setHead(node);
        node.setNext(new SingleLinkedListNode<Integer>(3, new SingleLinkedListNode<Integer>()));
        node.getNext().getNext().setData(4);
        node.getNext().getNext().setNext(new SingleLinkedListNode<Integer>());

        assertEquals(node.getData(), (Integer) 1);
        assertEquals(node.getNext().getData(), (Integer) 3);
        assertEquals(node.getNext().getNext().getData(), (Integer) 4);
        assertTrue(node.getNext().getNext().getNext().isNIL());
        
        teste.rotate(node, 3);

        assertEquals(teste.getHead().getData(), (Integer) 1);
    }
}
