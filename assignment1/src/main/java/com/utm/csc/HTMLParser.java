package com.utm.csc;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HTMLParser {
	
	
	public static void parseHTML(String url_page) throws IOException{
		
		System.out.println("URL : " + url_page);
		Document doc = Jsoup.connect(url_page).get();

		
		String page_title = doc.title();
		System.out.println("title : " + page_title);
		System.out.println("");
	
		Elements links = doc.getElementsByTag("a");
		Integer count_line = 0;
		for (Element link : links) {

		  String actualLink = link.attr("href");
		  String linkText = link.text();
		  if (actualLink != ""){
			  count_line = count_line + 1;
			  System.out.println("link : " + actualLink);
			  System.out.println("text : " + linkText);
			  System.out.println("");
		  }
		}
		System.out.println("Link Count : " + count_line);
		
	}

	public static void main(String[] args) throws IOException {
		
		
		for(int i=0; i<args.length; i++){
			String url_page = args[i];
			System.out.println("");
			parseHTML(url_page);
		}
		/*
		System.out.println(url_page + " testing dis shit");
		Document doc = Jsoup.connect(url_page).get();

		
		String page_title = doc.title();
		System.out.println("title : " + page_title);
		System.out.println("");
		
		//Element content = doc.getElementById("content");
		Elements links = doc.getElementsByTag("a");
		Integer count_line = 0;
		for (Element link : links) {

		  String actualLink = link.attr("href");
		  String linkText = link.text();
		  if (actualLink != ""){
			  count_line = count_line + 1;
			  System.out.println("link : " + actualLink);
			  System.out.println("text : " + linkText);
			  System.out.println("");
		  }
		}
		System.out.println(count_line);*/
	}
}
