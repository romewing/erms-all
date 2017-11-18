package com.xblltech.erms;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KafkaListener {

    @Autowired
    private TransportClient transportClient;

    @org.springframework.kafka.annotation.KafkaListener(topics = "scrapy")
    public void listen(String message) {
        IndexResponse indexResponse = transportClient.prepareIndex("bid", "sprecc").setSource(message, XContentType.JSON).get();
        System.out.println(indexResponse);
    }
}
