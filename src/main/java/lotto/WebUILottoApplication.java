package lotto;

public class WebUILottoApplication {
    public static void main(String[] args) {
        RunLottoGame();
    }
    private static void RunLottoGame(){
        Lotto lotto = new Lotto();
        try{
            lotto.lottoGame();
        }catch (Exception e){
            Output.errorOutput(e);
            RunLottoGame();
        }
    }
}
