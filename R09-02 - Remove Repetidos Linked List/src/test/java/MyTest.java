import static org.junit.Assert.*;
import org.junit.Test;
import adt.linkedList.SingleLinkedListNode;
import problems.LinkedListRemoveDuplicatesImpl;

public class MyTest {

    SingleLinkedListNode<Integer> node = new SingleLinkedListNode<>();
    LinkedListRemoveDuplicatesImpl<Integer> teste = new LinkedListRemoveDuplicatesImpl<Integer>();

    @Test
    public void test01() {
        node.setData(1);
        SingleLinkedList<Integer> proxNode = new SingleLinkedListNode<Integer>(1, new SingleLinkedListNode<>());
        node.setNext(proxNode);
        proxNode.getNext().setData(3);
        proxNode.getNext().setNext(new SingleLinkedListNode<>());

        assertEquals(node.getData(), (Integer) 1);
        assertEquals(node.getNext().getData(), (Integer) 1);
        assertEquals(node.getNext().getNext().getData(), (Integer) 3);
        assertTrue(node.getNext().getNext().getNext().isNIL());

        teste.removeDuplicates(node);
        assertEquals(node.getData(), (Integer) 1);
        assertEquals(node.getNext().getData(), (Integer) 3);

    }

}
