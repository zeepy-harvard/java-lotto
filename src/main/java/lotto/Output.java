package lotto;

import java.util.ArrayList;
import java.util.List;

public class Output {
    public static void outputLottoLists(List<ArrayList<Integer>> lottoLists){
        for(ArrayList<Integer> listRow : lottoLists){
            System.out.println(listRow);
        }
    }
    public static void outputNumberOfPurchaseLotto(int numberOfLotto){
        System.out.println(numberOfLotto+"개를 구매했습니다.");
    }
    public static void outputStatistics(Integer[] statistics,double yield){
        System.out.println("당첨 통계");
        System.out.println("--------------");
        normalStatisticsOutput(3,5000,statistics[0]);
        normalStatisticsOutput(4,50000,statistics[1]);
        normalStatisticsOutput(5,1500000,statistics[2]);
        bonusStatisticsOutput(5,30000000,statistics[3]);
        normalStatisticsOutput(6,2000000000,statistics[4]);
        System.out.printf("총 수익률은 %.2f 입니다.",yield);
    }
    private static void normalStatisticsOutput(int matchNumber,int prizeMoney,int matchCount){
        System.out.println(matchNumber+"개 일치 ("+prizeMoney+"원) - "+matchCount+"개");
    }
    private static void bonusStatisticsOutput(int matchNumber,int prizeMoney,int matchCount){
        System.out.println(matchNumber+"개 일치 , 보너스 볼 일치("+prizeMoney+"원) - "+matchCount+"개");
    }
    public static void errorOutput(Exception e){
        System.out.println("에러발생>> "+e.getMessage());
        e.printStackTrace();
    }
}
