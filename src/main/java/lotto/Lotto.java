package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {

    public void lottoGame(){
        ArrayList lottoLists;
        int money = Input.inputMoney();
        int numberOfLotto = getNumberOfLotto(money);
        Output.outputNumberOfPurchaseLotto(numberOfLotto);

        lottoLists=getPurchasesLotto(numberOfLotto);
        Output.outputLottoLists(lottoLists);

        Integer[] previousLottoNumber = Input.inputPreviousLottoNumber();
        int bonusBall = Input.inputBonusBall();
        Integer[] lottoResult = compareLottoNumber(lottoLists,previousLottoNumber,bonusBall);
        Output.outputStatistics(lottoResult);
    }

    private Integer[] compareLottoNumber(List<ArrayList<Integer>> lottoLists,Integer[] previousLottoNumber,int bonusBall){
        Integer[] statistics = new Integer[]{0,0,0,0,0};
        for(ArrayList<Integer> lottoList : lottoLists){
            int numberCnt = 0;
            boolean isCorrectBonus = false;

            numberCnt = checkNumber(lottoList,previousLottoNumber,numberCnt);
            isCorrectBonus = checkBonus(lottoList, bonusBall, isCorrectBonus);
            statistics = setStatistics(statistics,numberCnt,isCorrectBonus);
        }
        return statistics;
    }
    private Integer[] setStatistics(Integer[] statistics,int numberCnt,boolean isCorrectBonus){
        if(numberCnt == 3) statistics[0]++;
        if(numberCnt == 4 && !isCorrectBonus) statistics[1]++;
        if(numberCnt == 5) statistics[2]++;
        if(numberCnt == 4 && isCorrectBonus) statistics[3]++;
        if(numberCnt == 6) statistics[4]++;
        return statistics;
    }

    private boolean checkBonus(ArrayList<Integer> lottoList, int bonusBall, boolean isCorrectBonus) {
        if(lottoList.contains(bonusBall)) isCorrectBonus=true;
        return isCorrectBonus;
    }

    private int checkNumber(ArrayList<Integer> lottoList,Integer[] previousLottoNumber,int numberCnt){
        for (Integer integer : previousLottoNumber)
            if (lottoList.contains(integer)) {
                numberCnt++;
            }
        return numberCnt;
    }

    private ArrayList getPurchasesLotto(int numberOfLotto){
        ArrayList lottoLists = new ArrayList<>();
        for(int i =0;i<numberOfLotto;i++){
            lottoLists.add(getLottoNumber());
        }
        return lottoLists;
    }

    private ArrayList<Integer> getLottoNumber(){
        List<LottoNumber> allBalls = new ArrayList<>(Arrays.asList(LottoNumber.values()));
        Collections.shuffle(allBalls);
        ArrayList<Integer> lottoList = new ArrayList<>();
        for(int i =0;i<6;i++){
            lottoList.add(allBalls.get(i).getNumber());
        }
        return lottoList;
    }

    private int getNumberOfLotto(int money) {
        return money/1000;
    }
}
