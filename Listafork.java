class Node {
    Integer value;
    Node next;
    Node fork;   

    Node(Integer value) {
        this.value = value;
        this.next = null;
        this.fork = null; // inicializamos el fork en null
    }
}

class LinkedList {

    private Node head;

    public void insertAtHead(Integer value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public void LinkedListInsertAfter(Node previous, Node newNode) {
        newNode.next = previous.next;
        previous.next = newNode;
    }

    public Node LinkedListLookUp(int elementNumber) {
        Node current = head;
        int count = 0;

        while (count < elementNumber && current != null) {
            current = current.next;
            count = count + 1;
        }

        return current;
    }

    // Asignar un fork a un nodo
    public void LinkedListAddFork(Node base, Node forkNode) {
        if (base != null) {
            base.fork = forkNode;
        }
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value);

            // si hay fork, lo mostramos
            if (current.fork != null) {
                System.out.print("->[FORK:" + current.fork.value + "]");
            }

            System.out.print("->");
            current = current.next;
        }
        System.out.print("/\n");
    }
}

public class LinkedListDemo {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtHead(50);
        list.insertAtHead(40);
        list.insertAtHead(30);
        list.insertAtHead(20);
        list.insertAtHead(10);

        // imprime lista normal
        list.printList();

        // buscamos el nodo en la posición 2 (30)
        Node base = list.LinkedListLookUp(2);

        // creamos un nuevo nodo como fork
        Node forkNode = new Node(99);

        // añadimos el fork al nodo base
        list.LinkedListAddFork(base, forkNode);

        // imprimimos de nuevo, ahora con el fork
        list.printList();
    }
}
