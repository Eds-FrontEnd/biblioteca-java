package biblioteca;

public final class Biblioteca {
    private static final int CAPACIDADE = 10;

    private final ItemBiblioteca[] acervo = new ItemBiblioteca[CAPACIDADE];

    public boolean cadastrarItem(ItemBiblioteca item) {
        if (item == null) {
            return false;
        }

        for (int i = 0; i < acervo.length; i++) {
            if (acervo[i] == null) {
                acervo[i] = item;
                return true;
            }
        }

        return false;
    }

    public boolean emprestar(ItemBiblioteca item, Usuario usuario) {
        if (item == null
                || usuario == null
                || !item.isDisponivel()
                || usuario.getQuantidadeEmprestada() >= usuario.getLimiteItens()) {
            return false;
        }

        item.marcarEmprestado();
        usuario.adicionarEmprestimo();

        return true;
    }

    public boolean devolver(ItemBiblioteca item, Usuario usuario) {
        if (item == null
                || usuario == null
                || item.isDisponivel()
                || usuario.getQuantidadeEmprestada() == 0) {
            return false;
        }

        item.marcarDisponivel();
        usuario.removerEmprestimo();

        return true;
    }

    public void listarAcervo() {
        for (ItemBiblioteca item : acervo) {
            if (item != null) {
                System.out.println(item);
            }
        }
    }
}