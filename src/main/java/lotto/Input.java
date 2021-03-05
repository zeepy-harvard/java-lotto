package lotto;

import java.util.Scanner;

public class Input {
    public static int inputMoney(){
        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.nextLine();
        return convertToInteger(inputValue);
    }

    private static int convertToInteger(String inputValue){
        int integerValue = Integer.parseInt(inputValue);
        return integerValue;
    }
}
