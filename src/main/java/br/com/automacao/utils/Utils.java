package br.com.automacao.utils;

public class Utils {
	
	public String ajusteAcentuacao(String texto) {

		    int index;
		    index = texto.indexOf("\\u");
		    while(index > -1)
		    {
		        int length = texto.length();
		        if(index > (length-6))break;
		        int numStart = index + 2;
		        int numFinish = numStart + 4;
		        String substring = texto.substring(numStart, numFinish);
		        int number = Integer.parseInt(substring,16);
		        String stringStart = texto.substring(0, index);
		        String stringEnd   = texto.substring(numFinish);
		        texto = stringStart + ((char)number) + stringEnd;
		        index = texto.indexOf("\\u");
		    }
		
		return texto;
	}
	
	public String limparCaracteresEspeciais(String texto) {
		
		texto.replace("{", "")
				.replace("}", "");
		
		return texto;
		
	}
	
	public String limitarQuantidadeDeCaracteres(String texto, int qtd) {
		
		//Tell only the 150 first characters of the result
		String textToTell = texto.length() > 250 ? texto.substring(0, 250) : texto;
		System.out.println(textToTell + "...");
		
		return textToTell;
		
	}

}
