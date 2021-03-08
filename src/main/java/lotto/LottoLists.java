package lotto;

import java.util.List;

public class LottoLists<T>{
    private List<T> lottoLists;

    public LottoLists(List<T> prevLottoLists){this.lottoLists = prevLottoLists;}

    public Integer size(){
        return lottoLists.size();
    }

    public T getLottoList(int lottoListsIndex){
        return lottoLists.get(lottoListsIndex);
    }
}
