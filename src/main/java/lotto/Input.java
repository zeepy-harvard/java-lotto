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

    public static Integer[] inputPreviousLottoNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return prevLottoNumberSplit(scanner.nextLine());
    }

    public static Integer[] prevLottoNumberSplit(String previousLottoNumber){
        Integer[] integerNumber = new Integer[6];
        previousLottoNumber = previousLottoNumber.replace(" ","");
        String[] splitNumber = previousLottoNumber.split(",");
        for(int i =0;i<splitNumber.length;i++){
            integerNumber[i] = Integer.parseInt(splitNumber[i]);
        }
        return integerNumber;
    }

    public static int inputBonusBall(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        return  scanner.nextInt();
//        return convertToInteger(bonusBall);
    }
}
