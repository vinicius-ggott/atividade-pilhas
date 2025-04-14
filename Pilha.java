import java.util.Optional;

/**
 * Implementação genérica de uma Pilha (TAD Pilha).
 * Suporta operações básicas e possui limite opcional de capacidade.
 *
 * @param <T> Tipo dos elementos armazenados na pilha
 */
public class Pilha<T> {

    private static class No<T> {
        T dado;
        No<T> proximo;

        No(T dado) {
            this.dado = dado;
            this.proximo = null;
        }
    }

    private No<T> topo;
    private int tamanho;
    private final int capacidadeMaxima;

    /**
     * Construtor para pilha sem limite de capacidade.
     */
    public Pilha() {
        this.capacidadeMaxima = -1; // -1 significa sem limite
        FPVazia();
    }

    /**
     * Construtor com limite de capacidade.
     * @param capacidadeMaxima Número máximo de elementos permitidos
     */
    public Pilha(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
        FPVazia();
    }

    /**
     * Faz a pilha ficar vazia.
     */
    public void FPVazia() {
        topo = null;
        tamanho = 0;
    }

    /**
     * Verifica se a pilha está vazia.
     * @return true se vazia, false caso contrário
     */
    public boolean PEhVazia() {
        return topo == null;
    }

    /**
     * Insere um item no topo da pilha.
     * @param elemento Elemento a ser inserido
     * @throws PilhaCheiaException Se a pilha estiver no limite de capacidade
     */
    public void PEmpilha(T elemento) {
        if (capacidadeMaxima != -1 && tamanho >= capacidadeMaxima) {
            throw new PilhaCheiaException("Capacidade máxima atingida.");
        }
        No<T> novo = new No<>(elemento);
        novo.proximo = topo;
        topo = novo;
        tamanho++;
    }

    /**
     * Remove e retorna o item do topo da pilha.
     * @return Elemento removido
     * @throws PilhaVaziaException Se a pilha estiver vazia
     */
    public T PDesempilha() {
        if (PEhVazia()) {
            throw new PilhaVaziaException("Pilha vazia. Não é possível desempilhar.");
        }
        T elemento = topo.dado;
        topo = topo.proximo;
        tamanho--;
        return elemento;
    }

    /**
     * Retorna o número de itens na pilha.
     * @return Quantidade de elementos
     */
    public int PTamanho() {
        return tamanho;
    }

    /**
     * Retorna o elemento no topo da pilha sem removê-lo.
     * @return Um Optional com o topo, ou vazio se pilha estiver vazia
     */
    public Optional<T> topo() {
        return PEhVazia() ? Optional.empty() : Optional.of(topo.dado);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Pilha: [");
        No<T> atual = topo;
        while (atual != null) {
            sb.append(atual.dado);
            if (atual.proximo != null) sb.append(", ");
            atual = atual.proximo;
        }
        sb.append("]");
        return sb.toString();
    }
}
