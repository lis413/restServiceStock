package ru.lis154.restServiceStock.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.stereotype.Component;

@Component
public class KafkaTemplate2<V,K> extends KafkaTemplate<V,K> {
    public KafkaTemplate2(ProducerFactory producerFactory) {
        super(producerFactory);
    }
}
