package lotto;

public class Validation {

    public static void previousLottoNumberValidation(Integer[] previousLottoNumber) throws RuntimeException{
        for(int i=0;i<previousLottoNumber.length;i++) {
            checkSameNumber(i,previousLottoNumber);
        }
    }
    private static void checkSameNumber(int winningNumberIndex,Integer[] previousLottoNumber){
        for(int j=winningNumberIndex;j<previousLottoNumber.length;j++){
            isContainSameNumber(winningNumberIndex, previousLottoNumber, j);
        }
    }

    private static void isContainSameNumber(int winningNumberIndex, Integer[] previousLottoNumber, int j) {
        if(previousLottoNumber[winningNumberIndex].equals(previousLottoNumber[j])) throw new RuntimeException("동일한 당첨번호가 나올수 없습니다.");
    }
}
