# 6dvp-netflix-auth
Microserviço de Autenticação, trabalho conclusão de curso.

<p>Porta de execução: <b>8090</b></p>

## /getToken
<p>Retorna um token JWT com os Clains do usuário logado.</p>
<p><i>Exemplo do payload</i></p>
<p>{</p>
<p>  "role": "admin",</p>
<p>  "iss": "grubio",</p>
<p>  "exp": "1616690277776"</p>
<p>}</p>

## /getUsers
<p>Retorna lista de usuários</p>
<p>Nível de permissão: permitAll
  
## /addUser
<p>Adiciona usuário, necessário passar um <i>json</i> no <i>body</i>
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
