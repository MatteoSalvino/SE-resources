import javax.jms.JMSException;

public class Init {
    public static void main(String[] args) throws JMSException {
        Subscriber subscriber = new Subscriber("dynamicTopics/Quotazioni");
        subscriber.start();
    }
}
