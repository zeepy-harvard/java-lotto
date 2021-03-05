package lotto;

public class Validation {

    public static void previousLottoNumberValidation(Integer[] previousLottoNumber) throws RuntimeException{
        for(int i=0;i<previousLottoNumber.length;i++) {
            checkRangeOfLottoNumber(i,previousLottoNumber);
            checkSameNumber(i,previousLottoNumber);
        }
    }
    private static void checkSameNumber(int winningNumberIndex,Integer[] previousLottoNumber){
        for(int j=winningNumberIndex+1;j<previousLottoNumber.length;j++){
            isContainSameNumber(winningNumberIndex, previousLottoNumber, j);
        }
    }

    private static void isContainSameNumber(int winningNumberIndex, Integer[] previousLottoNumber, int j) {
        if(previousLottoNumber[winningNumberIndex].equals(previousLottoNumber[j])) throw new RuntimeException("동일한 당첨번호가 나올수 없습니다.");
    }

    private static void checkRangeOfLottoNumber(int winningNumberIndex,Integer[] previousLottoNumber){
        if(previousLottoNumber[winningNumberIndex] > 45) throw new RuntimeException("존재하지 않는 로또번호를 입력하셨습니다.");
    }
}
