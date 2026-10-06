CREATE TABLE item (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    codigo VARCHAR(30) NOT NULL UNIQUE,
    titulo VARCHAR(200) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    autor VARCHAR(150),
    edicao INTEGER,
    disponivel BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT ck_item_tipo
        CHECK (tipo IN ('LIVRO', 'REVISTA')),
    CONSTRAINT ck_item_edicao
        CHECK (edicao IS NULL OR edicao > 0)
);

CREATE TABLE usuario (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    limite_itens INTEGER NOT NULL,
    CONSTRAINT ck_usuario_tipo
        CHECK (tipo IN ('ALUNO', 'PROFESSOR')),
    CONSTRAINT ck_usuario_limite
        CHECK (limite_itens > 0)
);

CREATE TABLE emprestimo (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    item_id BIGINT NOT NULL,
    usuario_id BIGINT NOT NULL,
    data_retirada DATE NOT NULL,
    data_devolucao_prevista DATE NOT NULL,
    data_devolucao DATE,
    valor_multa NUMERIC(10, 2) NOT NULL DEFAULT 0,
    CONSTRAINT fk_emprestimo_item
        FOREIGN KEY (item_id) REFERENCES item(id),
    CONSTRAINT fk_emprestimo_usuario
        FOREIGN KEY (usuario_id) REFERENCES usuario(id),
    CONSTRAINT ck_emprestimo_datas
        CHECK (data_devolucao_prevista >= data_retirada),
    CONSTRAINT ck_emprestimo_devolucao
        CHECK (
            data_devolucao IS NULL
            OR data_devolucao >= data_retirada
        ),
    CONSTRAINT ck_emprestimo_multa
        CHECK (valor_multa >= 0)
);

INSERT INTO item (
    codigo,
    titulo,
    tipo,
    autor,
    edicao,
    disponivel
) VALUES
(
    'L001',
    'Clean Code',
    'LIVRO',
    'Robert C. Martin',
    1,
    FALSE
),
(
    'L002',
    'Java Efetivo',
    'LIVRO',
    'Joshua Bloch',
    3,
    TRUE
),
(
    'R001',
    'Java Magazine',
    'REVISTA',
    NULL,
    120,
    TRUE
),
(
    'R002',
    'Tecnologia Hoje',
    'REVISTA',
    NULL,
    45,
    TRUE
);

INSERT INTO usuario (
    nome,
    tipo,
    limite_itens
) VALUES
(
    'Ana Silva',
    'ALUNO',
    3
),
(
    'Carlos Souza',
    'PROFESSOR',
    5
);

INSERT INTO emprestimo (
    item_id,
    usuario_id,
    data_retirada,
    data_devolucao_prevista,
    data_devolucao,
    valor_multa
) VALUES
(
    1,
    1,
    DATE '2026-09-01',
    DATE '2026-09-15',
    NULL,
    2.50
),
(
    2,
    2,
    DATE '2026-08-01',
    DATE '2026-08-15',
    DATE '2026-08-14',
    0.00
);

SELECT
    codigo,
    titulo,
    tipo,
    disponivel
FROM item
ORDER BY id;

SELECT
    u.nome,
    i.titulo,
    e.data_retirada,
    e.data_devolucao_prevista
FROM emprestimo e
INNER JOIN usuario u
    ON u.id = e.usuario_id
INNER JOIN item i
    ON i.id = e.item_id
WHERE e.data_devolucao IS NULL
ORDER BY e.data_retirada;

SELECT
    u.id,
    u.nome,
    COALESCE(SUM(e.valor_multa), 0.00) AS total_multas
FROM usuario u
LEFT JOIN emprestimo e
    ON e.usuario_id = u.id
GROUP BY
    u.id,
    u.nome
ORDER BY u.nome;

SELECT
    i.codigo,
    i.titulo,
    i.tipo
FROM item i
LEFT JOIN emprestimo e
    ON e.item_id = i.id
WHERE e.id IS NULL
ORDER BY i.id;