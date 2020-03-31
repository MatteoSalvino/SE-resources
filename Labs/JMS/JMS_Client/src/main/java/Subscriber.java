import java.util.Properties;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Subscriber implements MessageListener {
    Properties properties;
    InitialContext jndiContext;
    TopicConnectionFactory cf;
    TopicConnection connection;
    TopicSession session;
    Topic destination;
    String destinationName;
    TopicSubscriber consumer;


    public Subscriber(String destName) {
        try {
            properties = new Properties();
            properties.setProperty(Context.INITIAL_CONTEXT_FACTORY,"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            properties.setProperty(Context.PROVIDER_URL,"tcp://localhost:61616");

            this.jndiContext = new InitialContext(properties);
            this.cf = (TopicConnectionFactory) jndiContext.lookup("ConnectionFactory");
            this.connection = cf.createTopicConnection();
            this.session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
            this.destinationName = destName;
            this.destination = (Topic) jndiContext.lookup(destinationName);
            this.consumer = session.createSubscriber(destination);
            consumer.setMessageListener(this);
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void start() throws JMSException {
        this.connection.start();
    }

    public void stop() throws JMSException {
        this.connection.stop();
    }


    public void onMessage(Message message) {
        TextMessage msg = null;
        try {
            if(message instanceof TextMessage) {
                msg = (TextMessage) message;
                String name = msg.getStringProperty("Nome");
                Float value = msg.getFloatProperty("Valore");
                if(name.compareTo("Barilla") == 0)
                    System.out.println("Reading message : (" + name +", " + value + ")");
            } else {
                System.out.println("Message of wrong type : " + message.getClass().getName());
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
