package exercice2;

import java.util.Arrays;
import java.util.Comparator;

public class NotificationManager {
    private INotification[] channels = new INotification[3];
    private int count = 0;
    public void addChannel(INotification n) {
        if (count == channels.length) {
            INotification[] tmp = new INotification[channels.length * 2];
            System.arraycopy(channels, 0, tmp, 0, channels.length);
            channels = tmp;
        }
        channels[count++] = n;
    }

    public void broadcast(String recipient, String message) {
        INotification[] copy = Arrays.copyOf(channels, count);
        Arrays.sort(copy, Comparator.comparingInt(INotification::getPriority).reversed());

        System.out.println("Broadcast to " + recipient + ":");
        for (INotification n : copy) {
            System.out.printf("Channel [%s, prio=%d]: ",
                    n.getType(), n.getPriority());
            n.send(recipient, message);
        }
        System.out.println();
    }
}
