package exercice2;

public interface INotification {
    void send(String recipient, String message);
    int getPriority();
    String getType();
}
