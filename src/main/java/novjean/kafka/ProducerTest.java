package novjean.kafka;

import java.util.Properties;
import java.util.Scanner;

//import org.apache.kafka.clients.producer.Producer;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.clients.producer.ProducerRecord;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;


@SuppressWarnings("deprecation")
public class ProducerTest {

	@SuppressWarnings({ "rawtypes", "deprecation", "unchecked" })
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Properties props = new Properties();
		
		//Zookeeper contains the meta information from producer to consumer
		props.put("zk.connect", "localhost:2181");
		
		//Serializer for encoding the message
		props.put("serializer.class", "kafka.serializer.StringEncoder");
		
		//Inform Kafka where it is running
		props.put("metadata.broker.list", "localhost:9092");		
		
		ProducerConfig config = new ProducerConfig(props);
		
		//Producer going to produce the data
		Producer producer = new Producer(config);
		
		
		String msg = "Welcome ";
		System.out.println("Enter the message to be produced. 'EXIT' will quit");
		while(!msg.equals("EXIT")){
			//'demo' is topic name
			producer.send(new KeyedMessage("demo", msg));
//			ProducerRecord record = new ProducerRecord("demo", msg);
			msg = (String)in.nextLine();
		}
		
	}

}
