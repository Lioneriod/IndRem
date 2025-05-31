import java.util.ArrayList;
import java.util.List;

class ListaOcorrencias {
    private Na cabeca;
    private Na cauda;

    public void adicionar(int linha) {
        if (cauda == null) {
            cabeca = new Na(linha);
            cauda = cabeca;
        } else {
            if (cauda.linha < linha) {
                cauda.proximo = new Na(linha);
                cauda = cauda.proximo;
            }
        }
    }

    public List<Integer> getOcorrencias() {
        List<Integer> lista = new ArrayList<>();
        Na atual = cabeca;
        while (atual != null) {
            lista.add(atual.linha);
            atual = atual.proximo;
        }
        return lista;
    }

    private static class Na {
        int linha;
        Na proximo;

        Na(int linha) {
            this.linha = linha;
        }
    }
}
