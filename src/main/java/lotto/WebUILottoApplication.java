package lotto;


public class WebUILottoApplication {
    public static void main(String[] args) {
        Lotto lotto = new Lotto();
        int numberOfLotto = lotto.lotto(1000);
        System.out.println(numberOfLotto);
    }

}
