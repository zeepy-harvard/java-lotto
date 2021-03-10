package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoLists<T>{
    private List<T> lottoLists;

    public LottoLists(){
        this.lottoLists = new ArrayList<>();
    }

    public LottoLists(List<T> prevLottoLists){this.lottoLists = prevLottoLists;}

    public Integer size(){
        return lottoLists.size();
    }

    public String getLottoList(int lottoListsIndex){
        LottoList findLottoList = (LottoList)lottoLists.get(lottoListsIndex);
        return findLottoList.getLottoListToString();
    }

    public LottoLists createLottoLists(int numberOfLotto){
        LottoList lottoList = new LottoList();
        for(int i=0;i<numberOfLotto;i++) lottoLists.add((T) lottoList.createLottoList());
        return new LottoLists(lottoLists);
    }

    public Statistics compareLottoNumber(Integer[] previousLottoNumber,int bonusBall){
        Statistics statistics = new Statistics();
        for(int i=0;i<lottoLists.size();i++){
            LottoList lottoList = (LottoList) lottoLists.get(i);
            int numberCnt = 0;
            boolean isCorrectBonus = false;

            numberCnt = lottoList.checkNumber(previousLottoNumber,numberCnt);
            isCorrectBonus = lottoList.checkBonus(bonusBall,isCorrectBonus);
            statistics.setStatistics(numberCnt,isCorrectBonus);
        }
        return statistics;
    }
}
