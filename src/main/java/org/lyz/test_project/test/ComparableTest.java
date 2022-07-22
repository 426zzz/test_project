package org.lyz.test_project.test;

import java.util.Set;
import java.util.TreeSet;

public class ComparableTest implements Comparable<ComparableTest>{
    private Integer width;
    private Integer height;

    public ComparableTest() {
    }

    public ComparableTest(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "ComparableTest{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    // from big to small
    @Override
    public int compareTo(ComparableTest o) {
        // first : compare width
        if(o.width.intValue() != this.width.intValue()){
            return o.width - this.width;
        }
        // second : compare height
        if(o.height.intValue() != this.height.intValue()){
            return o.height - this.height;
        }
        // else : set o after this
        return 1;
    }

    public static void main(String[] args) {
        Set<ComparableTest> set = new TreeSet<>();
        set.add(new ComparableTest(10, 12));
        set.add(new ComparableTest(13, 9));
        set.add(new ComparableTest(10, 5));
        set.add(new ComparableTest(10, 14));
        set.add(new ComparableTest(4, 9));
        set.add(new ComparableTest(10, 12));

        for(ComparableTest c : set){
            System.out.println(c);
        }
    }
}
