package lotto;

import java.util.ArrayList;
import java.util.List;

public class Output {
    public static void outputLottoLists(List<ArrayList<Integer>> lottoLists){
        for(ArrayList<Integer> listRow : lottoLists){
            System.out.println(listRow);
        }
    }
    public static void outputNumberOfPurchaseLotto(int numberOfLotto){
        System.out.println(numberOfLotto+"개를 구매했습니다.");
    }
}
