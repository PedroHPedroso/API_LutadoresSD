#  API Lutadores - Sistemas Distribuídos

Esta é uma API desenvolvida para o gerenciamento de lutadores, integrando o ecossistema **Java** com **Spring Boot** e persistência em **PostgreSQL**, totalmente orquestrada via **Docker**.

O projeto foi construído como trabalho um no curso de Ciência da Computação da **UENP**, focando em arquitetura escalável e sistemas distribuídos.

## Tecnologias e Ferramentas

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![Swagger](https://img.shields.io/badge/-Swagger-%23C1E1C1?style=for-the-badge&logo=swagger&logoColor=black)

---

##  Como Executar o Projeto

A aplicação está "dockerizada", o que significa que o ambiente de banco de dados e o servidor de aplicação sobem em sincronia.

### Pré-requisitos
* **Docker** e **Docker Compose** instalados.

### Passo a Passo
1. **Clone o repositório:**
   ```bash
   git clone [https://github.com/PedroHPedroso/API_LutadoresSD.git]
   ````

**Como testar:**

1.  **Certifique-se de que os containers estão de pé:**
    ```bash
    docker ps
    ```
    Você deve ver `api-lutadores` e `postgres-db` ativos.
2.  **Acesse a URL:**
    Abra o navegador em `http://localhost:8080/swagger-ui/index.html`