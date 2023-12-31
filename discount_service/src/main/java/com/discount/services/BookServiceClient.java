package com.discount.services;

import java.util.List;

import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.discount.model.BookInfo;

import reactor.core.publisher.Mono;

@Service
public class BookServiceClient {

	private final HttpGraphQlClient graphQlClient;

	public BookServiceClient() {
		// TODO Auto-generated constructor stub
		WebClient webClient = WebClient.builder().baseUrl("http://localhost:8085/graphql").build();
		graphQlClient = HttpGraphQlClient.builder(webClient).build();
	}

	public Mono<List<BookInfo>> getAllBooks() {
	        //language=GraphQL
	        String document = """
	       query AllBookEntitiy {
    allBookEntitiy {
       title
       price 
    }
}
	        """;

	        Mono<List<BookInfo>> books = graphQlClient.document(document)
	                .retrieve("allBookEntitiy")
	                .toEntityList(BookInfo.class);

	        return books;
}
	
}
