package br.com.mt.mts.auth.infra.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import java.util.regex.Pattern;

@Slf4j
public abstract class KafkaListener<T> {
    private final KafkaConsumer<String, T> kafkaConsumer = new KafkaConsumer<>(properties());

    public KafkaListener(Topic topic) {
        kafkaConsumer.subscribe(Collections.singletonList(topic.name()));
    }

    public KafkaListener(Pattern pattern) {
        kafkaConsumer.subscribe(pattern);
    }

    protected abstract Class<T> getType();

    public void listen() {
        while (true) {
            var records = kafkaConsumer.poll(Duration.ofMillis(100));
            if (!records.isEmpty()) {
                log.info("Encontrado {} registros", records.count());
                for (var record : records) {
                    log.info("#################################");
                    log.info("Processando");
                    log.info("Record Key: {}", record.key());
                    log.info("Record Value: {}", record.value());
                }
            }
        }
    }

    protected Map<String, String> overrideProperties() {
        return Map.of();
    }

    private Properties properties() {
        var properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, DeserializerGson.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, getClass().getSimpleName() + "_" + UUID.randomUUID());
        properties.setProperty(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "1");
        properties.setProperty(DeserializerGson.TYPE_CONFIG, getType().getName());
        properties.putAll(overrideProperties());
        return properties;
    }
}
