package com.poc.paymentservice.listener;


import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * The type Payment listener.
 */
@Component
@AllArgsConstructor
public class PaymentListener {

  public static final String TOPIC_NAME = "payment-topic";
  public static final String GROUP_ID = "product-service";
  private static final Logger log = LoggerFactory.getLogger(PaymentListener.class);


  /**
   * Consume.
   *
   * @param paymentId the payment id
   */
  @KafkaListener(topics = TOPIC_NAME, groupId = GROUP_ID)
  public void consume(String paymentId) {
    log.info("Payment Id received: {}", paymentId);
  }

}