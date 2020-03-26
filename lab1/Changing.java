import static java.lang.Math.*;

public class Changing{

    public static void changeColumn(double[][] matrix, double[] consts, int count) {

        for (int j = 0; j < count; j++) {
            double maxelement = matrix[j][j];

            for (int i = j; i < count; i++) {
                if (abs(matrix[i][j]) > abs(maxelement)) {
                    maxelement = matrix[i][j];
                    double copy_matrix_el;
                    double copy_const;
                    copy_const = consts[i];
                    consts[i] = consts[j];
                    consts[j] = copy_const;
                    for (int el = 0; el < count; el++) {
                        copy_matrix_el = matrix[i][el];
                        matrix[i][el] = matrix[j][el];
                        matrix[j][el] = copy_matrix_el;
                    }
                }
            }


            for (int ii = j + 1; ii < count; ii++) {
                if (maxelement != 0) {
                    double coef = -matrix[ii][j] / maxelement;
                    for (int jj = j; jj < count; jj++) {
                        matrix[ii][jj] += matrix[j][jj] * coef;
                    }
                    consts[ii] += consts[j] * coef;
                }
            }
        }
    }

    public static void changeRow(double[][] matrix, double[] consts, int count, int[] indexes){
        for (int i = 0; i < count; i++) {
            double maxelement = matrix[i][i];
            for (int j = i; j < count; j++) {
               if (abs(matrix[i][j]) > abs(maxelement)) {
                   maxelement = matrix[i][j];
                   int copy_index = indexes[i];
                   indexes[i] = indexes[j];
                   indexes[j] = copy_index;
                   double copy_matrix_el;
                   for (int el = 0; el < count; el++) {
                       copy_matrix_el = matrix[el][j];
                       matrix[el][j] = matrix[el][i];
                       matrix[el][i] = copy_matrix_el;
                   }
               }
            }


             for (int ii = i + 1; ii < count; ii++) {
                  if (maxelement != 0) {
                      double coef = -matrix[ii][i] / maxelement;
                      for (int jj = i; jj < count; jj++) {
                           matrix[ii][jj] += matrix[i][jj] * coef;
                      }
                      consts[ii] += consts[i] * coef;
                  }
             }
        }
    }
}
