# 6dvp-netflix-auth
Microserviço de Autenticação, trabalho conclusão de curso.

<p>Porta de execução: <b>8090</b></p>
<p>Retorna um token JWT com os Clains do usuário logado.</p>

<p><i>Exemplo do payload</i></p>
<p>{</p>
<p>  "role": "admin",</p>
<p>  "iss": "grubio",</p>
<p>  "exp": "1616690277776"</p>
<p>}</p>

## Variáveis de ambiente.
<p>DB_SERVER = <i>Servidor do MySQL</i></p>
<p>DB_PORT = <i>Porta do servidor</i></p>
<p>DB_USERNAME =<i>Usuário</i></p>
<p>DB_PASSWORD =<i>Senha</i></p>

## Dump Mysql
<p>Restaurar o arquivo de backup <i>auth-db.sql</i> localizado na pasta <i>/data</i></p>
