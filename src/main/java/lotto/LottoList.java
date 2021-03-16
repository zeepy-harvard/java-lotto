package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoList {
    private ArrayList<Integer> lottoList;

    public LottoList(){};

    public LottoList(ArrayList<Integer> lottoList){
        this.lottoList = lottoList;
    }

    public LottoList createLottoList(){
        LottoBalls lottoBalls = new LottoBalls();
        ArrayList<Integer> selectedBalls = lottoBalls.getSelectedBalls();
        return new LottoList(selectedBalls);
    }

    public String getLottoListToString(){
        return lottoList.toString();
    }

    public int checkNumber(Integer[] previousLottoNumber){
        List<Integer> convertPreviousLottoNumber = convertToList(previousLottoNumber);
        return (int) convertPreviousLottoNumber.stream()
                .mapToInt(prevNumber->prevNumber.intValue())
                .filter(prevNumber->lottoList.contains(prevNumber))
                .count();
    }

    private List<Integer> convertToList(Integer[] previousLottoNumber){
        return new ArrayList<>(Arrays.asList(previousLottoNumber));
    }

    public boolean checkBonus(int bonusBall) {
        return lottoList.contains(bonusBall);
    }
}
