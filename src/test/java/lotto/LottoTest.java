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
    @DisplayName("로또번호생성")
    public void CreateLottoNumber(){
        Lotto lotto = new Lotto();
        List<LottoNumber> balls = lotto.getBalls();
        for(int i = 0;i<balls.size();i++){
            System.out.println(balls.get(i).getNumber());
        }
    }
}