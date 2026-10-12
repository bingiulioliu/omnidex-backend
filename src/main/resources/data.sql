-- Inserimento dei Ruoli
INSERT INTO roles (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles (id, name) VALUES (2, 'ROLE_USER');

-- Inserimento degli Utenti (La password per entrambi è "password" cifrata in BCrypt)
-- Hash BCrypt di "password": $2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd0X1gZNu26x.2T2
INSERT INTO users (id, username, password) VALUES (1, 'admin', '{noop}password');
INSERT INTO users (id, username, password) VALUES (2, 'user', '{noop}password');

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
(7, 'God of War', 'Mondo epico dominato da pantheon mitologici, mostri e divinità guerriere.'),
(8, 'Matrix', 'La realtà simulata creata dalle macchine, dove nulla è ciò che sembra e gli occhiali da sole sono d''obbligo.'),
(9, 'Ritorno al Futuro', 'La saga di viaggi nel tempo di Robert Zemeckis, tra DeLorean, paradossi temporali e un certo almanacco.'),
(10, 'The Elder Scrolls: Skyrim', 'Il gelido regno di Skyrim, terra di draghi, profezie e infinite frecce nel ginocchio.');

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
(1, 'Buster Sword', 'Iconico spadone brandito da Cloud Strife, lasciatogli in eredità da Zack Fair.', '/images/relics/buster-sword.svg', 1),
(2, 'L''Unico Anello', 'Anello forgiato da Sauron nei fuochi del Monte Fato per dominare la Terra di Mezzo.', '/images/relics/unico-anello.svg', 2),
(3, 'Radar Cerca Sfere', 'Dispositivo portatile inventato da Bulma per localizzare le magiche Sfere del Drago.', '/images/relics/radar-cerca-sfere.svg', 3),
(4, 'Mjolnir', 'Il martello incantato di Thor, forgiato dai nani nel cuore di una stella morente.', '/images/relics/mjolnir.svg', 4),
(5, 'Spada Laser di Luke Skywalker', 'La leggendaria spada laser a lama verde costruita da Luke prima di diventare un vero Jedi.', '/images/relics/spada-laser.svg', 5),
(6, 'Gunblade di Squall', 'Insolita e letale combinazione tra una spada a lama lunga e un meccanismo a tamburo di rivoltella.', '/images/relics/gunblade.svg', 1),
(7, 'Pungolo (Sting)', 'Pugnale elfico ritrovato da Bilbo Baggins, la cui lama si illumina d''azzurro in presenza di orchi.', '/images/relics/pungolo.svg', 2),
(8, 'Bastone Nyoibo', 'Bastone magico estensibile, tramandato a Goku dal nonno adottivo Gohan.', '/images/relics/bastone-nyoibo.svg', 3),
(9, 'Guanto dell''Infinito', 'Manufatto cosmico progettato per incanalare il potere simultaneo delle sei Gemme dell''Infinito.', '/images/relics/guanto-infinito.svg', 4),
(10, 'Olocron Sith', 'Dispositivo tetraedrico contenente i segreti e gli antichi saperi del Lato Oscuro della Forza.', '/images/relics/olocron-sith.svg', 5),
(11, 'Spada Suprema (Master Sword)', 'La leggendaria spada che esorcizza il male, l''unica arma in grado di respingere Ganon.', '/images/relics/master-sword.svg', 6),
(12, 'Scudo Hylia', 'Il robustissimo scudo tradizionale dei cavalieri di Hyrule, leggendario per la sua resistenza.', '/images/relics/scudo-hylia.svg', 6),
(13, 'Ocarina del Tempo', 'Strumento musicale magico in grado di manipolare il tempo e aprire il Portale del Tempo.', '/images/relics/ocarina-del-tempo.svg', 6),
(14, 'Lame del Caos', 'Coppia di spade forgiate negli inferi e incatenate per sempre alle braccia di Kratos.', '/images/relics/lame-del-caos.svg', 7),
(15, 'Ascia Leviatano', 'Ascia da guerra forgiata dai nani Brok e Sindri, intrisa del potere magico del ghiaccio.', '/images/relics/ascia-leviatano.svg', 7),
(16, 'Sfera del Drago a Quattro Stelle', 'La preziosa sfera magica lasciata in eredità a Goku, considerata il suo tesoro più grande.', '/images/relics/sfera-drago-4-stelle.svg', 3),
(17, 'Scudo di Captain America', 'Disco in lega di vibranio, perfettamente bilanciato e virtualmente indistruttibile.', '/images/relics/scudo-capitan-america.svg', 4),
(18, 'Elmo di Darth Vader', 'Sistema di supporto vitale ed iconico elmo oscuro che incute terrore in tutta la galassia.', '/images/relics/elmo-darth-vader.svg', 5),
(19, 'Maschera di Majora', 'Antico artefatto usato nei riti di tribù perdute, dotato di una tremenda volontà maligna.', '/images/relics/maschera-majora.svg', 6),
(20, 'Narsil (Andúril)', 'La leggendaria spada di Elendil, riforgiata per Aragorn con il nome di Fiamma dell''Ovest.', '/images/relics/narsil.svg', 2),
(21, 'Masamune di Sephiroth', 'Katana a lama extralunga brandita da Sephiroth; nessuno ha mai chiarito se sia un''arma o un modo per compensare qualcosa.', '/images/relics/masamune-sephiroth.svg', 1),
(22, 'Materia Evocazione Bahamut', 'Sfera di materia rossa che evoca il Re dei Draghi: richiede più MP di quanti ne abbia chiunque, ma nessuno lo ammette.', '/images/relics/materia-bahamut.svg', 1),
(23, 'Palantír di Gondor', 'Sfera di cristallo capace di mostrare qualsiasi cosa, tranne come disconnettersi dal malocchio di Sauron.', '/images/relics/palantir.svg', 2),
(24, 'Glamdring', 'Spada elfica di Gandalf che brilla in presenza di orchi, illuminando il cammino anche quando non servirebbe.', '/images/relics/glamdring.svg', 2),
(25, 'Scouter', 'Dispositivo che misura il livello di combattimento dei nemici, di solito un istante prima di esplodere per sovraccarico.', '/images/relics/scouter.svg', 3),
(26, 'Seme dei Senzu', 'Fagiolo miracoloso che sfama per dieci giorni e guarisce ogni ferita; il sapore, purtroppo, resta una punizione.', '/images/relics/seme-senzu.svg', 3),
(27, 'Cubo Cosmico (Tesseract)', 'Contenitore della Gemma dello Spazio: piccolo, azzurro e con un''inspiegabile tendenza a finire nelle mani sbagliate.', '/images/relics/cubo-cosmico.svg', 4),
(28, 'Stormbreaker', 'Ascia-martello forgiata a Nidavellir: abbastanza potente da evocare il Bifrost, abbastanza pesante da rovinare la schiena.', '/images/relics/stormbreaker.svg', 4),
(29, 'Doppia Spada Laser di Darth Maul', 'Spada laser a doppia lama, praticamente ingiocabile nei corridoi stretti ma imbattibile in posa.', '/images/relics/doppia-spada-laser.svg', 5),
(30, 'Triforza', 'Sacra reliquia di tre triangoli dorati: garantisce saggezza, potere e coraggio, purché non la si desideri davvero.', '/images/relics/triforza.svg', 6),
(31, 'Lente della Verità', 'Lente magica che rivela passaggi e oggetti invisibili, correggendo anche la miopia spirituale degli eroi.', '/images/relics/lente-verita.svg', 6),
(32, 'Testa di Mimir', 'La fonte di saggezza più antica dei Nove Regni, nonché la più chiacchierona e difficile da zittire.', '/images/relics/testa-mimir.svg', 7),
(33, 'Occhiali da Sole di Neo', 'Occhiali scuri indispensabili per affrontare Matrix: non mostrano i codici, ma regalano un''insospettabile aria da agente segreto.', '/images/relics/occhiali-neo.svg', 8),
(34, 'Pillola Rossa', 'La scelta che svela il vero volto della realtà. Effetti collaterali: risvegliarsi in una vasca di liquido amniotico.', '/images/relics/pillola-rossa.svg', 8),
(35, 'DeLorean', 'Automobile modificata con un condensatore di flusso per viaggiare nel tempo a 88 mph, purché ci sia una strada dritta.', '/images/relics/delorean.svg', 9),
(36, 'Tavola Hoverboard', 'Tavola volante senza ruote né rotelle: garantisce un volto pulito finché non ci si sposta sull''acqua.', '/images/relics/hoverboard.svg', 9),
(37, 'Almanacco Sportivo', 'Il libro che elenca i risultati sportivi dal 1950 al 2000: il regalo più pericoloso mai fatto a un futuro suocero.', '/images/relics/almanacco-sportivo.svg', 9),
(38, 'Amuleto di Talos', 'Ciondolo che accresce il vigore dei devoti di Talos, tollerato in tutta Skyrim... tranne che dalle guardie.', '/images/relics/amuleto-talos.svg', 10),
(39, 'Pergamena Anziana', 'Antica pergamena che mostra squarci di passato e futuro; leggerla troppo a lungo costa la vista e un po'' di sanità.', '/images/relics/pergamena-anziana.svg', 10),
(40, 'Lama di Mehrunes Dagon', 'Pugnale del Principe Daedrico della distruzione, con una piccola probabilità di uccidere all''istante. Piccola, ma non abbastanza.', '/images/relics/lama-mehrunes.svg', 10);

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
(20, 1), (20, 2), -- Narsil: Arma, Artefatto
(21, 1),          -- Masamune di Sephiroth: Arma
(22, 2), (22, 4), -- Materia Bahamut: Artefatto, Magia
(23, 2), (23, 4), -- Palantír: Artefatto, Magia
(24, 1), (24, 4), -- Glamdring: Arma, Magia
(25, 2),          -- Scouter: Artefatto
(26, 2), (26, 4), -- Seme dei Senzu: Artefatto, Magia
(27, 2), (27, 4), -- Cubo Cosmico: Artefatto, Magia
(28, 1), (28, 2), -- Stormbreaker: Arma, Artefatto
(29, 1),          -- Doppia Spada Laser: Arma
(30, 2), (30, 4), -- Triforza: Artefatto, Magia
(31, 2),          -- Lente della Verità: Artefatto
(32, 2), (32, 4), -- Testa di Mimir: Artefatto, Magia
(33, 2),          -- Occhiali da Sole di Neo: Artefatto
(34, 2), (34, 4), -- Pillola Rossa: Artefatto, Magia
(35, 2),          -- DeLorean: Artefatto
(36, 2),          -- Tavola Hoverboard: Artefatto
(37, 2),          -- Almanacco Sportivo: Artefatto
(38, 2), (38, 4), -- Amuleto di Talos: Artefatto, Magia
(39, 2), (39, 4), -- Pergamena Anziana: Artefatto, Magia
(40, 1), (40, 4); -- Lama di Mehrunes Dagon: Arma, Magia