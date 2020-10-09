package me.Samkist.Sort;

import java.util.ArrayList;
import java.util.Arrays;

public class Sorter<T extends Comparable<T>> {
    private ArrayList<T> list;
    private String sort;

    public Sorter(ArrayList<T> list, String sort) {
        this.list = (ArrayList<T>) list.clone();
        this.sort = sort;
        sort();
    }

    public Sorter(T[] list, String sort) {
        this.list = new ArrayList<>(Arrays.asList(list));
        this.sort = sort;
        sort();
    }

    private void sort() {
        for(int i = 0; i < list.size(); i++) {
            int min = i;
            for(int j = i +1; j < list.size(); j++) {
                if(sort.equalsIgnoreCase("gpa"))
                    if(list.get(j).compareTo(list.get(min)) < 0)
                        min = j;
                if(sort.equalsIgnoreCase("id"))
                    if(list.get(j).toString().compareTo(list.get(min).toString()) < 0)
                        min = j;

            }
            if(min != i) {
                T a = list.get(min);
                T b = list.get(i);
                list.set(min, b);
                list.set(i, a);
            }
            
        }
    }

    public ArrayList<T> get() {
        return list;
    }
}