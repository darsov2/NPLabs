package lab2.lab2_1;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.DoubleStream;

class MatrixReader {

    public static DoubleMatrix read(InputStream input) throws InsufficientElementsException {
        Scanner s = new Scanner(input).useLocale(Locale.US);
        int m, n;
        m = s.nextInt();
        n = s.nextInt();
        double [][]a = new double[m][n];

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                a[i][j] = s.nextDouble();
            }
        }

        return new DoubleMatrix(toArray(a, m), m, n);
    }

    public static double[] toArray(double a[][], int m)
    {
        double arr[] = {};
        for(int i = 0; i < m; i++)
        {
            arr = DoubleStream.concat(Arrays.stream(arr), Arrays.stream(a[i])).toArray();
        }

        return arr;
    }
}
