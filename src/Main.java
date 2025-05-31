import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        TabelaHash tabelaHash = new TabelaHash();

        try (BufferedReader leitorTexto = new BufferedReader(new FileReader("input.txt"))) {
            String linha;
            int numeroLinha = 0;
            while ((linha = leitorTexto.readLine()) != null) {
                numeroLinha++;
                String[] palavras = linha.split("\\s+");
                for (String palavra : palavras) {
                    String palavraProcessada = processarPalavra(palavra);
                    if (!palavraProcessada.isEmpty()) {
                        tabelaHash.inserirPalavra(palavraProcessada, numeroLinha);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> palavrasChave = new ArrayList<>();
        try (BufferedReader leitorChaves = new BufferedReader(new FileReader("palavras-chave.txt"))) {
            String linha;
            while ((linha = leitorChaves.readLine()) != null) {
                String[] partes = linha.split(",\\s*");
                for (String parte : partes) {
                    palavrasChave.add(parte.trim().toLowerCase());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(palavrasChave);

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter("output.txt"))) {
            for (String chave : palavrasChave) {
                Palavra palavra = tabelaHash.buscarPalavra(chave);
                if (palavra == null) continue;
                List<Integer> ocorrencias = palavra.getOcorrencias();
                if (ocorrencias.isEmpty()) continue;
                escritor.write(chave);
                for (int linha : ocorrencias) {
                    escritor.write(" " + linha);
                }
                escritor.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String processarPalavra(String palavra) {
        return palavra.replaceAll("^[^a-zA-Z0-9-]+", "")
                    .replaceAll("[^a-zA-Z0-9-]+$", "")
                    .toLowerCase();
    }
}