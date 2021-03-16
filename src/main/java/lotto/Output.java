package lotto;

public class Output {
    public static void outputLottoLists(LottoLists lottoLists){
        for(int i=0;i<lottoLists.size();i++){
            System.out.println(lottoLists.getLottoList(i));
        }
    }
    public static void outputNumberOfPurchaseLotto(int numberOfLotto){
        System.out.println(numberOfLotto+"개를 구매했습니다.");
    }
    public static void outputStatistics(Statistics statistics,double yield){
        System.out.println("당첨 통계");
        System.out.println("--------------");
        normalStatisticsOutput(3,5000,statistics.getCorrectNumber(0));
        normalStatisticsOutput(4,50000,statistics.getCorrectNumber(1));
        normalStatisticsOutput(5,1500000,statistics.getCorrectNumber(2));
        bonusStatisticsOutput(5,30000000,statistics.getCorrectNumber(3));
        normalStatisticsOutput(6,2000000000,statistics.getCorrectNumber(4));
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
    }
}
