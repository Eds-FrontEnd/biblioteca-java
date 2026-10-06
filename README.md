# 📚 Projeto - Biblioteca

## 🚀 Sobre o projeto

Bem-vindo ao **Projeto Biblioteca**, uma aplicação desenvolvida em **Java** com foco no aprendizado e aplicação dos principais conceitos da programação orientada a objetos.

O projeto simula o funcionamento básico de uma biblioteca, permitindo o cadastro de itens do acervo, gerenciamento de usuários e controle de empréstimos.

A aplicação foi desenvolvida com foco em **orientação a objetos, encapsulamento, herança, polimorfismo, organização do código, separação de responsabilidades e boas práticas de desenvolvimento Java**.

Além da aplicação Java, o projeto possui um script **SQL** responsável pela criação da estrutura do banco de dados, inserção de dados iniciais e execução de consultas para análise das informações.

---

# 📋 Pré-requisitos

Antes de executar o projeto, certifique-se de possuir instalado:

- **Java JDK 21**
- **IntelliJ IDEA**
- **PostgreSQL** para execução do script SQL

---

# 🌍 Demonstração

O projeto foi desenvolvido para execução local e fins de estudo e avaliação.

Não possui demonstração online.

---

# 🚀 Como executar o projeto

### 1. Clone o repositório

```bash
git clone https://github.com/Eds-FrontEnd/projeto-biblioteca
```

### 2. Acesse a pasta

```bash
cd projeto-biblioteca
```

### 3. Abra o projeto no IntelliJ IDEA

Abra a pasta do projeto no **IntelliJ IDEA**.

Certifique-se de que o projeto esteja configurado para utilizar o **Java 21**.

---

## ▶️ Executando o projeto

Localize a classe:

```text
src/biblioteca/Main.java
```

Execute o método:

```java
public static void main(String[] args)
```

No IntelliJ IDEA, clique no botão **▶ Run** ao lado do método `main`.

A aplicação será executada diretamente no console.

---

# 🛠 Tecnologias utilizadas

- Java 21
- IntelliJ IDEA
- SQL
- PostgreSQL
- Git
- GitHub

---

# ✨ Recursos utilizados

O projeto foi desenvolvido utilizando conceitos fundamentais do ecossistema Java.

- Programação Orientada a Objetos
- Classes
- Objetos
- Encapsulamento
- Herança
- Polimorfismo
- Classes abstratas
- Métodos
- Construtores
- Modificadores de acesso
- `ArrayList`
- `List`
- Streams
- `filter`
- `count`
- `contains`
- SQL
- Chaves primárias
- Chaves estrangeiras
- Constraints
- `CHECK`
- `JOIN`
- `GROUP BY`
- `ORDER BY`
- `LEFT JOIN`
- `COALESCE`

---

# 📚 Funcionalidades

O projeto possui funcionalidades relacionadas ao gerenciamento de uma biblioteca.

- Cadastro de itens
- Cadastro de usuários
- Cadastro de alunos
- Cadastro de professores
- Cadastro de livros
- Cadastro de revistas
- Controle de disponibilidade dos itens
- Empréstimo de itens
- Controle de limite de empréstimos
- Identificação do tipo de usuário
- Listagem do acervo
- Controle de empréstimos
- Controle de devoluções
- Controle de multas
- Consultas SQL
- Relacionamento entre usuários, itens e empréstimos

---

# 👤 Usuários

O sistema possui diferentes tipos de usuários.

```text
Usuário

│
├── Aluno
│
└── Professor
```

Cada tipo de usuário possui um limite específico para empréstimos.

### Aluno

```text
Aluno
│
└── Limite: 3 itens
```

### Professor

```text
Professor
│
└── Limite: 5 itens
```

O limite é utilizado para controlar a quantidade de itens que cada usuário pode possuir emprestados.

---

# 📖 Itens da Biblioteca

O acervo é composto por diferentes tipos de itens.

```text
ItemBiblioteca

│
├── Livro
│
└── Revista
```

A classe `ItemBiblioteca` funciona como uma classe abstrata para representar os itens disponíveis no acervo.

---

# 📕 Livros

Os livros possuem informações como:

- Código
- Título
- Autor
- Edição
- Disponibilidade

Exemplo:

```text
Livro

├── Código: L001
├── Título: Clean Code
├── Autor: Robert C. Martin
├── Edição: 1
└── Disponível: Não
```

---

# 📰 Revistas

As revistas também fazem parte do acervo.

Exemplo:

```text
Revista

├── Código: R001
├── Título: Java Magazine
├── Edição: 120
└── Disponível: Sim
```

