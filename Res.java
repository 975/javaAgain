public class Res {
    int num1;
    int num2;
    char operation;

    void runResult() {
        int result;
        switch (operation){
            case '+':
                result = num1+num2;
                break;
            case '-':
                result = num1-num2;
                break;
            case '*':
                result = num1*num2;
                break;
            case '/':
                result = num1/num2;
                break;
            default:
                result = 0;
        }
        System.out.println("Результат операции: "+result);
    }
}
