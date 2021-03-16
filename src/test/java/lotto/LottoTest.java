package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
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
            int test = (int) getNumberOfLottoMethod.invoke(lottoClass,money);

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
    @DisplayName("구매한_lottoLists_반환_테스트")
    public void getPurchasesLottoTest(){
        Lotto lottoClass = new Lotto();
        LottoLists<ArrayList<Integer>> lottoLists;
        int numberOfLotto = 2;

        try{
            Method getPurchaseLottoMethod = lottoClass.getClass().getDeclaredMethod("getPurchasesLotto",int.class);
            getPurchaseLottoMethod.setAccessible(true);

            lottoLists = new LottoLists<>((List<ArrayList<Integer>>) getPurchaseLottoMethod.invoke(lottoClass,numberOfLotto));
            assertThat(lottoLists.size()).isEqualTo(2);
            assertThat(lottoLists.getLottoList(0).size()).isEqualTo(6);
        }catch(NoSuchMethodException e){
            System.out.println("getPurchaseLotto를 찾지못했습니다.");
            e.printStackTrace();
        }catch(IllegalAccessException e){
            System.out.println("Relection을 사용하는데 참조할수 없는 클래스,필드,메소드를 참조했습니다.");
            e.printStackTrace();
        }catch(InvocationTargetException e){
            System.out.println("invoke로 getPurchaseLottoMethod를 실행중 Exception발생");
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

    @Test
    @DisplayName("로또_비교_테스트")
    public void compareLottoNumberTest(){
        Lotto lottoClass = new Lotto();
        ArrayList<Integer> lottoList = new ArrayList<>(Arrays.asList(1,2,3,4,40,41));
        List<ArrayList<Integer>> arrayListLottoLists=new ArrayList<ArrayList<Integer>>() {{
            add(lottoList);
        }};
        LottoLists<ArrayList<Integer>> lottoLists = new LottoLists<>(arrayListLottoLists);
        Integer[] previousLottoNumber = {1,2,3,4,5,6};
        int bonusBall = 40;

        try{
            Method compareLottoNumberMethod = lottoClass.getClass().getDeclaredMethod("compareLottoNumber",LottoLists.class,Integer[].class,int.class);
            compareLottoNumberMethod.setAccessible(true);

            Integer[] statistics = (Integer[]) compareLottoNumberMethod.invoke(lottoClass,lottoLists,previousLottoNumber,bonusBall);
            assertThat(statistics[2]).isEqualTo(0);
            assertThat(statistics[3]).isEqualTo(1);
        }catch(NoSuchMethodException e){
            e.printStackTrace();
        }catch(InvocationTargetException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("수익률_테스트")
    public void getYieldTest(){
        Lotto lottoClass = new Lotto();
        Integer[] statistics = new Integer[]{2,5,0,0,1};
        int money = 14000;
        int testSum = statistics[0]*5000+statistics[1]*50000+statistics[4]*2000000000;
        double testYield = (double) testSum/money;
        try{
            Field moneyField = lottoClass.getClass().getDeclaredField("money");
            Method getYieldMethod = lottoClass.getClass().getDeclaredMethod("getYield", Integer[].class);
            moneyField.setAccessible(true);
            getYieldMethod.setAccessible(true);

            moneyField.set(lottoClass,14000);
            double yield = (double) getYieldMethod.invoke(lottoClass,new Object[]{statistics});
            assertThat(yield).isEqualTo(testYield);
        }catch(NoSuchMethodException e){
            e.printStackTrace();
        }catch(IllegalAccessException e){
            e.printStackTrace();
        }catch(InvocationTargetException e){
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
} 