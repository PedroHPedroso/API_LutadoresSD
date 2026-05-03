# API Lutadores - Sistemas Distribuídos

Esta é uma API desenvolvida para o gerenciamento de lutadores, integrando o ecossistema **Java** com **Spring Boot** e persistência em **PostgreSQL**, totalmente orquestrada via **Docker**.

O projeto foi construído como trabalho para o curso de Ciência da Computação da **UENP**, focando em arquitetura escalável e sistemas distribuídos.

## Tecnologias e Ferramentas

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![Swagger](https://img.shields.io/badge/-Swagger-%23C1E1C1?style=for-the-badge&logo=swagger&logoColor=black)

---

## Hospedagem e Deploy (Render)

A aplicação está hospedada no **Render** e utiliza deploy automatizado via **Docker**, garantindo que o ambiente de produção seja idêntico ao de desenvolvimento.

### Configuração de Ambiente
Para que a aplicação conecte corretamente ao banco de dados e exponha a porta necessária, as seguintes variáveis de ambiente devem ser configuradas no painel do Render (sem expor dados sensíveis no código-fonte):

* **`SPRING_DATASOURCE_URL`**: URL de conexão JDBC (Ex: `jdbc:postgresql://<HOSTNAME>:<PORTA>/<NOME_DO_BANCO>`).
* **`SPRING_DATASOURCE_USERNAME`**: Nome de usuário do banco de dados.
* **`SPRING_DATASOURCE_PASSWORD`**: Senha de acesso ao banco de dados.
* **`PORT`**: Porta interna da aplicação (definida como `8080`).

---

## Como Executar e Testar o Projeto

### 1. Acesso Online (Swagger)
A API conta com documentação interativa via Swagger UI para teste imediato de todos os métodos (GET, POST, PUT, DELETE) diretamente pelo navegador:

🔗 **[Acessar Swagger no Render](https://api-lutadoressd.onrender.com/swagger-ui/index.html)**

> **Dica de Uso:** No Swagger, clique em um endpoint, selecione **"Try it out"**, preencha os campos e clique em **"Execute"** para ver a resposta em tempo real.

### 2. Execução Local (Docker)
A aplicação está totalmente "dockerizada". Ao subir os containers, o banco de dados PostgreSQL e o servidor de aplicação são iniciados em sincronia.

#### Pré-requisitos
* **Docker** e **Docker Compose** instalados.

#### Passo a Passo
1. **Clone o repositório:**
   ```bash
   git clone [https://github.com/PedroHPedroso/API_LutadoresSD.git](https://github.com/PedroHPedroso/API_LutadoresSD.git)

**Como testar:**

1.  **Certifique-se de que os containers estão de pé:**
    ```bash
    docker ps
    ```
    Você deve ver `api-lutadores` e `postgres-db` ativos.
2.  **Acesse a URL:**
    Abra o navegador em `http://localhost:8080/swagger-ui/index.html`