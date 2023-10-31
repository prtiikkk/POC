package com.poc.productservice.service;


import java.util.Random;
import java.util.function.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

  public static final String TOPIC_NAME = "payment-topic";
  private static final Logger log = LoggerFactory.getLogger(PaymentService.class);
  Supplier<String> paymentIdGenerator = () -> {
    Random random = new Random();
    return String.valueOf(100000 + random.nextInt(900000));
  };
  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  public String sendPaymentId() {
    String paymentId = paymentIdGenerator.get();
    kafkaTemplate.send(TOPIC_NAME, paymentId);
    log.info("Inside Payment Service:: PaymentId {} published to Kafka successfully!",
        paymentId);
    return paymentId;
  }

}