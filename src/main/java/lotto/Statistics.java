package lotto;

public class Statistics {
    private Integer[] statistics;

    private static int THREE_CORRECT_PRIZE = 5000;
    private static int FOUR_CORRECT_PRIZE = 50000;
    private static int FIVE_CORRECT_PRIZE = 1500000;
    private static int FIVE_CORRECT_PRIZE_WITH_BONUS = 30000000;
    private static int ALL_CORRECT_PRIZE = 2000000000;
    private static int THREE_CORRECT_NUMBER_INDEX = 0;
    private static int FOUR_CORRECT_NUMBER_INDEX = 1;
    private static int FIVE_CORRECT_NUMBER_INDEX = 2;
    private static int FIVE_CORRECT_WITH_BONUS_NUMBER_INDEX = 3;
    private static int ALL_CORRECT_NUMBER_INDEX = 4;

    public Statistics(){
        this.statistics = new Integer[]{0,0,0,0,0};
    }

    public void setStatistics(int numberCnt,boolean isCorrectBonus){
        if(numberCnt == 3) statistics[THREE_CORRECT_NUMBER_INDEX]++;
        if(numberCnt == 4 && !isCorrectBonus) statistics[FOUR_CORRECT_NUMBER_INDEX]++;
        if(numberCnt == 5) statistics[FIVE_CORRECT_NUMBER_INDEX]++;
        if(numberCnt == 4 && isCorrectBonus) statistics[FIVE_CORRECT_WITH_BONUS_NUMBER_INDEX]++;
        if(numberCnt == 6) statistics[ALL_CORRECT_NUMBER_INDEX]++;
    }

    public double getYield(int money){
        int sum = (THREE_CORRECT_PRIZE * statistics[0]) + (FOUR_CORRECT_PRIZE * statistics[1]) + (FIVE_CORRECT_PRIZE * statistics[2]) + (FIVE_CORRECT_PRIZE_WITH_BONUS * statistics[3]) + (ALL_CORRECT_PRIZE * statistics[4]);
        return (double) sum / money;
    }

    public Integer getCorrectNumber(int numberIndex){
        return statistics[numberIndex];
    }
}
