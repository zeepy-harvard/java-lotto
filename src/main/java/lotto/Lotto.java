package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {

    public void lottoGame(){
        List<ArrayList<Integer>> lottoLists = new ArrayList();
        int money = Input.inputMoney();
        int numberOfLotto = getNumberOfLotto(money);

        //lottoLists = countLotto(numberOfLotto,lottoLists);
        //return lottoLists;
    }
    public List<ArrayList<Integer>> getPurchasesLotto(int numberOfLotto){
        List<ArrayList<Integer>> lottoLists = new ArrayList<>();
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
