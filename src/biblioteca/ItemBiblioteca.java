package biblioteca;

public abstract class ItemBiblioteca {
    private final String codigo;
    private final String titulo;
    private boolean disponivel;

    protected ItemBiblioteca(String codigo, String titulo) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("Código obrigatório.");
        }

        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Título obrigatório.");
        }

        this.codigo = codigo;
        this.titulo = titulo;
        this.disponivel = true;
    }

    public final String getCodigo() {
        return codigo;
    }

    public final String getTitulo() {
        return titulo;
    }

    public final boolean isDisponivel() {
        return disponivel;
    }

    public abstract int getPrazoDias();

    public abstract double getMultaPorDia();

    final void marcarEmprestado() {
        disponivel = false;
    }

    final void marcarDisponivel() {
        disponivel = true;
    }

    @Override
    public String toString() {
        return codigo
                + " | "
                + titulo
                + " | disponível: "
                + (disponivel ? "sim" : "não")
                + " | prazo: "
                + getPrazoDias()
                + " dias | multa: R$ "
                + String.format("%.2f", getMultaPorDia());
    }
}