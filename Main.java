public class Main {
    public static void main(String[] args) {
        Pilha<String> pilha = new Pilha<>(3); // limite de 3

        try {
            pilha.PEmpilha("A");
            pilha.PEmpilha("B");
            pilha.PEmpilha("C");

            System.out.println("Topo atual: " + pilha.topo().orElse("Nada"));
            System.out.println(pilha);

            System.out.println("Desempilhado: " + pilha.PDesempilha());
            System.out.println(pilha);

            pilha.PEmpilha("D");
            System.out.println("Após empilhar D: " + pilha);

            pilha.PEmpilha("E"); // deve lançar PilhaCheiaException

        } catch (PilhaCheiaException | PilhaVaziaException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
