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

    public static String inputPreviousLottoNumber(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    
    public static int inputBonusBall(){
        Scanner scanner = new Scanner(System.in);
        String bonusBall = scanner.nextLine();
        return convertToInteger(bonusBall);
    }
}
