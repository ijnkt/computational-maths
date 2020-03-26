import java.util.Scanner;
import static java.lang.Math.*;
import java.util.Locale;

public class Integrate{

    public static void main(String []args){
        int function;
        double a;
        double b;
        double accuracy;
        double In = 1;
        double I2n = 2;
        double s;
        int n = 1;

        System.out.println("Выберите функцию среди следующих: \n" +
                            "1. y = x^2 \n" +
                            "2. y = sqrt(x) \n" +
                            "3. y = 1/x \n" +
                            "4. y = sin(x)");
        System.out.println("Введите номер интегрируемой функции.");
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);
        function = scan.nextInt();
        System.out.println("Задайте границы интегрирования. \nЛевая граница: ");
        a = scan.nextDouble();
        System.out.println("Правая граница:");
        b = scan.nextDouble();
        System.out.println("Введите точность:");
        accuracy = scan.nextDouble();

        double interval = abs(b - a);

        if (b < a){
            double t = a;
            a = b;
            b = t;
        }

        if (a == b) {
            System.out.println("Значение интеграла равно 0. Погрешность 0.");
            System.exit(0);
        }

        switch(function){
            case 1: do {
                        n *= 2;
                        if (n*2 < 0) {
                            System.out.println("Невозожно достичь требуемой точности");
                            System.exit(0);
                        }
                        In = 0.0;
                        I2n = 0.0;
                        for (int i = 0; i < n; i++) {
                            s = (pow(a, 2) + pow(a + interval / n, 2)) / 2 * interval / n;
                            I2n += s;
                            a += interval / n;
                        }
                        a -= interval;
                        for (int j = 0; j < n / 2; j++) {
                            s = (pow(a, 2) + pow(a + interval / (n / 2), 2)) / 2 * interval / (n / 2);
                            In += s;
                            a += interval / (n / 2);
                        }
                        a -= interval;
                    }
                    while (1.0 / 3.0 * abs(I2n - In) > accuracy);
                    break;

            case 2: if (a < 0){
                        System.out.println("Квадратный корень в поле R чисел на этом интервале не существует.");
                        while (a < 0){
                            System.out.println("Введите валидное значение границ.");
                            System.out.println("Левая граница:");
                            a = scan.nextDouble();
                            System.out.println("Правая граница:");
                            b = scan.nextDouble();
                        }
                        if (b < a){
                            double t = a;
                            a = b;
                            b = t;
                        }
                        if (a == b) {
                            System.out.println("Значение интеграла равно 0. Погрешность 0.");
                            System.exit(0);
                        }
                    }
                    do {
                        n *= 2;
                        if (n*2 < 0) {
                            System.out.println("Невозожно достичь требуемой точности");
                            System.exit(0);
                        }
                        In = 0.0;
                        I2n = 0.0;
                        for (int i = 0; i < n; i++) {
                            s = (sqrt(a) + sqrt(a + interval / n)) / 2 * interval / n;
                            I2n += s;
                            a += interval / n;
                        }
                        a -= interval;
                        for (int j = 0; j < n / 2; j++) {
                            s = (sqrt(a) + sqrt(a + interval / (n / 2))) / 2 * interval / (n / 2);
                            In += s;
                            a += interval / (n / 2);
                        }
                        a -= interval;
                    }
                    while (1.0 / 3.0 * abs(I2n - In) > accuracy);
                    break;
            case 3: if (a < 0 && b > 0){
                        if (abs(a) < abs(b)){
                            a = abs(a);
                        }
                        else {b  = -b; interval = abs(b - a);}
                    }
                    if (abs(a) == abs(b)){
                        System.out.println("Значение интеграла 0. Погрешность 0.");
                        System.exit(0);
                    }
                    if (a == 0 || b == 0){
                        System.out.println("Данный интеграл не сходится. Выберите другие границы.");
                        System.exit(0);
                    }
                    do {
                        n *= 2;
                        if (n*2 < 0) {
                            System.out.println("Невозожно достичь требуемой точности");
                            System.exit(0);
                        }
                        In = 0.0;
                        I2n = 0.0;
                        for (int i = 0; i < n; i++) {
                            s = (1 / a + 1 / (a + interval / n)) / 2 * interval / n;
                            I2n += s;
                            a += interval / n;
                        }
                        a -= interval;
                        for (int j = 0; j < n / 2; j++) {
                            s = (1 / a + 1 / (a + interval / (n / 2))) / 2 * interval / (n / 2);
                            In += s;
                            a += interval / (n / 2);
                        }
                        a -= interval;
                    }
                    while (1.0 / 3.0 * abs(I2n - In) > accuracy);
                    break;
            case 4: do {
                        n *= 2;
                        if (n*2 < 0) {
                            System.out.println("Невозожно достичь требуемой точности");
                            System.exit(0);
                        }
                        In = 0.0;
                        I2n = 0.0;
                        for (int i = 0; i < n; i++) {
                            s = (sin(a) + sin(a + interval / n)) / 2 * interval / n;
                            I2n += s;
                            a += interval / n;
                        }
                        a -= interval;
                        for (int j = 0; j < n / 2; j++) {
                            s = (sin(a) + sin(a + interval / (n / 2))) / 2 * interval / (n / 2);
                            In += s;
                            a += interval / (n / 2);
                        }
                        a -= interval;
                    }
                    while (1.0 / 3.0 * abs(I2n - In) > accuracy);
            default: System.out.println("В списке нет такой функции.");
                     break;

        }

        System.out.println("Значение интеграла " + I2n);
        System.out.println("Количество трапеций для вычисления интеграла " + n);
        System.out.println("Погрешность составила " + 1.0 / 3.0 * abs(I2n - In) + " (Это " + 1.0 / 3.0 * abs(I2n - In) / abs(I2n) + "%)");

    }

}
