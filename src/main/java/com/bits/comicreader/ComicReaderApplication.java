package com.bits.comicreader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ComicReaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComicReaderApplication.class, args);
	}

}
