# Omnidex — Backend

Backoffice per **Omnidex**, un catalogo di reliquie e artefatti fittizi (armi, armature, oggetti magici) raggruppate per universo (Final Fantasy, Il Signore degli Anelli, Marvel, Star Wars, ...).

## Funzionalità

- CRUD completa su **reliquie**, **universi** e **categorie** tramite pagine Thymeleaf (backoffice)
- Autenticazione con Spring Security (form login) e ruoli: `ADMIN` (scrittura) e `USER` (lettura)
- API REST in sola lettura per il frontend React:
  - `GET /api/relics` — elenco completo, con filtro opzionale `?name=`
  - `GET /api/relics/{id}` — singola reliquia
- Dati di seed in `data.sql`: 10 universi, 4 categorie, 40 reliquie con icone SVG

## Frontend

La parte React (Vite, porta 5173) si trova nella repo dedicata:

**[omnidex-frontend](https://github.com/bingiulioliu/omnidex-frontend)**

## Utenti di default

| Username | Password | Ruolo  |
|----------|----------|--------|
| `admin`  | `password` | ROLE_ADMIN e ROLE_USER |
| `user`   | `password` | ROLE_USER  |

## Struttura

```
src/main/java/com/java/projectwork/omnidex_backend/
├── controller/   # MVC (Thymeleaf) + RelicRestController
├── service/      # logica CRUD
├── repository/   # Spring Data JPA
├── model/        # Relic, Universe, Category, User, Role
├── security/     # Spring Security
└── exception/    # ResourceNotFoundException
```
