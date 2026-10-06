package biblioteca;

public final class Main {

    private Main() {
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        Aluno aluno = new Aluno("Ana");
        Professor professor = new Professor("Carlos");

        ItemBiblioteca livro1 = new Livro("L001", "Clean Code");
        ItemBiblioteca livro2 = new Livro("L002", "Java Efetivo");
        ItemBiblioteca revista1 = new Revista("R001", "Java Magazine");
        ItemBiblioteca revista2 = new Revista("R002", "Tecnologia Hoje");

        biblioteca.cadastrarItem(livro1);
        biblioteca.cadastrarItem(livro2);
        biblioteca.cadastrarItem(revista1);
        biblioteca.cadastrarItem(revista2);

        System.out.println(
                "Empréstimo 1: "
                        + biblioteca.emprestar(livro1, aluno)
        );

        System.out.println(
                "Empréstimo 2: "
                        + biblioteca.emprestar(livro2, aluno)
        );

        System.out.println(
                "Empréstimo 3: "
                        + biblioteca.emprestar(revista1, aluno)
        );

        System.out.println(
                "Empréstimo recusado por limite: "
                        + !biblioteca.emprestar(revista2, aluno)
        );

        System.out.println(
                "Empréstimo professor: "
                        + biblioteca.emprestar(revista2, professor)
        );

        biblioteca.listarAcervo();
    }
}
