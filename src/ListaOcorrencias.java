import java.util.ArrayList;
import java.util.List;

class ListaOcorrencias {
    private No inicio;
    private No fim;

    public void adicionar(int linha) {
        if (fim == null) {
            inicio = new No(linha);
            fim = inicio;
        } else {
            if (fim.linha < linha) {
                fim.proximo = new No(linha);
                fim = fim.proximo;
            }
        }
    }

    public List<Integer> getOcorrencias() {
        List<Integer> lista = new ArrayList<>();
        No atual = inicio;
        while (atual != null) {
            lista.add(atual.linha);
            atual = atual.proximo;
        }
        return lista;
    }

    private static class No {
        int linha;
        No proximo;

        No(int linha) {
            this.linha = linha;
        }
    }
}
