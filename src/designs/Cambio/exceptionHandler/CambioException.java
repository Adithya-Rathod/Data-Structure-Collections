package designs.Cambio.exceptionHandler;

public class CambioException extends Exception {
    private final ExceptionsReason exceptionsReason;
    private String[] args;

    public CambioException(ExceptionsReason er){
        super(er.reason);
        this.exceptionsReason = er;
    }
    public CambioException(ExceptionsReason er, String... arg){
        super(String.format(er.reason, arg));
        this.args = arg;
        this.exceptionsReason = er;
    }

    public enum ExceptionsReason{
        ILLEGAL_MOVE("Player can't make this move!"),
        ILLEGAL_HAND("Player can't have this hand!"),
        CARD_OVERFLOW("Player has exceeded more than allowed card number!"),
        EMPTY_DECK("There is no card left to draw!");
        private final String reason;
        ExceptionsReason(String reason){
            this.reason = reason;
        }
    }
}
