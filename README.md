# java-lotto
로또 미션 진행을 위한 저장소

# 목적

- enum을 배워봅시다.
- Exception을 배워봅시다.

# 요구사항

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 합니다.
- 로또 1장의 가격은 1000원입니다.

# 풀이

1. main클래스에서 lotto클래스 객체를 생성후 lottoGame메소드 실행
2. 구입금액 입력후 구매갯수 획득
3. enum을 통해 로또번호를 생성하고 갯수만큼 반환받는다(2중배열로 저장한다).
4. 지난 주 당첨번호 입력(존재하지 않는 번호, 동일한 번호 입력시 RuntimeException발생)
5. 보너스 볼 입력(존재하지 않는 번호 입력시 RuntimeException발생)
6. 일치하는 번호의 수를 계산하기 위해 Integer[] statistics에 3개맞춘 로또 부터 저장해준다.
7. 총 수익률 반환.

# 코드

```java
[WebUILottoApplication.java]

public class WebUILottoApplication {
    public static void main(String[] args) {
        RunLottoGame();
    }
    private static void RunLottoGame(){
        Lotto lotto = new Lotto();
        try{
            lotto.lottoGame();
        }catch (Exception e){	//Exception발생시 재시작
            Output.errorOutput(e);
            RunLottoGame();
        }
    }
}
```

```java
[Lotto.java]

public class Lotto {
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
    private int money;

    public void lottoGame(){
        ArrayList lottoLists;
        
        this.money = Input.inputMoney();//구매금액 입력
        int numberOfLotto = getNumberOfLotto(money);//구매갯수
        Output.outputNumberOfPurchaseLotto(numberOfLotto);//갯수 출력

        lottoLists=getPurchasesLotto(numberOfLotto);//구매한갯수만큼 로또번호 생성
        Output.outputLottoLists(lottoLists);//구매한 로또번호 출력

        Integer[] previousLottoNumber = Input.inputPreviousLottoNumber();//지난 주 당첨 번호 입력
        int bonusBall = Input.inputBonusBall();//보너스 볼 입력
        Integer[] lottoResult = compareLottoNumber(lottoLists,previousLottoNumber,bonusBall);//로또 일치여부
        double yeild = getYield(lottoResult);//수익률 계산
        Output.outputStatistics(lottoResult,yeild);//당첨 통계 출력
    }

    private Integer[] compareLottoNumber(List<ArrayList<Integer>> lottoLists,Integer[] previousLottoNumber,int bonusBall){
        Integer[] statistics = new Integer[]{0,0,0,0,0};	//0번 index부터 3개 일치,4개 일치,5개 일치,5개(보너스),6개 일치
        for(ArrayList<Integer> lottoList : lottoLists){
            int numberCnt = 0;
            boolean isCorrectBonus = false;

            numberCnt = checkNumber(lottoList,previousLottoNumber,numberCnt);
            isCorrectBonus = checkBonus(lottoList, bonusBall, isCorrectBonus);
            setStatistics(statistics,numberCnt,isCorrectBonus);
        }
        return statistics;
    }
    private void setStatistics(Integer[] statistics,int numberCnt,boolean isCorrectBonus){
        if(numberCnt == 3) statistics[THREE_CORRECT_NUMBER_INDEX]++;
        if(numberCnt == 4 && !isCorrectBonus) statistics[FOUR_CORRECT_NUMBER_INDEX]++;
        if(numberCnt == 5) statistics[FIVE_CORRECT_NUMBER_INDEX]++;
        if(numberCnt == 4 && isCorrectBonus) statistics[FIVE_CORRECT_WITH_BONUS_NUMBER_INDEX]++;
        if(numberCnt == 6) statistics[ALL_CORRECT_NUMBER_INDEX]++;
    }

    private boolean checkBonus(ArrayList<Integer> lottoList, int bonusBall, boolean isCorrectBonus) {
        if(lottoList.contains(bonusBall)) isCorrectBonus=true;
        return isCorrectBonus;
    }

    private int checkNumber(ArrayList<Integer> lottoList,Integer[] previousLottoNumber,int numberCnt){
        for (Integer integer : previousLottoNumber)
            if (lottoList.contains(integer)) {
                numberCnt++;
            }
        return numberCnt;
    }

    private ArrayList getPurchasesLotto(int numberOfLotto){
        ArrayList lottoLists = new ArrayList<>();
        for(int i =0;i<numberOfLotto;i++) lottoLists.add(getLottoNumber());	//구매한 갯수만큼 for문
        return lottoLists;
    }

    private ArrayList<Integer> getLottoNumber(){
        List<LottoNumber> allBalls = new ArrayList<>(Arrays.asList(LottoNumber.values()));	//enum클래스에서 모든 숫자 출력(1~45)
        Collections.shuffle(allBalls);//shuffle(바람불기)
        ArrayList<Integer> lottoList = new ArrayList<>();
        for(int i =0;i<6;i++){
            lottoList.add(allBalls.get(i).getNumber());//건져진 6개의 볼
        }
        return lottoList;
    }

    private int getNumberOfLotto(int money) {
        return money/1000;
    }

    private double getYield(Integer[] statistics){
        int sum = (THREE_CORRECT_PRIZE * statistics[0]) + (FOUR_CORRECT_PRIZE * statistics[1]) + (FIVE_CORRECT_PRIZE * statistics[2]) + (FIVE_CORRECT_PRIZE_WITH_BONUS * statistics[3]) + (ALL_CORRECT_PRIZE * statistics[4]);
        return sum / money;
    }
}
```

