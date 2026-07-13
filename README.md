# accounts-service

Reactive microservice that manages customer bank accounts (creation,
retrieval, balance queries) and acts as the source of truth for account
existence within the system.

> Part of a two-service reactive demo. The companion **transactions-service**
> validates account existence against this service via a non-blocking
> WebClient call before persisting a movement.
> Repo: <link a transactions-ms>

## Tech stack
- Java 17
- Spring Boot 3.5.16 (Spring WebFlux, non-blocking)
- Spring Data R2DBC + PostgreSQL (reactive persistence)
- Maven

## Status
Work in progress.
- [x] Project scaffold + reactive stack
- [x] Local infrastructure (PostgreSQL + config)
- [x] Domain model & ports
- [ ] Persistence (R2DBC adapter)
- [ ] REST API (reactive endpoints)
- [ ] Tests

## Prerequisites
- JDK 17 (Temurin recommended)
- Docker (for local PostgreSQL)

## Build
```bash
./mvnw clean compile
```

## Architecture
- Hexagonal (application, domain, infrastructure)

## Architecture decisions

- **Spring Boot 3.5.16 (over 4.x)**
  - Prioritized ecosystem maturity for a time-boxed demo — documentation,
  tooling and community resources are consolidated on the 3.x line.
- **WebFlux (over Spring MVC)**
  - Non-blocking event loop for I/O-bound, high-concurrency workloads
  (e.g. the inter-service call before each write).
- **R2DBC (over JPA/JDBC)**
  - Reactive, non-blocking persistence end-to-end; JDBC/JPA would block the
  event loop.
- **Polyrepo (over monorepo)**
  - Independent deploy cadence and ownership per service; services communicate
  only over the network contract.
- **UUID as identifier (over auto-increment)**
  - Non-sequential, non-guessable IDs — avoids exposing record counts and
  fits distributed services.
- **Output ports in `domain` (over `application`)**
  - The repository contract expresses a domain need over the domain model,
   so it lives beside it. Both placements are valid; chose one for
   consistency across the service.


## Next steps / out of scope
Deliberately out of scope to keep the demo focused on the reactive core:
- Security (JWT / OAuth2)
- Response caching
- Cloud deployment
- Observability (metrics, distributed tracing)