---

# 📦 Empréstimos

O sistema permite realizar empréstimos de itens cadastrados no acervo.

Fluxo:

```text
Usuário

   ↓

Seleciona um item

   ↓

Verifica disponibilidade

   ↓

Verifica limite de empréstimos

   ↓

Realiza empréstimo

   ↓

Item fica indisponível
```

O sistema impede o empréstimo quando:

- O item não está cadastrado.
- O item já está emprestado.
- O usuário atingiu o limite de empréstimos.

---

# 🔄 Devolução

Quando um item é devolvido, o sistema registra a data da devolução e o item pode voltar a ficar disponível para novos empréstimos.

Estrutura:

```text
Empréstimo

│
├── Data de retirada
├── Data de devolução prevista
├── Data de devolução
└── Valor da multa
```

---

# 💰 Controle de multas

O banco de dados possui controle de multas relacionadas aos empréstimos.

A multa é armazenada utilizando:

```sql
NUMERIC(10, 2)
```

O valor não pode ser negativo.

```text
Valor da multa >= 0
```

Também existe uma consulta SQL responsável por calcular o total de multas por usuário.

---

# 🗄️ Banco de dados

O projeto possui um script SQL localizado em:

```text
sql/database.sql
```

O arquivo contém toda a estrutura necessária para criação e inicialização do banco de dados.

Estrutura:

```text
Banco de dados

│
├── item
│
├── usuario
│
└── emprestimo
```

---

# 🧱 Estrutura das tabelas

### Item

A tabela `item` armazena os itens disponíveis no acervo.

Principais campos:

```text
item

├── id
├── codigo
├── titulo
├── tipo
├── autor
├── edicao
└── disponivel
```

---

### Usuário

A tabela `usuario` armazena os usuários da biblioteca.

```text
usuario

├── id
├── nome
├── tipo
└── limite_itens
```

---

### Empréstimo

A tabela `emprestimo` registra os empréstimos realizados.

```text
emprestimo

├── id
├── item_id
├── usuario_id
├── data_retirada
├── data_devolucao_prevista
├── data_devolucao
└── valor_multa
```

---

# 🔗 Relacionamentos

A tabela `emprestimo` possui relacionamento com `item` e `usuario`.

```text
usuario
   │
   │ 1:N
   ↓
emprestimo
   ↑
   │ N:1
   │
item
```

Um usuário pode possuir vários empréstimos.

Um item pode aparecer em diferentes registros de empréstimo ao longo do tempo.

---

# 🛡️ Constraints

O banco de dados utiliza constraints para garantir a integridade das informações.

Entre elas:

- `PRIMARY KEY`
- `FOREIGN KEY`
- `UNIQUE`
- `NOT NULL`
- `CHECK`
- `DEFAULT`

Exemplo:

```sql
CONSTRAINT ck_item_tipo
    CHECK (tipo IN ('LIVRO', 'REVISTA'))
```

Essa regra impede o cadastro de tipos de itens diferentes dos permitidos.

---

# 🔎 Consultas SQL

O arquivo `database.sql` também contém consultas para análise dos dados.

Entre elas:

### Listagem do acervo

```sql
SELECT
    codigo,
    titulo,
    tipo,
    disponivel
FROM item
ORDER BY id;
```

### Empréstimos em aberto

A consulta apresenta os empréstimos que ainda não possuem data de devolução.

### Total de multas

A consulta utiliza `COALESCE` e `SUM` para calcular o total de multas de cada usuário.

### Itens nunca emprestados

A consulta utiliza `LEFT JOIN` para identificar itens que ainda não possuem registros de empréstimo.

---

# 🧩 Programação Orientada a Objetos

O projeto aplica conceitos fundamentais de **POO**.

### Encapsulamento

Os atributos das classes são protegidos utilizando modificadores de acesso.

Exemplo:

```java
private final String nome;
```

O acesso aos dados é realizado por métodos específicos.

---

### Herança

A classe `Aluno` e a classe `Professor` herdam características da classe `Usuario`.

```text
Usuario
   │
   ├── Aluno
   │
   └── Professor
```

Da mesma forma:

```text
ItemBiblioteca
   │
   ├── Livro
   │
   └── Revista
```

---

### Polimorfismo

O projeto utiliza referências de classes abstratas para trabalhar com diferentes tipos de objetos.

Exemplo:

```java
ItemBiblioteca livro = new Livro(
        "L001",
        "Clean Code"
);
```

Dessa forma, diferentes tipos de itens podem ser tratados através da mesma abstração.

---

### Abstração

