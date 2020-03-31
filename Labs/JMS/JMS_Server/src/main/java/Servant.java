import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;


public class Servant {
    InitialContext jndiContext;
    TopicConnectionFactory connectionFactory;
    TopicConnection connection;
    TopicSession session;
    Topic destination;
    TopicPublisher publisher;
    String[] enterprises;


    public Servant(String destName) {
        try {
            this.enterprises = new String[]{"Parmalat", "Vodafone", "FinMeccanica", "Tim", "WindTre", "Barilla"};

            Properties properties = new Properties();
            properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            properties.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");

            this.jndiContext = new InitialContext(properties);
            this.connectionFactory = (TopicConnectionFactory) jndiContext.lookup("ConnectionFactory");
            this.destination = (Topic) jndiContext.lookup(destName);
            this.connection = this.connectionFactory.createTopicConnection();
            this.session = this.connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
            this.publisher = session.createPublisher(destination);
        } catch (JMSException err) {
            err.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }


    public void sendMessage() {
        try {
            TextMessage message = session.createTextMessage();

            message.setStringProperty("Nome", enterprises[(int) (Math.random() * enterprises.length)]);
            message.setFloatProperty("Valore", (float) Math.random() * 100);

            publisher.publish(message);
            System.out.println("Message (" + message.getStringProperty("Nome") + ", " + message.getFloatProperty("Valore") + ") published");
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            this.connection.start();
            System.out.println("Server started...");

            while(true) {
                System.out.println("Publishing message...");
                sendMessage();

                try {
                    Thread.sleep(3000);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            if (this.connection != null) {
                try {
                    this.connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void stop() throws JMSException {
        this.connection.stop();
    }
}
