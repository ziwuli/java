package com.ziwu.datastructure;

import java.util.*;

public class LinkedList<E> implements List<E>, Deque<E> {
    int size = 0;

    /**
     * Pointer to first node.
     */
    Node<E> first;

    /**
     * Pointer to last node.
     */
    Node<E> last;

    @Override
    public void addFirst(E e) {
        add(0, e);
    }

    @Override
    public void addLast(E e) {

    }

    @Override
    public boolean offerFirst(E e) {
        return false;
    }

    @Override
    public boolean offerLast(E e) {
        return false;
    }

    @Override
    public E removeFirst() {
        return null;
    }

    @Override
    public E removeLast() {
        return null;
    }

    @Override
    public E pollFirst() {
        return null;
    }

    @Override
    public E pollLast() {
        return null;
    }

    @Override
    public E getFirst() {
        return null;
    }

    @Override
    public E getLast() {
        return null;
    }

    @Override
    public E peekFirst() {
        return null;
    }

    @Override
    public E peekLast() {
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean offer(E e) {
        add(e);
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        return remove(0);
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return get(0);
    }

    @Override
    public void push(E e) {
        add(e);
    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public Iterator<E> descendingIterator() {
        return null;
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
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    /**
     * add in last
     *
     * @param e
     * @return
     */
    @Override
    public boolean add(E e) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(e, null, l);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.element == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.element)) {
                    unlink(x);
                    return true;
                }
            }
        }

        return false;
    }

    private E unlink(Node<E> x) {
        E element = x.element;
        Node<E> prev = x.pre;
        Node<E> next = x.next;
        //删除的是第一个元素
        if (prev == null) {
            first = next;
        } else {
            //设置后驱
            prev.next = next;
        }
        //删除的是最后一个元素
        if (next == null) {
            last = prev;
        } else {
            //设置前驱
            next.pre = prev;
        }
        size--;
        return element;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        return getNode(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = getNode(index);
        E oldVar = node.element;
        node.element = element;
        return oldVar;
    }

    @Override
    public void add(int index, E element) {
        isPositionIndex(index);
        Node<E> x = getNode(index);
        if (x == null) {
            add(element);
            return;
        }
        Node<E> prev = x.pre;
        Node<E> next = x.next;
        Node<E> newNode = new Node<>(element, x, prev);
        if (prev == null) {
            first = newNode;
        } else {
            prev.next = newNode;
        }
        x.pre = newNode;
        size++;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    @Override
    public E remove(int index) {
        Objects.checkIndex(index, size);
        int i = 0;
        for (Node<E> x = first; x != null; x = x.next) {
            if (index == i) {
                unlink(x);
                return x.element;
            }
            i++;
        }
        return null;
    }

    Node<E> getNode(int index) {
        isPositionIndex(index);
        int i = 0;
        for (Node<E> x = first; x != null; x = x.next) {
            if (index == i) {
                return x;
            }
            i++;
        }
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Node<E> x = first; x != null; x = x.next) {
            sb.append(x.element).append(",");
        }
        sb.setLength(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    private class Node<E> {
        private E element;
        private Node<E> next;
        private Node<E> pre;

        public Node(E element, Node<E> next, Node<E> pre) {
            this.element = element;
            this.next = next;
            this.pre = pre;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPre() {
            return pre;
        }

        public void setPre(Node pre) {
            this.pre = pre;
        }
    }
}
