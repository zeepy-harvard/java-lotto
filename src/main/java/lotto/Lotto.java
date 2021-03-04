package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {
    public void lotto(int money){
        List<ArrayList<Integer>> lottoLists = new ArrayList();

        int numberOfLotto = getNumberOfLotto(money);

        //lottoLists = countLotto(numberOfLotto,lottoLists);
        //return lottoLists;
    }
    private ArrayList<LottoNumber> startLottoMachine(){
        ArrayList<LottoNumber> balls = getBalls();
        return balls;
    }

    public ArrayList<LottoNumber> getBalls(){
        List<LottoNumber> allBalls = new ArrayList<>(Arrays.asList(LottoNumber.values()));
        Collections.shuffle(allBalls);
        ArrayList<LottoNumber> balls = new ArrayList<>(allBalls.subList(0,6));
        return balls;
    }

    private int getNumberOfLotto(int money) {
        int purchaseNumber = money/1000;
        return purchaseNumber;
    }
}
