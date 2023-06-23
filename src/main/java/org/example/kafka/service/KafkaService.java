package org.example.kafka.service;

import Data.User;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.example.config.PropertiesLoader;

import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.*;

import static org.example.kafka.builder.KafkaProducerBuilder.KaKafkaProducerBuilder;
import static org.example.kafka.builder.KafkaConsumerBuilder.KafkaConsumerBuilder;


public class KafkaService {
    private String kafkaTopicName;
    private String kafkaDefaultKey;
    private static Producer producer = KaKafkaProducerBuilder();
    private static Consumer consumer = KafkaConsumerBuilder();
    private static ExecutorService executorService = Executors.newCachedThreadPool();
    public KafkaService() throws IOException {
        kafkaTopicName = PropertiesLoader.loadProperties().getProperty("kafka.topic.name");
        kafkaDefaultKey = PropertiesLoader.loadProperties().getProperty("kafka.default.key");
    }
    public Future<RecordMetadata> sendMessage(User user){
        return producer.send(
                new ProducerRecord<>(kafkaTopicName, kafkaDefaultKey, user)
        );
    }
    public void subscribe() {
        consumer.subscribe(Collections.singleton(kafkaTopicName));
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                while(true){
                    ConsumerRecords records = consumer.poll(Duration.ofSeconds(1));
                    for (Iterator<ConsumerRecord<String, User>> it = records.records(kafkaTopicName).iterator(); it.hasNext(); ) {
                        ConsumerRecord<String, User> i = it.next();
                        System.out.println(i.key()+":"+i.value().toString());
                    }
                    consumer.commitSync();
                }
            }
        });
    }
}
