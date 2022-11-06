package com.example.demo.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.example.demo.repository")
public class ElasticsearchConfig {

  @Bean
  ElasticsearchClient client() {
    RestClient httpClient = RestClient.builder(
        new HttpHost("localhost", 9200)
    ).build();
    ElasticsearchTransport transport = new RestClientTransport(httpClient,
        new JacksonJsonpMapper());
    return new ElasticsearchClient(transport);
  }
}
