import static java.lang.Math.*;

public class Roots{


    public static double[] findRoots(double[][] matrix, double[] consts, int count){
        double[] roots = new double[count];
        double sum;
        for (int k = count - 1; k > -1; k--){
            sum = consts[k];
            for (int j = k + 1; j < count; j++){
                sum -= matrix[k][j] * roots[j];
            }
            roots[k] = sum / matrix[k][k];
        }
        return roots;
    }
}
