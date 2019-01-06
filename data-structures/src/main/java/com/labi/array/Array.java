package com.labi.array;

/**
 * 1) 数组的插入、删除、按照下标随机访问操作；
 * 2）数组中的数据是int类型的；
 *
 */
public class Array {

    // init cap
    private int DEFAULT_CAP = 10;

    private int[] data;

    private int size;

    public Array() {
        this.data = new int[DEFAULT_CAP];
    }
    
    public Array(int capacity) {
        this.DEFAULT_CAP = capacity;
        this.data = new int[capacity];
    }

    public boolean insert(int value) {
        // 判断是否需要扩容  数组空间已满
        if (this.size >= DEFAULT_CAP) {
            System.out.println("数组空间已满");
            return false;
        }
        data[size++] = value;
        return true;
    }

    public boolean insert(int index, int value) {
        // 判断是否需要扩容  数组空间已满
        if (this.size + 1 > DEFAULT_CAP) {
            System.out.println("数组空间已满");
            return false;
        }
        if (index <= 0 || index >= DEFAULT_CAP) {
            System.out.println("位置不合法");
            return false;
        }
        for (int i = size-1; i >= index-1; i--) {
            data[i + 1] = data[i];
        }
        data[index-1] = value;
        size++;
        return true;
    }

    public boolean remove(int index) {
        if (index <= 0 || index > DEFAULT_CAP) {
            return false;
        }
        for (int i = index; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        return true;
    }

    public int find(int index) {
        if (index <= 0 || index > DEFAULT_CAP) {
            return -1;
        }
        return data[index - 1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        return "";
    }

    public static void main(String[] args) {
        Array array = new Array(6);
        array.insert(1, 3);
        array.insert(2, 4);
        array.insert(2, 5);
        array.insert(3, 6);
        array.insert(2, 7);
        array.insert(1, 9);
        array.remove(3);
        array.toString();
    }

}