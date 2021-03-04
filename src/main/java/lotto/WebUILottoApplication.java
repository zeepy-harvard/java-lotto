package lotto;


import java.util.ArrayList;
import java.util.List;

public class WebUILottoApplication {
    public static void main(String[] args) {
        Lotto lotto = new Lotto();
        lotto.lottoGame(2000);
//        List<ArrayList<Integer>> lottoList = lotto.lotto(2000);
//        for(int i:lottoList.get(0)){
//            System.out.println(i);
//        }
    }

}
