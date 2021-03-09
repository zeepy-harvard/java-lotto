package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("javaLotto_테스트_클래스")
public class LottoTest {

    @Test
    @DisplayName("로또_구매갯수_반환_테스트")
    public void getNumberOfLottoTest() {
        Lotto lottoClass = new Lotto();
        int money = 2000;
        try{
            Method getNumberOfLottoMethod = lottoClass.getClass().getDeclaredMethod("getNumberOfLotto", int.class);
            getNumberOfLottoMethod.setAccessible(true);

            assertThat((int) getNumberOfLottoMethod.invoke(lottoClass,money)).isEqualTo(2);
        }catch (NoSuchMethodException e){
            System.out.println("getNumberOfLotto를 찾지못했습니다.");
            e.printStackTrace();
        }catch (InvocationTargetException e){
            System.out.println("inovoke로 geNUmberOfLottoMethod를 실행중 Exception발생");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.out.println("Reflection을 사용하는데 참조할수 없는 클래스,필드,메소드를 참조했습니다.");
            e.printStackTrace();
        }
    }

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