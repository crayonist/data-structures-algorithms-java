package com.labi.lists.singlelist;

/**
 * 单链表
 * 需要一个链表节点Node，
 * 节点里面包含一个数据，一个后继指针next，也称next引用，存放下一个节点的内存地址
 */
public class SingleList<E> {
    
    private Node<E> head;
    
    private int size;

    public SingleList() {} // 如果初始化时 head = new Node();那么后续判断每一个结点就都不会为null，结点的数据和指针为null，但结点本身不为null

    public int size() {
        return size;
    }

    public boolean contains() {
        return false;
    }

    /**
     * Links e as first element.
     * @param e
     */
    public void linkFirst(E e) {
        Node<E> newNode = null;
        newNode = new Node<E>(e, head);
        head = newNode;
        size++;
    }

    /**
     * Links e as last element
     */
    public void linkLast(E e) {
        Node<E> p = head;
        while(p.next != null) {
            p = p.next;
        }
        Node<E> newNode = new Node<>(e, null);
        p.next = newNode;
        size++;
    }

    /**
     * Inserts the element at the beginning of this list.
     * @param e
     */
    public void addFirst(E e) {
        linkFirst(e);
    }

    /**
     * Appends the element to the end of this list.
     * @param e
     */
    public void addLast(E e) {
        linkLast(e);
    }

    /**
     * Appends element at the end of list
     */
    public boolean add(E e) {
        linkLast(e);
        return true;
    } 

    /**
     * Inserts the element at the specified position in this list.
     * @param e
     * @param index
     */
    public void add(E e, int index) {
        Node<E> p = head;
        // 判断下标是否合法
        checkPositionIndex(index);
        System.out.println("hello world");
        if (index == 0) {
            linkFirst(e);
            return;
        }
        int flag = 0;
        while(flag != index - 1) {
            p = p.next;
            flag++;
        }
        Node<E> newNode = new Node<E>(e, p.next);
        p.next = newNode;
        size++;
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) 
            throw new IndexOutOfBoundsException();
    }

    /**
     * check position index
     * @param index
     */
    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size; // == size的临界值：追加到最后
    }

    /**
     * print each element
     */
    public void printAll() {
        Node<E> p = head; // 头指针赋予临时变量
        while(p != null) {
            System.out.print(p.elementData + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SingleList<String> list = new SingleList<>();
        list.linkFirst("A");
        list.linkFirst("B");
        list.linkFirst("C");
        list.linkLast("D");
        list.add("E", 5);
        list.printAll();
    }
}