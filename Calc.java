import java.util.Scanner;

public class Calc {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String str = scanner.nextLine(); // Ввод строки
        String[] arrstr = str.split(" ", 3); // Разделение строки на 3 части
        int num[] = getInt(arrstr[0], arrstr[2]); // присваиваем массиву два числа
        if (num[0] <= 10 && num[1] <=10) // если числа меньше чем 10
        {
            char operation = getOperation(arrstr[1]); // присваиваем операцию
            Res result = new Res();
            result.num1 = num[0];
            result.num2 = num[1];
            result.operation = operation;
            result.runResult();
        }
        else {
            System.out.println("Вы ввели число больше чем 10.");
        }
    }

    // Получение числа из строки
    public static int[] getInt(String arr1, String arr2){
        int num1 = 0;
        int num2 = 0;
        try
        {
            num1 = Integer.parseInt(arr1); // присвоить значение если это число
            num2 = Integer.parseInt(arr2); // присвоить значение если это число
        }
        catch(NumberFormatException nfe)
        {
            num1 = romanToDecimal(arr1); // присвоить число если это римская цифра
            num2 = romanToDecimal(arr2); // присвоить число если это римская цифра
        }
        return new int[] {num1, num2}; // вернуть два числа
    }

    // Перевод римских цифр в арабские
    public static int romanToDecimal(java.lang.String romanNumber) {
        int decimal = 0;
        int lastNumber = 0;
        String romanNumeral = romanNumber.toUpperCase(); // Перевод римских цифр в верхний регистр
        for (int x = romanNumeral.length() - 1; x >= 0 ; x--) {
            char convertToDecimal = romanNumeral.charAt(x); // Перебирание каждой цифры
            switch (convertToDecimal) {
                case 'X':
                    decimal = processDecimal(10, lastNumber, decimal); // Вызов функции для определения чему равна данная цифра в сочетании с предыдущей цифрой
                    lastNumber = 10;
                    break;
                case 'V':
                    decimal = processDecimal(5, lastNumber, decimal);
                    lastNumber = 5;
                    break;

                case 'I':
                    decimal = processDecimal(1, lastNumber, decimal);
                    lastNumber = 1;
                    break;
                default:
                    System.out.println("Вы допустили ошибку при вводе числа.");
                    System.exit(0);
            }
        }
        return decimal;
    }

    // Объединение римских цифр
    public static int processDecimal(int decimal, int lastNumber, int lastDecimal) {
        if (lastNumber > decimal) { // Если цифра предыдущая больше чем текущая
            return lastDecimal - decimal; // То вернуть "предыдущая - текущая"
        } else { // Иначе
            return lastDecimal + decimal; // То вернуть "предыдущая + текущая"
        }
    }

    // Проверка операции
    public static char getOperation(String arr){
        char operation = arr.charAt(0);
        if (operation != '+' && operation != '-' && operation != '*' && operation != '/') // Если символ не равен +, -, *, / то это ошибка
        {
            System.out.println("Вы допустили ошибку при вводе операции.");
            System.exit(0);
        }
        return operation;
    }
}
