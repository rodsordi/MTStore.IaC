package br.com.mt.mts.auth.infra.kafka;

import com.google.gson.Gson;
import org.apache.kafka.common.serialization.Serializer;

public class SerializerGson<T> implements Serializer<T> {

    private final Gson gson = new Gson();

    @Override
    public byte[] serialize(String s, T t) {
        return gson.toJson(t).getBytes();
    }

}
