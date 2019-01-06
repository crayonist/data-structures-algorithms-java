package com.labi.array;

public class GenericArray<T> {
    
    private T[] data;

    private int size;

    private int DEFAULT_CAP = 10;

    @SuppressWarnings("unchecked")
    public GenericArray() {
        data = (T[]) new Object[DEFAULT_CAP];
    }

    @SuppressWarnings("unchecked")
    public GenericArray(int capacity) {
        this.DEFAULT_CAP = capacity;
        data = (T[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    // 获取对应 index 位置的元素
    public T get(int index) {
        rangeCheck(index);
        return data[index];
    }

    // 修改 index 位置的元素
    public void set(int index, T e) {
        rangeCheck(index);
        data[index] = e;
    }

    // 查看数组是否包含元素e
    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    // 获取对应元素的下标, 未找到，返回 -1
    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    // 在 index 位置，插入元素e, 时间复杂度 O()
    public void add(int index, T e) {
        // 判断位置是否合法
        rangeCheckForAdd(index);
        // 判断是否需要扩容
        if (size >= this.DEFAULT_CAP) {
            grow();
        }
        for (int i = size-1; i >= index; i--) {
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    // 扩容
    @SuppressWarnings("unchecked")
    private void grow() {
        int oldCap = this.DEFAULT_CAP;
        int newCap = oldCap + (oldCap >> 1);
        T[] newData = (T[]) new Object[newCap];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        this.data = newData;
    }

    // 向数组头插入元素
    public void addFirst(T e) {
        add(0, e);
    }

    // 向数组尾加入元素
    public void addLast(T e) {
        add(size, e);
    }

    // 删除 index 位置的元素，并返回
    public void remove(int index) {
        for (int i = index+1; i < size; i++) {
            data[i-1] = data[i];
        }
        data[size-1] = null;
        size--;
    }

    // 删除第一个元素
    public void removeFirst() {
        remove(0);
    }

    // 删除末尾元素
    public void removeLast() {
        remove(size - 1);
    }

    // 从数组中删除指定元素
    public void removeElement(T e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    // 下标检查（add）
    public void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index should be required: index >=0 and index <= size");
        }
    }

    // 下标检查
    public void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index should be required: index >=0 and index < size");
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array size = %d, capacity = %d \n", size, data.length));
        builder.append('[');
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }
        builder.append(']');
        return builder.toString();
    }

    public static void main(String[] args) {
        GenericArray<Integer> array = new GenericArray<Integer>(3);
        array.add(0, 1);
        array.add(0, 2);
        array.addFirst(3);
        array.addLast(4);
        System.out.println(array.toString());
    }
}