import java.util.Random;

public class Program{
    //вычисление одного элемента матрицы
    public static double Calculterr(short pII, double x) {
        if (pII == 1) {
            double vnutr = Math.pow((x - 0.5) / 29.0, 2);
            return Math.asin(Math.cos(Math.asin(vnutr)));
        } else if (pII == 3 || pII == 5 || pII == 13
                || pII == 15 || pII == 17 || pII == 19) {
            double vnutr = Math.exp(x) * (Math.pow(x, 2.0 / 3.0 * x) - 1.0);
            return Math.atan(Math.cos(Math.pow(vnutr, 2)));
        } else {
            return Math.asin(Math.pow(Math.pow(Math.sin(x), 2), 2));
        }
    }
    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.printf("%10.4f ", value); // 4 знака после запятой
            }
            System.out.println(); // перевод строки после каждой строки матрицы
        }
    }
    public static void main(String[] args) {
        // Массив p типа short: нечётные числа от 1 до 25
        short[] p = new short[13]; // 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25
        for (int i = 0; i < p.length; i++) {
            p[i] = (short) (2 * i + 1);
        }
        // Массив x типа float: 15 случайных чисел из [-15.0; 14.0]
        float[] x = new float[15];
        Random random = new Random();
        for (int i = 0; i < x.length; i++) {
            x[i] = -15.0f + random.nextFloat() * 29.0f;
        }
        //Матрица u размером 13x15
        double[][] u = new double[p.length][x.length]; // строки — по p, столбцы — по x
        for (int i = 0; i < u.length; i++) {
            for (int j = 0; j < u[i].length; j++) {
                // в формуле x = x[j], условие выбирается по p[i]
                u[i][j] = Calculterr(p[i], x[j]);
            }
        }
        // Печать результата
        printMatrix(u);
    }
}
