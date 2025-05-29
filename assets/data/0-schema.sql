USE application;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE generos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE plataformas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE modos_jogo (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE jogos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    modo_jogo_id BIGINT,
    FOREIGN KEY (modo_jogo_id) REFERENCES modos_jogo(id)
);

CREATE TABLE jogos_generos (
    jogo_id BIGINT,
    genero_id BIGINT,
    PRIMARY KEY (jogo_id, genero_id),
    FOREIGN KEY (jogo_id) REFERENCES jogos(id),
    FOREIGN KEY (genero_id) REFERENCES generos(id)
);

CREATE TABLE jogos_plataformas (
    jogo_id BIGINT,
    plataforma_id BIGINT,
    PRIMARY KEY (jogo_id, plataforma_id),
    FOREIGN KEY (jogo_id) REFERENCES jogos(id),
    FOREIGN KEY (plataforma_id) REFERENCES plataformas(id)
);