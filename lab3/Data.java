import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Data {

    double STEPS = 10000.0;
    double leftBound = 5.0;
    double rightBound = 40.0;
    double topBound = 5.0;
    double bottomBound = 45.0;
    static Function<Double, Double> equation;
    static boolean systems;
    static String equationStr = "y = sin(x + 0.15 * x^2)";
    static String methodName = "Метод половинного деления";
    static double a;
    static double b;
    static double precision;
    static boolean both = false;
    static double x;
    static double y;
    static int countOfPlotEqs = 2;
    static BiFunction<Double, Double, Double> equation1 = (x, y) -> (y - 0.3*Math.pow(x, 3));
    static BiFunction<Double, Double, Double> equation2 = (x, y) -> (4*Math.pow(x, 2) - y - 3.0);
    static BiFunction<Double, Double, Double> equation3 = (x, y) -> (y - Math.exp(-x));
    static BiFunction<Double, Double, Double> equation4 = (x, y) -> (Math.sin(x) - y);
    static String[] equation_s_Str = {"y - 0.3*x^3 = 0", "4*x^2 - y - 3 = 0", "y - e^(-x) = 0", "sin(x) - y = 0"};
    static String equation1Str = "y - 0.3*x^3 = 0";
    static String equation2Str = "y - e^(-x) = 0";
    static BiFunction<Double, Double, Double> der_1_x = (x, y) -> (-0.9*x*x);
    static BiFunction<Double, Double, Double> der_1_y = (x, y) -> (1.0);
    static BiFunction<Double, Double, Double> der_2_x = (x, y) -> (8.0*x);
    static BiFunction<Double, Double, Double> der_2_y = (x, y) -> (-1.0);
    static BiFunction<Double, Double, Double> der_3_x = (x, y) -> (Math.exp(-x));
    static BiFunction<Double, Double, Double> der_3_y = (x, y) -> (1.0);
    static BiFunction<Double, Double, Double> der_4_x = (x, y) -> (Math.cos(x));
    static BiFunction<Double, Double, Double> der_4_y = (x, y) -> (-1.0);
    static BiFunction<Double, Double, Double>[] system = new BiFunction[]{equation1, equation3};
    static BiFunction<Double, Double, Double>[][] JFunction = new BiFunction[][]{{der_1_x, der_1_y}, {der_3_x, der_3_y}};
    static Function<Double, Double> eqForPlot1 = (x) -> (0.3*Math.pow(x, 3));
    static Function<Double, Double> eqForPlot2 = (x) -> (4.0*Math.pow(x, 2) - 3.0);
    static Function<Double, Double> eqForPlot3 = (x) -> (Math.exp(-x));
    static Function<Double, Double> eqForPlot4 = (x) -> (Math.sin(x));
    static Function<Boolean, List<XYSeries>> makeSeries;
    static Function<Double, Double>[] equationsForPlot = new Function[]{eqForPlot1, eqForPlot3};

}
