package org.example;

import Data.User;
import org.example.kafka.service.KafkaService;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        KafkaService service = new KafkaService();
        service.subscribe();
//        service.sendMessage(User.newBuilder()
//                .setId("10")
//                .setAge("10")
//                .setAddress("Random1")
//                .setBio("Biioo")
//                .setFirstName("FName")
//                .setLastName("Lname")
//                .build())
    }
}
