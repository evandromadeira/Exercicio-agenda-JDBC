package agenda.exception;

public class AgendaException extends Exception {

    public AgendaException() {
        super("Ocorreu um erro desconhecido!");
    }
    public AgendaException(String msg) {
        super(msg);
    }

}
