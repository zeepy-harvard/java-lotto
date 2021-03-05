package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("javaLotto_테스트_클래스")
public class LottoTest {

    @Test
    @DisplayName("로또_번호_자동생성")
    public void NumberOfLotto(){
        Lotto lotto = new Lotto();
        List<ArrayList<Integer>> createLotto = new ArrayList<>();

        assertThat(createLotto.get(0)).contains(1,2,3,4,5,6,7,8,9,10);
    }

    @Test
    @DisplayName("로또번호_갯수만큼_생성")
    public void getPurchasesLottoTest(){
        Lotto lotto = new Lotto();
        List<ArrayList<Integer>> lottoLists = lotto.getPurchasesLotto(2);
        for(int i=0;i<lottoLists.size();i++){
            System.out.println(i+"번째 배열>>> ");
            for(int j=0;j<lottoLists.get(i).size();j++){
                System.out.println(lottoLists.get(i).get(j));
            }
        }
    }

    @Test
    @DisplayName("구매한_로또들_출력")
    public void outPutPurchaseLottoListTest(){
        Lotto lotto = new Lotto();
        List<ArrayList<Integer>> lottoLists = lotto.getPurchasesLotto(3);
        Output.outputLottoLists(lottoLists);
    }
}