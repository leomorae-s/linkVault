<div align="center">

# LinkVault

**Gerenciador de links pessoais com foco em observabilidade**

![Java](https://img.shields.io/badge/Java-Spring%20Boot%204-4CAF50?style=flat-square)
![Angular](https://img.shields.io/badge/Angular-20-1565C0?style=flat-square)
![Docker](https://img.shields.io/badge/Docker-Compose-0288D1?style=flat-square)
![Status](https://img.shields.io/badge/status-pausado-red?style=flat-square)

</div>

---

> ⏸️ **Aviso:** Este projeto está temporariamente pausado para foco no desenvolvimento do orquestrador local **Brise**. O próximo passo, ao retornar, será a implementação de testes.

## Sobre o projeto

LinkVault é um projeto de estudos com foco em **observabilidade e métricas** em aplicações Java modernas. A ideia central é construir um vault pessoal de links relevantes, utilizando-o como laboratório para explorar na prática o `Spring Actuator`, `Prometheus` e `Grafana`.

Futuramente o projeto receberá um módulo de encurtamento de URLs e funções padrões de apps modernos como autenticação via jwt.

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
- [ ] Implementação de testes automatizados _(próximo)_
- [ ] Módulo de encurtamento de URLs
- [ ] App mobile Android _(hiato)_

---

## Como rodar

O ambiente completo sobe via Docker Compose, incluindo a aplicação, banco de dados e o stack de observabilidade.

```bash
git clone [https://github.com/seu-usuario/linkvault](https://github.com/seu-usuario/linkvault)
cd linkvault
cp .env.example .env
docker compose up -d
