package lotto;

import java.util.Scanner;

public class Input {
    public static int inputMoney(){
        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.nextLine();
        return convertToInteger(inputValue);
    }

    private static int convertToInteger(String inputValue){
        return Integer.parseInt(inputValue);
    }

    public static String previousLottoNumber(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
