package org.example;

import Data.User;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.time.Duration;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.example.kafka.KafkaConsumerBuilder.KafkaConsumerBuilder;
import static org.example.kafka.KafkaProducerBuilder.KaKafkaProducerBuilder;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Producer producer = KaKafkaProducerBuilder();
        Consumer consumer = KafkaConsumerBuilder();
        User user = User.newBuilder()
                .setId("10")
                .setAge("10")
                .setAddress("Random1")
                .setBio("Biioo")
                .setFirstName("FName")
                .setLastName("Lname")
                .build();
        ProducerRecord<String, User> record
                = new ProducerRecord<>("myTopic", "myKey10", user);
        Future<RecordMetadata> result = producer.send(record);
        Thread.sleep(5000);
        System.out.println(result.get().topic());
        consumer.subscribe(Collections.singleton("myTopic"));
        ConsumerRecords<String, User> records = consumer.poll(Duration.ofSeconds(1));
        for (Iterator<ConsumerRecord<String, User>> it = records.records("myTopic").iterator(); it.hasNext(); ) {
            ConsumerRecord<String, User> i = it.next();
            System.out.println(i.key()+":"+i.value().toString());
        }
    }
}
