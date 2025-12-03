package lab6;
import java.util.Collection;

/**
 * Типізована колекція Set, реалізована через двозв’язний список.
 * @param <E> тип об'єктів у колекції
 */
public class LinkedSet<E> implements MySet<E> {

    /**
     * Внутрішній елемент двозв’язного списку.
     */
    private class Node {
        E value;
        Node next;
        Node prev;

        Node(E value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size = 0;

    /** ----------------------- КОНСТРУКТОРИ ----------------------- */

    /** Порожній конструктор */
    public LinkedSet() {}

    /**
     * Конструктор, що приймає один елемент.
     * @param element елемент для вставки
     */
    public LinkedSet(E element) {
        add(element);
    }

    /**
     * Конструктор, що приймає стандартну колекцію.
     * @param collection колекція елементів
     */
    public LinkedSet(Collection<E> collection) {
        for (E elem : collection) {
            add(elem);
        }
    }

    /** ----------------------- РЕАЛІЗАЦІЯ МЕТОДІВ SET ----------------------- */

    /**
     * Додає елемент у множину, якщо його ще немає.
     * @return true — якщо елемент додано, false — якщо вже існує
     */
    @Override
    public boolean add(E element) {
        if (element == null) {
            throw new NullPointerException("Element cannot be null.");
        }

        if (contains(element)) {
            return false;
        }

        Node newNode = new Node(element);

        if (head == null) { // перший елемент
            head = tail = newNode;
        } else {  // додаємо у кінець
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        size++;
        return true;
    }

    @Override
    public boolean remove(E element) {
        Node current = head;

        while (current != null) {
            if (current.value.equals(element)) {

                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next; // видалення голови
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev; // видалення хвоста
                }

                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean contains(E element) {
        Node current = head;

        while (current != null) {
            if (current.value.equals(element)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    /** Друк елементів множини */
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
}

