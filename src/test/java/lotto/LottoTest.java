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

    }

    @Test
    public void prevNumberTest(){
        Integer[] preveNumber = Input.prevLottoNumberSplit("1, 2, 3, 4, 5, 6");
        for(int i : preveNumber){
            System.out.println(i);
        }
    }
}