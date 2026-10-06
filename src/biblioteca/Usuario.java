package biblioteca;

public abstract class Usuario {
    private final String nome;
    private int quantidadeEmprestada;

    protected Usuario(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome obrigatório.");
        }

        this.nome = nome;
    }

    public final String getNome() {
        return nome;
    }

    public final int getQuantidadeEmprestada() {
        return quantidadeEmprestada;
    }

    public abstract int getLimiteItens();

    final void adicionarEmprestimo() {
        quantidadeEmprestada++;
    }

    final void removerEmprestimo() {
        if (quantidadeEmprestada > 0) {
            quantidadeEmprestada--;
        }
    }
}
