package org.lyz.test_project.test;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class ComparatorTest<T> {

    public static void main(String[] args) {

        Double[] dbs = {1.1,5.2,6.3,2.5,5.2,3.3};
        for(double i: dbs) {
            System.out.print(i+"  ");
        }
        System.out.println();
        Set<Double> treeSet = new TreeSet<>(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return (int) (o1 - o2 == 0 ? -1 : ((o2 - o1) > 0 ? 1 : -1));
            }});

        for(int i = 0; i < dbs.length; i++) {
            treeSet.add(dbs[i]);
        }
        System.out.println(treeSet);
    }
}
