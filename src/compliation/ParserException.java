package compliation;

/**
 * @Author chr
 * @Date 4/15/2019 12:35 PM
 * @Version 1.0
 */

public class ParserException extends Exception {
    private static final long serialVersionUID = 8930730209321088339L;
    String errStr;

    public ParserException(String str) {
        this.errStr = str;
    }

    public String toString() {
        return errStr;
    }
}
