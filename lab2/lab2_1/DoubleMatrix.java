package lab2.lab2_1;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

final class DoubleMatrix {
    double a[][];
    int m, n;

    public DoubleMatrix(double[] a, int m, int n) throws InsufficientElementsException
    {
        if(a.length < m * n)
        {
            throw new InsufficientElementsException("Insufficient number of elements");
        }

        this.a = new double[m][n];

        if(a.length > m * n)
        {
            for(int i = a.length - m * n, j = 0; i < a.length && j < m; j++)
            {
                for(int k = 0; k < n; k++, i++)
                {
                    this.a[j][k] = a[i];
                }
            }
        }
        else
        {
            for(int i = 0, j = 0; i < a.length && j < m; j++)
            {
                for(int k = 0; k < n; k++, i++)
                {
                    this.a[j][k] = a[i];
                }
            }
        }


        this.m = m;
        this.n = n;
    }

    public String getDimensions()
    {
        return "[" + m + " x " + n + "]";
    }

    public int rows()
    {
        return m;
    }

    public int columns()
    {
        return n;
    }

    public double maxElementAtRow(int row) throws InvalidRowNumberException
    {
        if(row > m || row < 1)
        {
            throw new InvalidRowNumberException("Invalid row number");
        }

        return Arrays.stream(a[m - 1]).max().getAsDouble();
    }

    public double maxElementAtColumn(int column) throws InvalidColumnNumberException
    {
        if(column > n || column < 1)
        {
            throw new InvalidColumnNumberException("Invalid column number");
        }

        double max = a[0][column - 1];

        for(int i = 1; i < m; i++)
        {
            if(a[i][column - 1] > max)
            {
                max = a[i][column - 1];
            }
        }

        return max;
    }

    public double sum()
    {
        return Arrays.stream(MatrixReader.toArray(a, m)).sum();
    }

    public double[] toSortedArray()
    {
        double merge[] = {};
        for(int i = 0; i < m; i++)
        {
            merge = DoubleStream.concat(Arrays.stream(merge), Arrays.stream(a[i])).toArray();
        }

        Arrays.sort(merge);

        for(int i = 0; i < merge.length / 2; i++)
        {
            double temp = merge[i];
            merge[i] = merge[merge.length - i - 1];
            merge[merge.length - i - 1] = temp;
        }

        return merge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoubleMatrix that = (DoubleMatrix) o;
        return Arrays.deepEquals(a, that.a);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(a);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DecimalFormat df = new DecimalFormat("0.00");

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(j == n - 1)
                {
                    sb.append(df.format(a[i][j]));
                }
                else
                {
                    sb.append(df.format(a[i][j]) + "\t");
                }
            }
            if(i < m - 1) sb.append("\n");
        }

        return sb.toString();
    }
}
