package com.cloud.producer;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class KafkaProducer {
    private KafkaTemplate<String, String> template;

    public KafkaProducer(KafkaTemplate<String, String> template) {
        this.template = template;
    }

    private ListenableFutureCallback<SendResult<String, String>> callback = new ListenableFutureCallback<SendResult<String, String>>() {
        @Override
        public void onFailure(Throwable ex) {
            System.out.println("#########something wrong");
        }

        @Override
        public void onSuccess(SendResult<String, String> result) {
            System.out.println("#############success");
        }
    };

    @EventListener(ApplicationReadyEvent.class)
    public void sendMessage() {
        System.out.println("###########start to sending message");
        ListenableFuture<SendResult<String, String>> future = template.send("myTopic", "test");
        future.addCallback(callback);
    }
}
