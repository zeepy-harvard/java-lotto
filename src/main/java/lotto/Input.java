package lotto;

import lotto.CustomException.WrongInputNumberException;

import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);
    private static String numberRegularExpression = "^[0-9]+$";
    public static int inputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String inputValue = scanner.nextLine();
        return convertToInteger(inputValue);
    }

    private static int convertToInteger(String inputValue){
        String numberRegularExpression = "^[0-9]+$";
        if(!inputValue.matches(numberRegularExpression)) throw new WrongInputNumberException("숫자를 입력해주세요.");
        return Integer.parseInt(inputValue);
    }

    public static Integer[] inputPreviousLottoNumber(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Integer[] prevLottoNumber = prevLottoNumberSplit(scanner.nextLine());
        previousLottoNumberValidation(prevLottoNumber);
        return prevLottoNumber;
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

    private static void previousLottoNumberValidation(Integer[] previousLottoNumber){
        checkPreviousLottoNumberLength(previousLottoNumber);
        for(int i=0;i<previousLottoNumber.length;i++) {
            checkRangeOfLottoNumber(i,previousLottoNumber);
            checkSameNumber(i,previousLottoNumber);
        }
    }

    private static void checkPreviousLottoNumberLength(Integer[] previousLottoNumber){
        int valueCount=0;
        for(int i = 0;i<previousLottoNumber.length;i++){
            if(previousLottoNumber[i]!=null) valueCount++;
        }
        if(valueCount<6) throw new WrongInputNumberException("당첨번호를 전부 입력해주세요.");
    }

    private static void checkRangeOfLottoNumber(int winningNumberIndex,Integer[] previousLottoNumber){
        if(previousLottoNumber[winningNumberIndex] > 45 && previousLottoNumber[winningNumberIndex]<1) throw new WrongInputNumberException("존재하지 않는 로또번호를 입력하셨습니다.");
    }

    private static void checkSameNumber(int winningNumberIndex,Integer[] previousLottoNumber){
        for(int j=winningNumberIndex+1;j<previousLottoNumber.length;j++){
            isContainSameNumber(winningNumberIndex, previousLottoNumber, j);
        }
    }

    private static void isContainSameNumber(int winningNumberIndex, Integer[] previousLottoNumber, int j) {
        if(previousLottoNumber[winningNumberIndex].equals(previousLottoNumber[j])) throw new WrongInputNumberException("동일한 당첨번호가 나올수 없습니다.");
    }

    public static int inputBonusBall(){
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusBall = scanner.nextInt();
        bonusBallValidation(bonusBall);
        return  bonusBall;
    }

    public static void bonusBallValidation(int bonusBall)throws RuntimeException{
        if(bonusBall > 45 && bonusBall<1) throw new WrongInputNumberException("존재하지 않는 로또번호를 입력하셨습니다.");
    }
}
