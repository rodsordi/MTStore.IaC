package br.com.mt.mts.auth.infra.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.Closeable;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

@Slf4j
public abstract class KafkaDispatcher<T> implements Closeable {
    private final Topic topic;

    private KafkaProducer kafkaProducer;
    private Callback callback;

    protected abstract String getChave(T t);

    public KafkaDispatcher(Topic topic) {
        this.topic = topic;
        kafkaProducer = new KafkaProducer<String, String>(properties());
        callback = (data, e) -> {
            if (e != null) {
                log.error(e.getMessage(), e);
                return;
            }
            log.info("Enviada msg topico: {}, partition: {}, offset: {}",
                    data.topic(),
                    data.partition(),
                    data.offset());
        };
    }

    public void enviar(T mensagem) throws ExecutionException, InterruptedException {
        kafkaProducer.send(new ProducerRecord<>(topic.name(), getChave(mensagem), mensagem), callback).get();
    }

    private Properties properties() {
        var properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, SerializerGson.class.getName());
        return properties;
    }

    @Override
    public void close() {
        kafkaProducer.close();
    }

}