```java
[LottoNumber.java]

public enum LottoNumber {
    ONE(1),TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6),SEVEN(7),EIGHT(8),NINE(9),TEN(10),
    ELEVEN(11),TWELVE(12),THIRTEEN(13),FOURTEEN(14),FIFTEEN(15),SIXTEEN(16),SEVENTEEN(17),EIGHTEEN(18),NINETEEN(19),
    TWENTY(20),TWENTY_ONE(21),TWENTY_TWO(22),TWENTY_THREE(23),TWENTY_FOUR(24),TWENTY_FIVE(25),TWENTY_SIX(26),TWENTY_SEVEN(27),TWENTY_EIGHT(28),TWENTY_NINE(29),
    THIRTY(30),THIRTY_ONE(31),THIRTY_TWO(32),THIRTY_THREE(33),THIRTY_FOUR(34),THIRTY_FIVE(35),THIRTY_SIX(36),THIRTY_SEVEN(37),THIRTY_EIGHT(38),THIRTY_NINE(39),
    FORTY(40),FORTY_ONE(41),FORTY_TWO(42),FORTY_THREE(43),FORTY_FOUR(44),FORTY_FIVE(45);

    private int number;

    LottoNumber(int number){
        this.number=number;
    }

    int getNumber(){
        return number;
    }
}
```



# enum

```java
enum Currency{
    DoLLAR(1100), EURO(1500), YEN(1000), YUAN(150);
    int value;
    private Currency(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}

public class EnumExam{
    public static void main(String[] args){
        Currency curCurrency = Currency.EURO;
        switch(curCurrency){
            case DOLLLAR:
                System.out.println("달러의 환율은 "+curCurrency.getValue()+"원 입니다.");
                break;
            case EURO:
                System.out.println("유로화의 환율은 "+curCurrency.getValue()+"원 입니다.");
                break;
        }
    }
}
```

* enum에서 value라는 **필드**와 **getter**가 있고 **생성자**가 있다.
* enum에서 생성자가 private인 이유는 보통 객체는 런타임 중에 생성되기 때문에 생성자는 외부에서 호출이 가능한 public으로 선언하지만, enum은 고정된 상수의 집합이기때문에 컴파일 타임에 값을 알아야한다. 그렇기 떄문에 외부에서 생성자에 접근할수 없도록 private로 만든것이다.(**안정성 보장**)

