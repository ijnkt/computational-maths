import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Math.*;
import java.util.Locale;
import java.io.File;

public class MainElementGauss {

    static short count;
    static double a[][];
    static double copy_a[][];
    static double b[];
    static String inputFrom;
    static short changingWay;
    static String random;
    static boolean console_input = true;

    public static void main(String args[]) {
        System.out.println("Чтение данных из файла или консоли? (f/c)");
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);
        inputFrom = scan.nextLine();
        while (!"f".equals(inputFrom) && !"c".equals(inputFrom)){
            System.out.println("Неверный формат ввода. Пожалуйста введите заново.");
            System.out.println("Чтение данных из файла или консоли? (f/c)");
            inputFrom = scan.nextLine();
        }

        if ("f".equals(inputFrom)) {
            console_input = false;
            System.out.println("Введите путь к файлу");
            System.out.println("(!!!)Данные в файле должны быть представлены в следующем виде: \nКоличество уравнений СЛАУ (размерность матрицы коэффициентов)  \nПострочно коэффициенты соответствующего уравнения СЛАУ и столбец свободных членов \nКак считать треугольную матрицу. 1 - по столбцу, 2 - по строке  ");
            try {
                String path = scan.nextLine();
                scan = new Scanner(new File(path)).useLocale(Locale.US);
            }
            catch(FileNotFoundException e){
                System.out.println("Файл не найден");
                System.exit(-1);
            }
        }
        if (console_input) System.out.println("Введите количество уравнений в СЛАУ. Оно должно быть целым числом.");
        count = scan.nextShort();
        while (count > 20) {
            System.out.println("Количество уравнений в СЛАУ не должно превышать 20 \nВведите, пожалуйста, число заново.");
            count = scan.nextShort();
        }

        a = new double[count][count];
        b = new double[count];

        if (console_input) {
            System.out.println('\u1048' + "спользовать случайные коэффициенты? (y/n)");
            scan = new Scanner(System.in).useLocale(Locale.US);
            random = scan.nextLine();
            while (!"y".equals(random) && !"n".equals(random)){
                System.out.println("Неверный формат данных." + '\u1048' + "спользовать случайные коэффициенты? (y/n)");
                scan = new Scanner(System.in).useLocale(Locale.US);
                random = scan.nextLine();
            }
        } else {
            random = "n";
        }
        if ("y".equals(random)) {
            for (int i = 0; i < count; i++) {
                for (int j = 0; j < count; j++) {
                    a[i][j] = round(random() * 40.0) - 20.0;
                }
                b[i] = round(random() * 40.0) - 20.0;
            }

            System.out.println("Вот сгенерированная матрица. Последний столбец в ней - столбец свободных членов.");
            for (int i = 0; i < count; i++) {
                for (int j = 0; j < count; j++) {
                    System.out.printf("%7.0f", a[i][j]);
                }
                System.out.printf("%7.0f", b[i]);
                System.out.println("\n");
            }
        }

        if ("n".equals(random)) {
            for (short i = 0; i < count; i++) {
                System.out.println("Введите " + (i + 1) + " cтроку матрицы коэффициентов (каждое число через пробел) и далее, тоже через пробел, " + (i + 1) + " строку матрицы свободных членов");
                for (short j = 0; j < count; j++) {
                    a[i][j] = scan.nextDouble();
                }
                b[i] = scan.nextDouble();
            }
        }


        double[][] a_q = new double[count][count];
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                a_q[i][j]= a[i][j];
            }

        }
        double[] b_q;
        b_q = Arrays.copyOf(b, count);

        if (console_input) System.out.println("Выбор главного элемента делать по столбцу или по строке? (1/2)");
        changingWay = scan.nextShort();
        copy_a = a;
        while (changingWay != 1 && changingWay != 2){
            System.out.println("Неверный формат данных. Выбор главного элемента делать по столбцу или по строке? (1/2)");
            changingWay = scan.nextShort();
            copy_a = a;
        }
        if (changingWay == 1) {
            Changing.changeColumn(a, b, count);
            System.out.println("Преобразованные матрицы коэффициентов и свободных членов:");
            for (int i = 0; i < count; i++) {
                for (int j = 0; j < count; j++) {
                    System.out.printf("%9.2f", a[i][j]);
                }
                System.out.printf("%9.2f", b[i]);
                System.out.println("\n");
            }
        }

        int[] indexes = new int[count];
        for (int s = 0; s < count; s++) indexes[s] = s;
        if (changingWay == 2) {
            Changing.changeRow(a, b, count, indexes);
            System.out.println("Преобразованные матрицы коэффициентов и свободных членов:");
            for (int i = 0; i < count; i++) {
                for (int j = 0; j < count; j++) {
                    System.out.printf("%9.2f", a[i][j]);
                }
                System.out.printf("%9.2f", b[i]);
                System.out.println("\n");
            }
        }

        System.out.println("Определитель матрицы равен " + findDeterminant(a, count));
        if (findDeterminant(a, count) == 0) {
            System.out.println("Метод неприменим, так как определитель исходной матрицы равен 0");
            System.exit(0);
        }
        double[] roots = Roots.findRoots(a, b, count);
        for (int z = 0; z < count; z++){
            for (int root_index = 0; root_index < count; root_index++) {
                if (z == indexes[root_index])
                    System.out.printf("x%d = %.6f\n", z + 1, roots[root_index]);
            }
        }

        System.out.println("Столбец невязок:");
        for (int i = 0; i < count; i++){
            double diff = 0;
            for (int j = 0; j < count; j++){
                for (int root_index = 0; root_index < count; root_index++) {
                    if (j == indexes[root_index]) diff += a_q[i][j] * roots[root_index];
                }
            }
            System.out.println("r" + (i + 1) + " = " + abs(diff - b_q[i]));
        }
    }

    public static double findDeterminant(double[][] a, int count){
        double determinant = 1;
        for (int l = 0; l < count; l++){
            determinant *= a[l][l];
        }
        return determinant;
    }

}








