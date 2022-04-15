package br.com.automacao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.stream.Collectors;

import br.com.automacao.utils.Utils;

public class main {

	static Utils utils = new Utils();
	
	public static void main(String[] args) {

		
		System.out.println("Iniciando Busca no Wikipedia...");
		
		String pessoa = "Neymar";
		
					
				try {
					
					String urlWikipediaSearch = "https://pt.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro=&explaintext=&titles=" + URLEncoder.encode(pessoa, "UTF-8");
					
					System.out.println("\n" + urlWikipediaSearch);
					
					HttpURLConnection httpcon = (HttpURLConnection) new URL(urlWikipediaSearch).openConnection();
					BufferedReader in = new BufferedReader(new InputStreamReader(httpcon.getInputStream(), "UTF-8"));
					String responseSB = in.lines().collect(Collectors.joining());
					in.close();
					
					String resultadoDaBusca = responseSB.split("extract\":\"")[1];

					resultadoDaBusca = utils.ajusteAcentuacao(resultadoDaBusca);
					resultadoDaBusca = utils.limparCaracteresEspeciais(resultadoDaBusca);
					

					System.out.println("\n" + resultadoDaBusca);
					
				
					
				} catch (Exception ex) {
					ex.printStackTrace();

				}
				
			}




}
