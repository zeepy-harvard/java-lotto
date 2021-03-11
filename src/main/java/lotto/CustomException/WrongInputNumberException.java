package lotto.CustomException;

public class WrongInputNumberException extends RuntimeException{
    public WrongInputNumberException(String msg){
        super(msg);
    }
}
