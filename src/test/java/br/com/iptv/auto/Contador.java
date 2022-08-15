package br.com.iptv.auto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Contador {

	public static class ArquivoContador {

		public String salvarContador(String cpf) {

			try {
				FileWriter fw = new FileWriter("cpf.txt");
				PrintWriter pw = new PrintWriter(fw);

				pw.println(cpf);
				pw.flush();
				pw.close();
				fw.close();

			} catch (IOException ex) {

// Logger.getLogger(Cliente)

			}
			return "Salvo cpf no arquivo com sucesso";

		}

		public static String lerContador() {

			String conteudo = "";

			try {

				FileReader arq = new FileReader("cpf.txt");
				BufferedReader lerarq = new BufferedReader(arq);
				String linha = "";

				try {

					linha = lerarq.readLine();
					while (linha != null) {
						conteudo += linha;
						linha = lerarq.readLine();

					}
					arq.close();

				} catch (IOException ex) {
					conteudo = "Erro: Não foi possivel ler o arquivo";
				}

			} catch (FileNotFoundException ex) {
				conteudo = "Erro: Arquivo não enontrado";
			}

			if (conteudo.contains("Erro")) {

				return "";

			} else {
				return conteudo;

			}

		}

	}

}
