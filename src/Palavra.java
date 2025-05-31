import java.util.List;

class Palavra {
    private String palavra;
    private ListaOcorrencias ocorrencias;

    public Palavra(String palavra) {
        this.palavra = palavra;
        this.ocorrencias = new ListaOcorrencias();
    }

    public String getPalavra() {
        return palavra;
    }

    public void adicionarOcorrencia(int linha) {
        ocorrencias.adicionar(linha);
    }

    public List<Integer> getOcorrencias() {
        return ocorrencias.getOcorrencias();
    }
}
