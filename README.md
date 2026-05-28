# customer-order-service

Baseline Spring Boot 3.2 / Java 17 application for branching strategy POC demonstrations.

## Purpose

This app simulates an enterprise multi-layer architecture — similar to how Oracle ADF + SOA/OSB + PL/SQL stacks are structured — using standard Spring components:

| Spring Layer       | Oracle Analogue         |
|--------------------|-------------------------|
| `controller/`      | ADF UI / REST facade    |
| `service/`         | SOA / OSB integration   |
| `repository/`      | PL/SQL / DB procedures  |
| Flyway migrations  | Schema DDL scripts      |
| `FeatureFlagConfig`| Environment-level flags |

The app manages three domain objects — **Customer**, **Order**, and **Payment** — via REST endpoints backed by an in-memory H2 database.

## Running

```bash
mvn spring-boot:run
```

The app starts on `http://localhost:8080`. H2 console is available at `/h2-console` (JDBC URL: `jdbc:h2:mem:testdb`).

## Endpoints

| Method | Path              | Description          |
|--------|-------------------|----------------------|
| GET    | /customers        | List all customers   |
| GET    | /customers/{id}   | Get customer by ID   |
| GET    | /orders           | List all orders      |
| POST   | /orders           | Create an order      |
| POST   | /payments         | Process a payment    |

## Testing

```bash
mvn clean verify
```

## Feature Flags

Controlled via `application.yml` under the `features:` prefix:

```yaml
features:
  customer-search-enabled: false
  payment-audit-enabled: false
  platform-v2-enabled: false
```

Inject `FeatureFlagConfig` into any component to gate behaviour per environment or branch.
