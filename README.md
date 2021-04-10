# 6dvp-netflix-auth
Microserviço de Autenticação, trabalho conclusão de curso.

<p>Porta de execução: <b>8090</b></p>

## /login
<p>Retorna um token JWT com os Clains do usuário logado.</p>
<p>Nível de permissão: permitAll
<p><i>Exemplo do payload</i></p>
<p>{</p>
<p>  "iss": "grubio",</p>
<p>  "authorities": [</p>
<p>    "ROLE_ADMIN"</p>
<p>  ],</p>
<p>  "iat": 1618080087,</p>
<p>  "exp": 1618080687</p>
<p>}</p>

## /getUsers
<p>Retorna lista de usuários</p>
<p>Nível de permissão: permitAll
  
## /addUser
<p>Adiciona usuário, necessário passar um <i>json</i> no <i>body</i>
<p>Nível de permissão: ROLE_ADMIN
<p><i>Exemplo do json</i></p>
<p>{</p>
<p>  "username": "teste",</p>
<p>  "password": "teste",</p>
<p>  "role": "<b>ROLE_</b>USER", <b><---- importante adicionar o prefixo ROLE_ antes da string</b></p>
<p>  "enabled": true</p>
<p>}</p>

## Variáveis de ambiente.
<p>DB_SERVER = <i>Servidor do MySQL</i></p>
<p>DB_PORT = <i>Porta do servidor</i></p>
<p>DB_USERNAME =<i>Usuário</i></p>
<p>DB_PASSWORD =<i>Senha</i></p>

## Dump Mysql
<p>Restaurar o arquivo de backup <i>auth-db.sql</i> localizado na pasta <i>/data</i></p>

## Execução Docker
<p>docker build -t 6dvp-netflix/auth:v1.1.0 .</p>
<p>docker run --name auth -d -p 8090:8090 -e DB_SERVER=xxx.xxx.xxx.xxx -e DB_PORT=3306 -e DB_USERNAME=root -e DB_PASSWORD=123456789 6dvp-netflix/auth:v1.1.0</p>
