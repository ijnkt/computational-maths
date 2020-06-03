public class MainElementGauss {

    static int count;
    static double a[][];
    static double copy_a[][];
    static double b[];
    static String inputFrom;
    static short changingWay;
    static String random;
    static boolean console_input = true;

    public static double[] findRoots(int countOfEq, double[][] W, double[] F) {
        count = countOfEq;
        a = W;
        b = F;
        copy_a = a;

        int[] indexes = new int[count];
        for (int s = 0; s < count; s++) indexes[s] = s;
        Changing.changeColumn(a, b, count);
        if (findDeterminant(a, count) == 0) {
            System.out.println("Метод неприменим, так как определитель исходной матрицы равен 0.");
            System.exit(0);
        }
        double[] returnedRoots = new double[count];
        double[] roots = Roots.findRoots(a, b, count);
        for (int z = 0; z < count; z++){
            for (int root_index = 0; root_index < count; root_index++) {
                if (z == indexes[root_index]) {
                    returnedRoots[z] = roots[root_index];
                }
            }
        }
        return returnedRoots;
    }

    public static double findDeterminant(double[][] a, int count){
        double determinant = 1;
        for (int l = 0; l < count; l++){
            determinant *= a[l][l];
        }
        return determinant;
    }

}







