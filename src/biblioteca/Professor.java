package biblioteca;

public final class Professor extends Usuario {

    public Professor(String nome) {
        super(nome);
    }

    @Override
    public int getLimiteItens() {
        return 5;
    }
}