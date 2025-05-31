class TabelaHash {
    private static final int TAMANHO = 26;
    private ABB[] tabela;

    public TabelaHash() {
        tabela = new ABB[TAMANHO];
        for (int i = 0; i < TAMANHO; i++) {
            tabela[i] = new ABB();
        }
    }

    private int calcularIndice(char c) {
        if (c >= 'a' && c <= 'z') {
            return c - 'a';
        }
        return -1;
    }

    public void inserirPalavra(String palavra, int linha) {
        if (palavra.isEmpty()) return;
        char primeiraLetra = palavra.charAt(0);
        int indice = calcularIndice(primeiraLetra);
        if (indice == -1) return;
        ABB abb = tabela[indice];
        Palavra palavraExistente = abb.buscar(palavra);
        if (palavraExistente != null) {
            palavraExistente.adicionarOcorrencia(linha);
        } else {
            Palavra novaPalavra = new Palavra(palavra);
            novaPalavra.adicionarOcorrencia(linha);
            abb.inserir(novaPalavra);
        }
    }

    public Palavra buscarPalavra(String palavra) {
        if (palavra.isEmpty()) return null;
        char primeiraLetra = palavra.charAt(0);
        int indice = calcularIndice(primeiraLetra);
        if (indice == -1) return null;
        return tabela[indice].buscar(palavra);
    }
}
