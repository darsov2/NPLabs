package lab1.lab1_3;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

final class IntegerArray {

    private int [] arr;

    public IntegerArray(int a[])
    {
        arr = Arrays.copyOf(a, a.length);
    }

    public int length()
    {
        return arr.length;
    }

    public int getElementAt(int i)
    {
        return arr[i];
    }

    public int sum()
    {
        return Arrays.stream(arr).sum();
    }

    public double average()
    {
        return sum() / (double) arr.length;
    }

    public IntegerArray getSorted()
    {
        IntegerArray sorted = new IntegerArray(arr);
        Arrays.sort(sorted.arr);
        return sorted;
    }

    public IntegerArray concat(IntegerArray ia)
    {
        return new IntegerArray(IntStream.concat(Arrays.stream(arr), Arrays.stream(ia.arr)).toArray());
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerArray that = (IntegerArray) o;
        return Arrays.equals(arr, that.arr);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(arr);
    }
}
