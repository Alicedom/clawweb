package claw.web;

import claw.web.dbclawler.entity.BodyParse;
import claw.web.dbclawler.entity.Entry;
import claw.web.dbclawler.entity.EntryFilter;
import claw.web.dbclawler.entity.TextParse;
import claw.web.dbclawler.repository.BodyParseRepository;
import claw.web.dbclawler.repository.EntryFilterRepository;
import claw.web.dbclawler.repository.EntryRepository;
import claw.web.dbclawler.repository.TextParseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Map;
import java.util.TreeMap;

@SpringBootApplication
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner insert3(EntryRepository repository) {
//
//		return (args) -> {
//
//			String url = "http://doc.edu.vn/default.aspx";
//			String cssSelector = "#documents > div.box > ul > li";
//			char deliminate = '#';
//			String type = "a";
//			repository.save(new Entry(1, url, cssSelector, type, deliminate, true));
//
//			String url1 = "http://triethoc.edu.vn";
//			String cssSelector1 = "#ctl00_Default1__Body > div > div.page-wrapper.home-wrapper > div > div > ul > li > div";
//			char deliminate1 = '#';
//			String type1 = "a";
//			repository.save(new Entry(2, url1, cssSelector1, type1, deliminate1, true));
//		};
//	}
//
//	@Bean
//	public CommandLineRunner insert2( EntryFilterRepository filter) {
//
//		return (args) -> {
//
//			String include = "/tai-lieu/";
//			String exclude = "";
//			filter.save(new EntryFilter(1,include, true ));
//
//			String include1 = ".html";
//			String exclude1 = "";
//			filter.save(new EntryFilter(2, include1, true));
//		};
//	}
//
//	@Bean
//	public CommandLineRunner insert5(TextParseRepository repository) {
//		return (args) -> {
//			repository.save(new TextParse(2, "title", "#viewdoc > div.box-header.box-header-main > h1"));
//			repository.save(new TextParse(2, "date", "#ctl00_Default1__Body > div.page-wrapper.page-wrapper2 > div > div.content-wrapper > div.content-date"));
//		};
//	}
//
//	@Bean
//	public CommandLineRunner insert1(BodyParseRepository repository) {
//		return (args) -> {
//			repository.save(new BodyParse(2, "boby",1, "#ctl00_Default1__Body > div.page-wrapper.page-wrapper2 > div > div.content-wrapper > div.content-des"));
//			repository.save(new BodyParse(2, "title",-1, "#viewdoc > div.box-header.box-header-main > h1"));
//			repository.save(new BodyParse(2, "date",-1, "#ctl00_Default1__Body > div.page-wrapper.page-wrapper2 > div > div.content-wrapper > div.content-date"));
//		};
//	}
}
