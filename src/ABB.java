class ABB {
    private Na raiz;

    public void inserir(Palavra palavra) {
        raiz = inserirRecursivo(raiz, palavra);
    }

    private Na inserirRecursivo(Na na, Palavra palavra) {
        if (na == null) {
            return new Na(palavra);
        }
        int comparacao = palavra.getPalavra().compareTo(na.palavra.getPalavra());
        if (comparacao < 0) {
            na.esquerda = inserirRecursivo(na.esquerda, palavra);
        } else if (comparacao > 0) {
            na.direita = inserirRecursivo(na.direita, palavra);
        }
        return na;
    }

    public Palavra buscar(String palavra) {
        return buscarRecursivo(raiz, palavra);
    }

    private Palavra buscarRecursivo(Na na, String palavra) {
        if (na == null) {
            return null;
        }
        int comparacao = palavra.compareTo(na.palavra.getPalavra());
        if (comparacao < 0) {
            return buscarRecursivo(na.esquerda, palavra);
        } else if (comparacao > 0) {
            return buscarRecursivo(na.direita, palavra);
        } else {
            return na.palavra;
        }
    }

    private static class Na {
        Palavra palavra;
        Na esquerda;
        Na direita;

        Na(Palavra palavra) {
            this.palavra = palavra;
        }
    }
}