As classes `Usuario` e `ItemBiblioteca` representam conceitos gerais do domínio da aplicação.

```text
Usuario
├── Aluno
└── Professor
```

```text
ItemBiblioteca
├── Livro
└── Revista
```

---

# 📁 Organização do projeto

```text
projeto-biblioteca

│
├── src
│   │
│   └── biblioteca
│       │
│       ├── Main.java
│       ├── Biblioteca.java
│       ├── Usuario.java
│       ├── Aluno.java
│       ├── Professor.java
│       ├── ItemBiblioteca.java
│       ├── Livro.java
│       └── Revista.java
│
├── sql
│   └── database.sql
│
├── README.md
│
└── .gitignore
```

---

# 📦 Estrutura das classes

```text
biblioteca

│
├── Main
│
├── Biblioteca
│
├── Usuario
│   │
│   ├── Aluno
│   └── Professor
│
└── ItemBiblioteca
    │
    ├── Livro
    └── Revista
```

---

# 🧪 Execução e validação

A classe `Main` realiza uma sequência de operações para validar as principais regras da aplicação.

Fluxo de exemplo:

```text
① Criação da biblioteca

        ↓

② Criação do aluno

        ↓

③ Criação do professor

        ↓

④ Criação dos livros

        ↓

⑤ Criação das revistas

        ↓

⑥ Cadastro dos itens

        ↓

⑦ Empréstimos para o aluno

        ↓

⑧ Validação do limite de empréstimos

        ↓

⑨ Empréstimo para o professor

        ↓

⑩ Listagem do acervo
```

---

# 📊 Exemplo de execução

O programa realiza empréstimos utilizando:

```text
Ana
├── Clean Code
├── Java Efetivo
└── Java Magazine
```

Ao atingir o limite de três empréstimos, uma nova tentativa de empréstimo é recusada.

Posteriormente, o professor `Carlos` consegue realizar o empréstimo respeitando seu limite de cinco itens.

---

# 🎯 Regras de negócio

O projeto possui regras básicas para controle dos empréstimos.

### Aluno

```text
Limite máximo: 3 itens
```

### Professor

```text
Limite máximo: 5 itens
```

### Empréstimo

Um empréstimo somente pode ser realizado quando:

```text
Item cadastrado
      +
Item disponível
      +
Usuário dentro do limite
      =
Empréstimo permitido
```

---

# 🎨 Padrões utilizados

- Programação Orientada a Objetos
- Encapsulamento
- Herança
- Polimorfismo
- Abstração
- Separação de responsabilidades
- Código organizado
- Nomes semânticos
- Classes com responsabilidades definidas
- Uso de modificadores de acesso
- Validação de regras de negócio
- Integridade de dados
- Uso de constraints SQL
- Relacionamentos entre tabelas
- Consultas SQL
- Organização por packages

---

# 🗂️ Organização dos arquivos

O código Java está organizado no package:

```java
package biblioteca;
```

Todos os arquivos relacionados ao domínio da aplicação estão agrupados nesse package.

O script SQL está separado do código Java:

```text
sql/database.sql
```

Essa organização mantém separados o código da aplicação e os scripts de banco de dados.

---

# 🗃️ Script SQL

O projeto utiliza um único arquivo para facilitar a execução e avaliação:

```text
sql/database.sql
```

O script contém:

```text
CREATE TABLE
INSERT
SELECT
PRIMARY KEY
FOREIGN KEY
UNIQUE
CHECK
DEFAULT
JOIN
GROUP BY
ORDER BY
COALESCE
```

---

# 🚫 Arquivos não versionados

Arquivos gerados pela IDE ou pelo processo de compilação não devem ser versionados.

Exemplo de `.gitignore`:

```gitignore
.idea/
out/
*.iml
```

---

# 📌 Observação

O projeto foi desenvolvido com foco educacional, permitindo aplicar conceitos fundamentais de **Java, Programação Orientada a Objetos e SQL** em um cenário prático de gerenciamento de biblioteca.

A aplicação pode ser posteriormente expandida com novas funcionalidades, como:

- Interface gráfica
- Persistência integrada ao Java
- JDBC
- Maven
- Spring Boot
- API REST
- Autenticação
- Histórico de empréstimos
- Controle de usuários
- Relatórios
- Testes automatizados

---

# 👨‍💻 Saiba mais

O projeto aplica conceitos de **Java, Programação Orientada a Objetos, modelagem de dados, SQL, regras de negócio, organização de código e boas práticas de desenvolvimento**, utilizando como domínio uma aplicação de gerenciamento de biblioteca.
