package br.com.automacao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class main {

	public static void main(String[] args) {

		
		System.out.println("Iniciando Busca no Wikipedia...");
		
		String pessoa = "Neymar";
		

		
		
					
				try {
					
				//	String encoding = "UTF-8";
					
					
					//Search the google for Wikipedia Links
					//Document google = Jsoup.connect("https://www.google.com/search?q=" + URLEncoder.encode("Neymar", encoding)).userAgent("Mozilla/5.0").get();
					

					//Get the first link about Wikipedia
					//String wikipediaURL = google.getElementsByTag("cite").get(0).text();
					
					//Use Wikipedia API to get JSON File
					String wikipediaApiJSON = "https://pt.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro=&explaintext=&titles="
							+ URLEncoder.encode(pessoa, "UTF-8");
					

					
					//ByteBuffer byteBuffer = StandardCharsets.UTF_8.encode(wikipediaApiJSON);
									
					
					//Let's see what it found
					System.out.println(wikipediaApiJSON);
					
					//"extract":" the summary of the article
					HttpURLConnection httpcon = (HttpURLConnection) new URL(wikipediaApiJSON).openConnection();
					httpcon.addRequestProperty("User-Agent", "Mozilla/5.0");

				
					BufferedReader in = new BufferedReader(new InputStreamReader(httpcon.getInputStream(), "UTF-8"));
					
					//Read line by line
					String responseSB = in.lines().collect(Collectors.joining());
					
	
					
					
					in.close();
					
					//Print the result for us to see
					//System.out.println(responseSB);
					String result = responseSB.split("extract\":\"")[1];
					//System.out.println(result);
					
					//Tell only the 150 first characters of the result
					String textToTell = result.length() > 250 ? result.substring(0, 250) : result;
					System.out.println(textToTell + "...");
					
					
				} catch (Exception ex) {
					ex.printStackTrace();

				}
				
			}




}
