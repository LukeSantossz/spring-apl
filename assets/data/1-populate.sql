USE application;

INSERT INTO users(username, password) VALUES ('admin', 'root');

-- Inserir alguns gêneros
INSERT INTO generos(nome) VALUES 
('Ação'),
('Aventura'),
('RPG'),
('Estratégia'),
('Esportes');

-- Inserir algumas plataformas
INSERT INTO plataformas(descricao) VALUES 
('PC'),
('PlayStation 5'),
('Xbox Series X'),
('Nintendo Switch');

-- Inserir modos de jogo
INSERT INTO modos_jogo(descricao) VALUES 
('Single Player'),
('Multiplayer'),
('Co-op'),
('MMO');