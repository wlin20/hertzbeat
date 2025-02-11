package org.dromara.hertzbeat.common.serialize;

import org.dromara.hertzbeat.common.entity.alerter.Alert;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;
import org.dromara.hertzbeat.common.util.JsonUtil;

import java.util.Map;

/**
 * kafka告警记录反序列化类
 * @author tablerow
 */
public class AlertDeserializer implements Deserializer {
    @Override
    public void configure(Map configs, boolean isKey) {
        Deserializer.super.configure(configs, isKey);
    }

    @Override
    public Object deserialize(String s, byte[] bytes) {
        return JsonUtil.fromJson(new String(bytes), Alert.class);
    }

    @Override
    public Object deserialize(String topic, Headers headers, byte[] data) {
        return Deserializer.super.deserialize(topic, headers, data);
    }

    @Override
    public void close() {
        Deserializer.super.close();
    }
}
