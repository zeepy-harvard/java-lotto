package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static int THREE_CORRECT_PRIZE = 5000;
    private static int FOUR_CORRECT_PRIZE = 50000;
    private static int FIVE_CORRECT_PRIZE = 1500000;
    private static int FIVE_CORRECT_PRIZE_WITH_BONUS = 30000000;
    private static int ALL_CORRECT_PRIZE = 2000000000;
    private static int THREE_CORRECT_NUMBER_INDEX = 0;
    private static int FOUR_CORRECT_NUMBER_INDEX = 1;
    private static int FIVE_CORRECT_NUMBER_INDEX = 2;
    private static int FIVE_CORRECT_WITH_BONUS_NUMBER_INDEX = 3;
    private static int ALL_CORRECT_NUMBER_INDEX = 4;
    private int money;

    private LottoLists<ArrayList<Integer>> lottoLists;

    public void lottoGame(){
        this.money = Input.inputMoney();
        int numberOfLotto = getNumberOfLotto(money);
        Output.outputNumberOfPurchaseLotto(numberOfLotto);

        lottoLists = new LottoLists(getPurchasesLotto(numberOfLotto));
        Output.outputLottoLists(lottoLists);

        Integer[] previousLottoNumber = Input.inputPreviousLottoNumber();
        int bonusBall = Input.inputBonusBall();
        Integer[] lottoResult = compareLottoNumber(lottoLists,previousLottoNumber,bonusBall);
        double yield = getYield(lottoResult);
        Output.outputStatistics(lottoResult,yield);
    }

    private int getNumberOfLotto(int money) {
        return money/1000;
    }
    private List<ArrayList<Integer>> getPurchasesLotto(int numberOfLotto){
        List<ArrayList<Integer>> createLottoLists = new ArrayList<>();
        for(int i =0;i<numberOfLotto;i++) createLottoLists.add(getLottoNumber());
        return createLottoLists;
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

    private Integer[] compareLottoNumber(LottoLists<ArrayList<Integer>> lottoLists,Integer[] previousLottoNumber,int bonusBall){
        Integer[] statistics = new Integer[]{0,0,0,0,0};
        for(int i=0;i<lottoLists.size();i++){
            ArrayList<Integer> lottoList= lottoLists.getLottoList(i);
            int numberCnt = 0;
            boolean isCorrectBonus = false;

            numberCnt = checkNumber(lottoList,previousLottoNumber,numberCnt);
            isCorrectBonus = checkBonus(lottoList, bonusBall, isCorrectBonus);
            setStatistics(statistics,numberCnt,isCorrectBonus);
        }
        return statistics;
    }

    private int checkNumber(ArrayList<Integer> lottoList,Integer[] previousLottoNumber,int numberCnt){
        for (Integer previousNumber : previousLottoNumber) {
            numberCnt = getNumberCnt(lottoList, numberCnt, previousNumber);
        }
        return numberCnt;
    }

    private int getNumberCnt(ArrayList<Integer> lottoList, int numberCnt, Integer previousNumber) {
        if (lottoList.contains(previousNumber)) {
            numberCnt++;
        }
        return numberCnt;
    }

    private boolean checkBonus(ArrayList<Integer> lottoList, int bonusBall, boolean isCorrectBonus) {
        if(lottoList.contains(bonusBall)) isCorrectBonus=true;
        return isCorrectBonus;
    }

    private void setStatistics(Integer[] statistics,int numberCnt,boolean isCorrectBonus){
        if(numberCnt == 3) statistics[THREE_CORRECT_NUMBER_INDEX]++;
        if(numberCnt == 4 && !isCorrectBonus) statistics[FOUR_CORRECT_NUMBER_INDEX]++;
        if(numberCnt == 5) statistics[FIVE_CORRECT_NUMBER_INDEX]++;
        if(numberCnt == 4 && isCorrectBonus) statistics[FIVE_CORRECT_WITH_BONUS_NUMBER_INDEX]++;
        if(numberCnt == 6) statistics[ALL_CORRECT_NUMBER_INDEX]++;
    }

    private double getYield(Integer[] statistics){
        int sum = (THREE_CORRECT_PRIZE * statistics[0]) + (FOUR_CORRECT_PRIZE * statistics[1]) + (FIVE_CORRECT_PRIZE * statistics[2]) + (FIVE_CORRECT_PRIZE_WITH_BONUS * statistics[3]) + (ALL_CORRECT_PRIZE * statistics[4]);
        return sum / money;
    }
}
