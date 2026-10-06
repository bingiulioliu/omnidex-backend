-- Inserimento dei Ruoli
INSERT INTO roles (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles (id, name) VALUES (2, 'ROLE_USER');

-- Inserimento degli Utenti (La password per entrambi è "password" cifrata in BCrypt)
-- Hash BCrypt di "password": $2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd0X1gZNu26x.2T2
INSERT INTO users (id, username, password) VALUES (1, 'admin', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd0X1gZNu26x.2T2');
INSERT INTO users (id, username, password) VALUES (2, 'user', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd0X1gZNu26x.2T2');

-- Associazione Utenti - Ruoli nella tabella ponte role_user
-- L'admin ottiene sia ROLE_ADMIN sia ROLE_USER
INSERT INTO role_user (user_id, role_id) VALUES (1, 1);
INSERT INTO role_user (user_id, role_id) VALUES (1, 2);

-- L'utente semplice ottiene solo ROLE_USER
INSERT INTO role_user (user_id, role_id) VALUES (2, 2);

-- -------------------------------------------------------------
-- 1. UNIVERSI (universes: id, name, description)
-- -------------------------------------------------------------
INSERT INTO universes (id, name, description) VALUES 
(1, 'Final Fantasy', 'Universo fantasy e sci-fi popolato da cristalli, evocazioni e battaglie epiche.'),
(2, 'Il Signore degli Anelli', 'Il mondo fantasy creato da J.R.R. Tolkien, ambientato nella Terra di Mezzo.'),
(3, 'Dragon Ball', 'Universo di arti marziali e sci-fi ideato da Akira Toriyama, ricco di guerrieri e sfere magiche.'),
(4, 'Marvel', 'L''universo di supereroi, divinità e manufatti cosmici dei fumetti e del cinema.'),
(5, 'Star Wars', 'Galassia lontana lontana dominata dalla Forza, dai Cavalieri Jedi e dai Lord Sith.'),
(6, 'The Legend of Zelda', 'Il regno di Hyrule, ciclicamente minacciato dall''oscurità e protetto dall''Eroe del Tempo.'),
(7, 'God of War', 'Mondo epico dominato da pantheon mitologici, mostri e divinità guerriere.');

-- -------------------------------------------------------------
-- 2. CATEGORIE (categories: id, name, description)
-- -------------------------------------------------------------
INSERT INTO categories (id, name, description) VALUES 
(1, 'Arma', 'Oggetti e strumenti progettati per il combattimento e l''offesa.'),
(2, 'Artefatto', 'Manufatti antichi o tecnologici dotati di poteri eccezionali.'),
(3, 'Armatura', 'Equipaggiamenti protettivi e indossabili usati per la difesa.'),
(4, 'Magia', 'Oggetti imbevuti di poteri arcani o energia mistica.');

-- -------------------------------------------------------------
-- 3. RELIQUIE (relics: id, name, description, img_url, universe_id)
-- -------------------------------------------------------------
INSERT INTO relics (id, name, description, img_url, universe_id) VALUES 
(1, 'Buster Sword', 'Iconico spadone brandito da Cloud Strife, lasciatogli in eredità da Zack Fair.', 'https://images.unsplash.com/photo-1595590424283-b8f17842773f', 1),
(2, 'L''Unico Anello', 'Anello forgiato da Sauron nei fuochi del Monte Fato per dominare la Terra di Mezzo.', 'https://images.unsplash.com/photo-1618005182384-a83a8bd57fbe', 2),
(3, 'Radar Cerca Sfere', 'Dispositivo portatile inventato da Bulma per localizzare le magiche Sfere del Drago.', 'https://images.unsplash.com/photo-1518709268805-4e9042af9f23', 3),
(4, 'Mjolnir', 'Il martello incantato di Thor, forgiato dai nani nel cuore di una stella morente.', 'https://images.unsplash.com/photo-1568832359672-e36cf5d74f54', 4),
(5, 'Spada Laser di Luke Skywalker', 'La leggendaria spada laser a lama verde costruita da Luke prima di diventare un vero Jedi.', 'https://images.unsplash.com/photo-1589241062272-c0a000072dfa', 5),
(6, 'Gunblade di Squall', 'Insolita e letale combinazione tra una spada a lama lunga e un meccanismo a tamburo di rivoltella.', 'https://images.unsplash.com/photo-1595590424283-b8f17842773f', 1),
(7, 'Pungolo (Sting)', 'Pugnale elfico ritrovato da Bilbo Baggins, la cui lama si illumina d''azzurro in presenza di orchi.', 'https://images.unsplash.com/photo-1595590424283-b8f17842773f', 2),
(8, 'Bastone Nyoibo', 'Bastone magico estensibile, tramandato a Goku dal nonno adottivo Gohan.', 'https://images.unsplash.com/photo-1518709268805-4e9042af9f23', 3),
(9, 'Guanto dell''Infinito', 'Manufatto cosmico progettato per incanalare il potere simultaneo delle sei Gemme dell''Infinito.', 'https://images.unsplash.com/photo-1608889825103-7037d7c68696', 4),
(10, 'Olocron Sith', 'Dispositivo tetraedrico contenente i segreti e gli antichi saperi del Lato Oscuro della Forza.', 'https://images.unsplash.com/photo-1518709268805-4e9042af9f23', 5),
(11, 'Spada Suprema (Master Sword)', 'La leggendaria spada che esorcizza il male, l''unica arma in grado di respingere Ganon.', 'https://images.unsplash.com/photo-1595590424283-b8f17842773f', 6),
(12, 'Scudo Hylia', 'Il robustissimo scudo tradizionale dei cavalieri di Hyrule, leggendario per la sua resistenza.', 'https://images.unsplash.com/photo-1568832359672-e36cf5d74f54', 6),
(13, 'Ocarina del Tempo', 'Strumento musicale magico in grado di manipolare il tempo e aprire il Portale del Tempo.', 'https://images.unsplash.com/photo-1518709268805-4e9042af9f23', 6),
(14, 'Lame del Caos', 'Coppia di spade forgiate negli inferi e incatenate per sempre alle braccia di Kratos.', 'https://images.unsplash.com/photo-1595590424283-b8f17842773f', 7),
(15, 'Ascia Leviatano', 'Ascia da guerra forgiata dai nani Brok e Sindri, intrisa del potere magico del ghiaccio.', 'https://images.unsplash.com/photo-1595590424283-b8f17842773f', 7),
(16, 'Sfera del Drago a Quattro Stelle', 'La preziosa sfera magica lasciata in eredità a Goku, considerata il suo tesoro più grande.', 'https://images.unsplash.com/photo-1618005182384-a83a8bd57fbe', 3),
(17, 'Scudo di Captain America', 'Disco in lega di vibranio, perfettamente bilanciato e virtualmente indistruttibile.', 'https://images.unsplash.com/photo-1568832359672-e36cf5d74f54', 4),
(18, 'Elmo di Darth Vader', 'Sistema di supporto vitale ed iconico elmo oscuro che incute terrore in tutta la galassia.', 'https://images.unsplash.com/photo-1589241062272-c0a000072dfa', 5),
(19, 'Maschera di Majora', 'Antico artefatto usato nei riti di tribù perdute, dotato di una tremenda volontà maligna.', 'https://images.unsplash.com/photo-1518709268805-4e9042af9f23', 6),
(20, 'Narsil (Andúril)', 'La leggendaria spada di Elendil, riforgiata per Aragorn con il nome di Fiamma dell''Ovest.', 'https://images.unsplash.com/photo-1595590424283-b8f17842773f', 2);

-- -------------------------------------------------------------
-- 4. TABELLA PONTE (category_relic: relic_id, category_id)
-- -------------------------------------------------------------
INSERT INTO category_relic (relic_id, category_id) VALUES 
(1, 1),         -- Buster Sword: Arma
(2, 2), (2, 4), -- Unico Anello: Artefatto, Magia
(3, 2),         -- Radar Cerca Sfere: Artefatto
(4, 1), (4, 2), -- Mjolnir: Arma, Artefatto
(5, 1),         -- Spada Laser: Arma
(6, 1),         -- Gunblade: Arma
(7, 1), (7, 2), -- Pungolo: Arma, Artefatto
(8, 1), (8, 2), -- Bastone Nyoibo: Arma, Artefatto
(9, 2), (9, 4), -- Guanto dell'Infinito: Artefatto, Magia
(10, 2), (10, 4), -- Olocron: Artefatto, Magia
(11, 1), (11, 4), -- Master Sword: Arma, Magia
(12, 3),        -- Scudo Hylia: Armatura
(13, 2), (13, 4), -- Ocarina del Tempo: Artefatto, Magia
(14, 1), (14, 4), -- Lame del Caos: Arma, Magia
(15, 1), (15, 4), -- Ascia Leviatano: Arma, Magia
(16, 2), (16, 4), -- Sfera del Drago: Artefatto, Magia
(17, 3), (17, 2), -- Scudo Cap: Armatura, Artefatto
(18, 3), (18, 2), -- Elmo Darth Vader: Armatura, Artefatto
(19, 2), (19, 4), -- Maschera Majora: Artefatto, Magia
(20, 1), (20, 2); -- Narsil: Arma, Artefatto