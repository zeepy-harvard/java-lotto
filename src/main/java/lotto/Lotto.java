package lotto;

public class Lotto {
    private int moneyDivisionPay = 1000;
    private int money;

    private LottoLists<LottoList> lottoLists = new LottoLists<>();
    private LottoList lottoList = new LottoList();
    private Statistics statistics;

    public void lottoGame(){
        this.money = Input.inputMoney();
        int numberOfLotto = getNumberOfLotto(money);
        Output.outputNumberOfPurchaseLotto(numberOfLotto);

        lottoLists = lottoLists.createLottoLists(numberOfLotto);
        Output.outputLottoLists(lottoLists);

        Integer[] previousLottoNumber = Input.inputPreviousLottoNumber();
        int bonusBall = Input.inputBonusBall();
        statistics = lottoLists.compareLottoNumber(previousLottoNumber,bonusBall);
        double yield = statistics.getYield(money);
        Output.outputStatistics(statistics,yield);
    }

    private int getNumberOfLotto(int money) {
        return money/moneyDivisionPay;
    }
}
