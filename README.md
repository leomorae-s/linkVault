<div align="center">

# LinkVault

**Gerenciador de links pessoais com foco em observabilidade**

![Java](https://img.shields.io/badge/Java-Spring%20Boot%204-4CAF50?style=flat-square)
![Angular](https://img.shields.io/badge/Angular-20-1565C0?style=flat-square)
![Docker](https://img.shields.io/badge/Docker-Compose-0288D1?style=flat-square)
![Status](https://img.shields.io/badge/status-em%20desenvolvimento-orange?style=flat-square)

</div>

---

## Sobre o projeto

LinkVault é um projeto de estudos com foco em **observabilidade e métricas** em aplicações Java modernas. A ideia central é construir um vault pessoal de links relevantes, utilizando-o como laboratório para explorar na prática o `Spring Actuator`, `Prometheus` e `Grafana`.

Futuramente o projeto receberá um módulo de encurtamento de URLs e funções padrões de apps modernos como autenticaão via jwt.

---

## Arquitetura

O projeto segue uma estrutura **Monolítica Modular**, privilegiando organização e simplicidade sem a complexidade de um sistema distribuído.

| Camada  | Detalhe                              |
|---------|--------------------------------------|
| Padrão  | Monolítico Modular                   |
| Módulos | `links`, `url-shortener` (planejado) |
| Banco   | PostgreSQL                           |

---

## Stack

### Backend
- **Linguagem:** Java
- **Framework:** Spring Boot 4

### Frontend Web
- **Linguagem:** TypeScript
- **Framework:** Angular 20

### Mobile
- **Linguagem:** Kotlin
- **UI:** Jetpack Compose

### Infraestrutura
- Docker / Docker Compose

### Observabilidade

| Ferramenta      | Função                                      |
|-----------------|---------------------------------------------|
| Spring Actuator | Endpoints de health e métricas da aplicação |
| Prometheus      | Coleta e armazenamento de métricas          |
| Grafana         | Dashboards e visualização em tempo real     |

---

## Milestones

- [x] Configuração do ambiente de desenvolvimento da API
- [x] Criação da versão inicial da API
- [x] Criação do frontend web em Angular
- [ ] Módulo de encurtamento de URLs _(próximo)_
- [ ] App mobile Android _(hiato)_

---

## Como rodar

O ambiente completo sobe via Docker Compose, incluindo a aplicação, banco de dados e o stack de observabilidade.

```bash
git clone https://github.com/seu-usuario/linkvault
cd linkvault
cp .env.example .env
docker compose up -d
```

> Certifique-se de configurar as variáveis de ambiente no `.env` antes de subir os containers.

---

## Acessos locais

| Serviço    | URL                       |
|------------|---------------------------|
| API        | http://localhost:8080     |
| Frontend   | http://localhost:4200     |
| Grafana    | http://localhost:3000     |
| Prometheus | http://localhost:9090     |
| pgAdmin    | http://localhost:5431     |

---
