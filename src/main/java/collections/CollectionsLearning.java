package collections;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CollectionsLearning<E> implements List<E> {

    public boolean equals(Object o) {
        if (o instanceof List<?>) {
            Iterator<?> it1 = iterator();
            Iterator<?> it2 = ((List<?>)o).iterator();
            while (it1.hasNext() && it2.hasNext()) {
                Object e1 = it1.next();
                Object e2 = it2.next();
                if (!(e1 == null ? e2 == null : e1.equals(e2)))
                    return false;
            }
            return !it1.hasNext() && !it2.hasNext();
        } else return false;
    }

    public static <T> List<T> asList(Collection<T> c)
            throws InvalidArgumentException
    {
        if (c instanceof List<?>) {
            return (List<T>)c;
        } else throw new InvalidArgumentException(new String[]{"Argument not a list"});
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
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

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
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
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
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
}
