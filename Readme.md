Configuração para https localhost

<h2>Acessando a API</h2>

Mandar uma requisição para: http://localhost:8080/oauth/token
##Parâmetro de Basic Auth:
###Basic Auth:
<code>username = <strong>client</strong></code><br>
<code>password = <strong>123</strong> (esses são os client_id e secret_id)</code>
![Basic Auth](https://i.imgur.com/L1IJWiT.png)
###Parâmetros no Body:

<code>grant_type = <strong>password</strong></code> <br>
<code>username = <strong>admin</strong></code> <br>
<code>password = <strong>123456</strong></code> <br>
![Autenticação](https://i.imgur.com/iHIyzfX.png)
Quando autenticar o retorno sera o seguinte;<br />

<code>
{    <br />
        "access_token": "878c2578-2eca-46b7-adc9-80e29589a0ca",<br />
        "token_type": "bearer",<br />
        "refresh_token": "e33e1989-083b-4706-b6b2-11e718cca512",<br />
        "expires_in": 49999,<br />
        "scope": "all"<br />
    }<br />
</code>
<br />

![Autenticado](https://i.imgur.com/hL75q08.png)


#####Depois que autenticar só precisa enviar o access_token:
<strong>"access_token": "878c2578-2eca-46b7-adc9-80e29589a0ca"</strong>

Para atualizar o token, basta mandar uma nova requisição para: http://localhost:8080/oauth/token
Adicionando o campo: refresh_token e passando o token de refresh que foi informado no login
![Refresh Token](https://i.imgur.com/EvgsUBn.png)

###Iniciando o banco Postgres
<code>sudo docker-compose up -d</code>
