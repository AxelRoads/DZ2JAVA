/*
 *
 * К калькулятору из предыдущего дз добавить логирование.
 *
 */

import java.util.logging.*;
import java.io.IOException;
import java.util.Scanner;

public class dz2task4 {
    private static Logger logger = Logger.getLogger(dz2task4.class.getName());

    public static void main(String[] args) throws IOException {
        FileHandler fh = new FileHandler("log.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        Solve solve = new Solve();
        double otvet = solve.solutions();
        System.out.println(otvet);
        solve.proverka();

    }
}

class Solve {
    private static Logger logger = Logger.getLogger(dz2task4.class.getName());

    String operation;
    double res;
    double x;
    double y;
    boolean test = false;

    Solve() {
        // Scanner input = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите 2 числа через пробел");
        x = sc.nextDouble();
        y = sc.nextDouble();
        logger.info("Пользователь ввел числа");
        System.out.print(
                "Какую математическую операцию вы хотите произвести: \n сложение - sum \n" +
                        " вычитание - minus \n умножение - mult \n деление - div \n Введите: ");

        operation = sc.next();
        sc.close();
    }

    double solutions() {
        if (operation.equals("sum")) {
            res = x + y;
            test = true;
            logger.info("Пользователь запросил сложение");
        } else if (operation.equals("minus")) {
            res = x - y;
            test = true;
            logger.info("Пользователь запросил вычитание");
        } else if (operation.equals("mult")) {
            res = x * y;
            test = true;
            logger.info("Пользователь запросил умножение");
        } else if (operation.equals("div")) {
            res = x / y;
            test = true;
            logger.info("Пользователь запросил деление");
        }
        return res;

    }

    void proverka() {
        if (test) {
            logger.info("Вычисление произведено");

        } else {
            System.out.println("Вы ввели неправильную операцию");
            logger.log(Level.WARNING, "Пользователь сделал ошибку ввода");
        }
    }
}