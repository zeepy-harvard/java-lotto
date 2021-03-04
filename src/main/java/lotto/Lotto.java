package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {
    public void lottoGame(int money){
        List<ArrayList<Integer>> lottoLists = new ArrayList();

        int numberOfLotto = getNumberOfLotto(money);

        //lottoLists = countLotto(numberOfLotto,lottoLists);
        //return lottoLists;
    }
    private ArrayList<Integer> getBuyNumber(int numberOfLotto){
        ArrayList<Integer> lottoLists = getNumber();
        return lottoLists;
    }

    public ArrayList<Integer> getNumber(){
        List<LottoNumber> allBalls = new ArrayList<>(Arrays.asList(LottoNumber.values()));
        Collections.shuffle(allBalls);
        ArrayList<Integer> lottoList = new ArrayList<>();
        for(int i =0;i<6;i++){
            lottoList.add(allBalls.get(i).getNumber());
        }
        return lottoList;
    }

    private int getNumberOfLotto(int money) {
        int purchaseNumber = money/1000;
        return purchaseNumber;
    }
}
