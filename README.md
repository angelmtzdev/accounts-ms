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
- [ ] Local infrastructure (PostgreSQL + config)
- [ ] Domain & persistence (R2DBC)
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
- **R2DBC (over JPA/JDBC)**
- **Polyrepo**


## Next steps / out of scope
Deliberately out of scope to keep the demo focused on the reactive core:
- Security (JWT / OAuth2)
- Response caching
- Cloud deployment
- Observability (metrics, distributed tracing)