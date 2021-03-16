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

    public int checkNumber(Integer[] previousLottoNumber,int numberCnt){
        for (Integer previousNumber : previousLottoNumber) {
            numberCnt = getNumberCnt(numberCnt, previousNumber);
        }
        return numberCnt;
    }

    private int getNumberCnt(int numberCnt, Integer previousNumber) {
        if (lottoList.contains(previousNumber)) {
            numberCnt++;
        }
        return numberCnt;
    }

    public boolean checkBonus(int bonusBall) {
        return lottoList.contains(bonusBall);
    }
}
