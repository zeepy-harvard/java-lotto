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
    @DisplayName("LottoLists 크기 반환 & 내용물 반환")
    public void getLottoListsSizeTest(){
        List<Integer> testArrayList = new ArrayList();
        testArrayList.add(1);
        testArrayList.add(10);

        LottoLists<Integer> testLottoLists = new LottoLists<>(testArrayList);
        assertThat(testLottoLists.size()).isEqualTo(2);
        assertThat(testLottoLists.getLottoList(0)).isEqualTo(testArrayList.get(0));
    }
} 