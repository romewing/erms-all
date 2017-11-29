package com.xblltech.erms;


import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.document.DocumentField;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

@SpringBootApplication
@EnableKafka
public class ESApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ESApplication.class);
        TransportClient transportClient = context.getBean(TransportClient.class);
        SearchResponse searchResponse = transportClient.prepareSearch("bid").setTypes("sprecc").setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.termQuery("name", "川"))                 // Query
                .setFrom(0).setSize(60).setExplain(true)
                .get();
        System.out.println(searchResponse.getHits().totalHits+"===");
        for (SearchHit hit : searchResponse.getHits().getHits()) {
        }

    }


    @Bean
    TransportClient transportClient() {
        Settings settings = Settings.builder()
                .put("client.transport.sniff", true).build();
        TransportClient client = null;
        try {
            client = new PreBuiltTransportClient(settings)
                    .addTransportAddress(new TransportAddress(InetAddress.getByName("27.126.176.168"), 9300));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return client;
    }
}
