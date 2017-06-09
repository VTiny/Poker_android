package com.pk.poker.util;

import android.util.Pair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Description:
 * Author: liuxiao
 * Date: 2017/6/9
 */

public class PairList<F, S> {

    private ArrayList<Pair<F, S>> list = new ArrayList<>();

    public PairList() {
    }

    public PairList(PairList pList) {
        list = pList.getList();
    }

    public int getIndex(Pair<F, S> aPair) {
        for (int i = 0; i < list.size(); i++) {
            if (aPair.equals(list.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public Pair<F, S> get(int index) {
        return list.get(index);
    }

    @SuppressWarnings("unchecked")
    public Pair set(int index, Pair<F, S> aPair) {
        return list.set(index, aPair);
    }

    public boolean add(F f, S s) {
        Pair<F, S> aPair = new Pair<F, S>(f, s);
        return list.add(aPair);
    }

    @SuppressWarnings("unchecked")
    public boolean add(Pair aPair) {
        return list.add((Pair<F, S>) aPair);
    }

    public void add(int index, Pair aPair) {
        list.add(index, aPair);
    }

    public boolean addAll(Collection<? extends Pair<F, S>> aCollection) {
        return list.addAll(aCollection);
    }

    public boolean addAll(int index, Collection<? extends Pair<F, S>> aCollection) {
        return list.addAll(index, aCollection);
    }

    public void clear() {
        list = new ArrayList<>();
    }

    public boolean contains(Object o) {
        Pair aPair = (Pair) o;
        for (int i = 0; i < list.size(); i++) {
            if (aPair.equals(list.get(i))) {
                return true;
            }
        }
        return false;
    }

    public void ensureCapacity(int minCapacity) {
        list.ensureCapacity(minCapacity);
    }

    public boolean isEmpty() {
        if (list.size() == 0) {
            return true;
        }
        return false;
    }

    public Iterator<Pair<F, S>> iterator() {
        return list.iterator();
    }

    public ListIterator<Pair<F, S>> listIterator() {
        return list.listIterator();
    }

    public ListIterator<Pair<F, S>> listIterator(int index) {
        return list.listIterator(index);
    }

    public Pair remove(Pair<F, S> aPair) {
        for (int i = 0; i < list.size(); i++) {
            if (aPair.equals(list.get(i))) {
                return list.remove(i);
            }
        }
        return null;
    }

    public Pair remove(int index) {
        return list.remove(index);
    }

    public boolean removeAll(Collection<? extends Pair<F, S>> aCollection) {
        return list.removeAll(aCollection);
    }

    public int size() {
        return list.size();
    }

    public List<Pair<F, S>> subList(int fromIndex, int toIndex) {
        return list.subList(fromIndex, toIndex);
    }

    public Object[] toArray() {
        return list.toArray();
    }

    public void trimToSize() {
        list.trimToSize();
    }

    public ArrayList<Pair<F, S>> getList() {
        return list;
    }

    public void setList(ArrayList<Pair<F, S>> aList) {
        list = aList;
    }

    public List getFirstList() {
        List<F> firstList = new ArrayList<>(list.size());
        for (int i = 0; i < list.size(); i++) {
            firstList.add((F) (list.get(i).first));
        }
        return firstList;
    }

    public List getSecondList() {
        List<S> secondList = new ArrayList<>(list.size());
        for (int i = 0; i < list.size(); i++) {
            secondList.add((S) (list.get(i).second));
        }
        return secondList;
    }

    public String toString() {
        String completeString = "";
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                completeString = completeString + list.get(i).toString();
            } else {
                completeString = completeString + list.get(i).toString() + ", ";
            }
        }
        return completeString;
    }
}