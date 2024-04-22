package com.idaroos.theglobalnewsarchive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SvenskanyhetsarkivetApplication {

	public static void main(String[] args) {
		SpringApplication.run(SvenskanyhetsarkivetApplication.class, args);
	}

}
