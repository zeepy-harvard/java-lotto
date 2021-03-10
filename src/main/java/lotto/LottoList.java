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
        List<LottoNumber> allBalls = new ArrayList<>(Arrays.asList(LottoNumber.values()));
        Collections.shuffle(allBalls);
        ArrayList<Integer> lottoList = new ArrayList<>();
        for(int i =0;i<6;i++){
            lottoList.add(allBalls.get(i).getNumber());
        }
        return new LottoList(lottoList);
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

    public int getNumberCnt(int numberCnt, Integer previousNumber) {
        if (lottoList.contains(previousNumber)) {
            numberCnt++;
        }
        return numberCnt;
    }

    public boolean checkBonus(int bonusBall, boolean isCorrectBonus) {
        if(lottoList.contains(bonusBall)) isCorrectBonus=true;
        return isCorrectBonus;
    }
}
