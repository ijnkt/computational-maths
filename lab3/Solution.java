import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

import static java.lang.Double.max;
import static java.lang.Math.abs;

public class Solution {

    static String res = "";
    static double res_chordus;
    static double res_halves;
    static double doubleRes;
    static double doubleResX;
    static double doubleResY;
    final static int MAX_ITERATIONS = 100000;
    static boolean hasSolution = true;
    static int iteration_halves;
    static int iteration_chordus;

    public static void solve() {
        if (!Data.systems) {
            if(!Data.both) {
                if ("Метод хорд".equals(Data.methodName)) {
                    if (Data.equation.apply(Data.a) * Data.equation.apply(Data.b) < 0) {
                        chordus();
                        hasSolution = true;
                    } else {
                        res = "Выберите другой интервал";
                        hasSolution = false;
                    }
                } else if ("Метод половинного деления".equals(Data.methodName)) {
                    if (Data.equation.apply(Data.a) * Data.equation.apply(Data.b) < 0) {
                        byHalves();
                        hasSolution = true;
                    } else {
                        res = "Выберите другой интервал";
                        hasSolution = false;
                    }
                }
            }
            else{
                if (Data.equation.apply(Data.a) * Data.equation.apply(Data.b) < 0) {
                    byHalves();
                    res_halves = doubleRes;
                    chordus();
                    res_chordus = doubleRes;
                    hasSolution = true;
                } else {
                    res = "Выберите другой интервал";
                    hasSolution = false;
                }
            }
        }
        else {
                newton();
            }
    }

    public static void byHalves(){
        double a = Data.a;
        double b = Data.b;
        double x;
        double y_x, y_a, y_b;
        double precision = Data.precision;
        if (a > b) {
            x = b;
            b = a;
            a = x;
        }
        int iteration = 1;
        while(b - a > precision && iteration < MAX_ITERATIONS) {
            x = (a + b) / 2.0;
            y_x = Data.equation.apply(x);
            y_a = Data.equation.apply(a);
            y_b = Data.equation.apply(b);
            if (y_x == 0) {
                res = "Корень на данном промежутке х = " + String.format("%.6f", x) + "\n" + iteration + " итераций.";
                doubleRes = x;
            }
            if (y_a == 0) {
                res = "Корень на данном промежутке х = " + String.format("%.6f", a) + "\n" + iteration + " итераций.";
                doubleRes = a;
            }
            if (y_b == 0) {
                res = "Корень на данном промежутке х = " + String.format("%.6f", b) + "\n" + iteration + " итераций.";
                doubleRes = b;
            }
            if (y_x * y_a < 0){
                b = x;
            }
            else if (y_x * y_b < 0) {
                a = x;
            }
            iteration++;
        }
        x = (a + b) / 2.0;
        res = "Корень на данном \nпромежутке х = " + String.format("%.6f", x) + "\n" + iteration + " итераций.";
        doubleRes = x;
        iteration_halves = 1 + iteration;
    }

    public static void chordus(){
        int iteration = 1;
        double a = Data.a;
        double b =  Data.b;
        double precision = Data.precision;
        double y_x, y_a, y_b;
        double x = a - (b - a) * Data.equation.apply(a) / (Data.equation.apply(b) - Data.equation.apply(a));
        while(abs(Data.equation.apply(x)) > precision && iteration < MAX_ITERATIONS) {
            x = a - (b - a) * Data.equation.apply(a) / (Data.equation.apply(b) - Data.equation.apply(a));
            y_x = Data.equation.apply(x);
            y_a = Data.equation.apply(a);
            y_b = Data.equation.apply(b);
            if (y_x == 0) {
                res = "Корень на данном промежутке х = " + String.format("%.6f", x) + "\n" + iteration + " итераций.";
                doubleRes = x;
            }
            if (y_x * y_a < 0){
                b = x;
            }
            else if (y_x * y_b < 0) {
                a = x;
            }
            iteration++;
        }
        x = a - (b - a) * Data.equation.apply(a) / (Data.equation.apply(b) - Data.equation.apply(a));
        res = "Корень на данном \nпромежутке х = " + String.format("%.6f", x) + "\n" + iteration + " итераций.";
        doubleRes = x;
        iteration_chordus = iteration;
    }

    public static void newton(){
        int iteration = 1;
        double cur_x;
        double prev_x;
        double x = Data.x;
        double y = Data.y;
        double precision = 10;
        double newX, newY;
        while (precision > Data.precision && iteration <= MAX_ITERATIONS) {
            double[][] J = new double[][]{
                    {Data.JFunction[0][0].apply(x, y), Data.JFunction[0][1].apply(x, y)},
                    {Data.JFunction[1][0].apply(x, y), Data.JFunction[1][1].apply(x, y)}
            };
            double[] F = new double[]{
                    -Data.system[0].apply(x, y),
                    -Data.system[1].apply(x, y)
            };
            double[] changes = MainElementGauss.findRoots(2, J, F);
            newX = x + changes[0];
            newY = y + changes[1];
            AtomicReference<Double> new_precision = new AtomicReference<>(-1.0);
            Arrays.asList(
                    abs(changes[0]),
                    abs(changes[1]),
                    abs(Data.system[0].apply(x, y)),
                    abs(Data.system[1].apply(x, y))
            ).forEach(elem -> {
                if (!Double.isNaN(elem) && Double.isFinite(elem))
                    new_precision.set(max(new_precision.get(), elem));
            });
            precision = new_precision.get();
            x = newX;
            y = newY;
            iteration += 1;
        }
        if (Double.isNaN(x) || Double.isNaN(y) || !Double.isFinite(x) || !Double.isFinite(y) || (abs(Data.system[0].apply(x, y)) > Data.precision) || (abs(Data.system[1].apply(x, y)) > Data.precision)) {
            res = "Корень не найден";
            hasSolution = false;
        }
        else res = "Корень на данном \nпромежутке х = " + String.format("%.6f", x) + "\ny = " + String.format("%.6f", y) + "\n" + iteration + " итераций.";
        doubleResX = x;
        doubleResY = y;

    }

}


