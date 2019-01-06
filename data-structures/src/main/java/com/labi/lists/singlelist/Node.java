package com.labi.lists.singlelist;

/**
 * 单链表节点
 */
public class Node<E> {
    
    public E elementData;

    public Node<E> next;

    public Node() {}

    public Node(E e, Node<E> nextNode) {
        this.elementData = e;
        this.next = nextNode;
    }

    /**
     * @return E return the elementData
     */
    public E getElementData() {
        return elementData;
    }

    /**
     * @param elementData the elementData to set
     */
    public void setElementData(E elementData) {
        this.elementData = elementData;
    }

    /**
     * @return Node<E> return the next
     */
    public Node<E> getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(Node<E> next) {
        this.next = next;
    }

}