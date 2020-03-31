import javax.jms.JMSException;

public class Init {
    public static void main(String[] args) throws InterruptedException, JMSException {
        Servant servant = new Servant("dynamicTopics/Quotazioni");
        servant.start();
    }
}
