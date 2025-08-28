# API Clube Senai

Bem-vindo à API Clube Senai, uma solução de backend robusta para a gestão das operações de um clube. Esta aplicação oferece um conjunto completo de endpoints para autenticação de usuários, gerenciamento de membros e funcionários, e rastreamento de acesso em tempo real.

## 🚀 Funcionalidades

* **Autenticação JWT:** Proteção de endpoints da API com JSON Web Tokens.
* **Gestão de Sócios:** Operações CRUD (Criar, Ler, Atualizar, Excluir) para gerenciar membros do clube.
* **Gestão de Funcionários:** Operações CRUD para gerenciar funcionários, com suporte para diferentes cargos.
* **Controle de Acesso:** Endpoints para registrar a entrada e saída de pessoas usando um sistema de tags único.
* **Rastreamento em Tempo Real:** Integração com **WebSockets** para transmitir atualizações sobre acesso em tempo real.
* **API RESTful:** Uma API RESTful bem definida com endpoints claros para cada recurso.
* **Documentação Swagger/OpenAPI:** Documentação da API gerada automaticamente com Swagger.

---

## ⚙️ Configuração

A aplicação utiliza o arquivo `application.properties` para sua configuração. Aqui estão as principais definições:

* **`spring.application.name`**: `clubesenai` - O nome da aplicação.
* **`jwt.secret`**: A chave secreta para assinar e verificar JWTs. **Atenção: Em produção, use uma variável de ambiente.**
* **`jwt.expiration`**: `720` - Tempo de expiração do JWT em minutos.
* **`spring.datasource.url`**: `jdbc:h2:file:./data/clubesenai` - Configura um banco de dados H2.
* **`spring.jpa.hibernate.ddl-auto`**: `update` - O Hibernate irá atualizar o esquema do banco de dados na inicialização.
* **`spring.h2.console.enabled`**: `true` - Habilita o console do H2, acessível em `/h2-console`.
* **`cors.frontend.origin`**: `http://localhost:4200` - Configura o CORS para permitir requisições da origem do frontend.
* **`user.sistema.senha`**: `admin` - Senha padrão para um usuário do sistema. **Atenção: Trate isso de forma segura em produção.**

---

## 🌐 Endpoints da API

### Autenticação
**URL Base: `/auth`**

| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/` | Autentica um usuário e retorna um JWT. |

### Controle de Acesso
**URL Base: `/acessos`**

| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/entrada/{tag}` | Registra a entrada de uma pessoa no clube. |
| `POST` | `/saida/{tag}` | Registra a saída de uma pessoa. |
| `PATCH` | `/cadastrar-tag` | Associa uma nova tag a uma pessoa. |

### Gestão de Funcionários
**URL Base: `/funcionarios`**

| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/` | Cria um novo funcionário. |
| `DELETE` | `/{id}` | Exclui um funcionário pelo ID. |
| `PUT` | `/{id}` | Edita os dados de um funcionário. |
| `GET` | `/{id}` | Busca um funcionário pelo ID. |
| `GET` | `/nome/{nome}` | Procura por funcionários que contenham o nome informado. |
| `GET` | `/cargo/{cargo}` | Lista funcionários por cargo. |
| `GET` | `/` | Lista todos os funcionários. |

### Gestão de Sócios
**URL Base: `/socios`**

| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/` | Cria um novo sócio. |
| `DELETE` | `/{id}` | Exclui um sócio pelo ID. |
| `PUT` | `/{id}` | Edita os dados de um sócio. |
| `GET` | `/{id}` | Busca um sócio pelo ID. |
| `GET` | `/nome/{nome}` | Procura por sócios que contenham o nome informado. |
| `GET` | `/` | Lista todos os sócios. |

---

## 🕸️ WebSockets

A aplicação usa WebSockets para fornecer atualizações em tempo real sobre o acesso.

* **Endpoint WebSocket:** `/ws`
* **Endpoint SockJS:** `/ws-direct` (para conexões diretas, como no Postman)
* **Prefixo do Message Broker:** `/topic`
* **Prefixo do Destino da Aplicação:** `/websocket`

Clientes podem se inscrever em tópicos sob `/topic` para receber mensagens, por exemplo, `/topic/acesso` para atualizações de entrada e saída.
