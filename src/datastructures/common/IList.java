package datastructures.common;

public interface IList<T> {
    void print();
    void append(T value);
    void prepend(T value);
    boolean search(T value);
    void delete(Integer pos);
    void insert(T value, Integer pos);
    void pop_back();
    void pop_front();
    T at(int index);
}
