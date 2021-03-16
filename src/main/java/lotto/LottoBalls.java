package lotto;

import java.util.*;

public class LottoBalls {
    private List<LottoNumber> allBalls;

    public LottoBalls(){
        this.allBalls = new ArrayList<>(Arrays.asList(LottoNumber.values()));
    }

    public ArrayList<Integer> getSelectedBalls(){
        ArrayList<Integer> lottoList = new ArrayList<>();
        Collections.shuffle(allBalls);
        for(int i=0;i<6;i++){
            lottoList.add(allBalls.get(i).getNumber());
        }
        return lottoList;
    }
}
