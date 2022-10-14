# governar_ti_test


<b>Teste da governar ti concluido</b>

Api feita com java 17</br>
Porta 8085</br>

Ao iniciar o spring boot todos os arquivos csv são importados para o banco utilizando spring batch</br>

Foi utilizado, jpa, lombock e postegresql</br>

Em resources -> aplication.properties</br>
 
spring.datasource.url=url_database</br>
spring.datasource.username=nome</br>
spring.datasource.password=senha</br>

Fiz um filtro com distinct no postegresql para poder lidar com os ids que se repetiam </br>

Bom, eu considero o projeto feito, acho que pra mim a parte mais pesada foi o importe de todos os arquivos</br>
eu nunca tinha subido tantos arquivos, foram acho que mais de 600 mil tabelas</br>

Usei o spring batch, que era algo que não conhecia, mas ele parece ser utilizado com esse proposito mesmo</br>
Subir uma grande quantidade de arquivos

Não fiz o pedido 2 e 4, o 4 acho que podeira te feito, o 2 eu não compreendi mesmo,
como considero subir os arquivos a parte mais importante do teste, não pedi ajuda, como foi me orientado, caso eu tivesse duvida, como esse final de semana vou estar ocupado, queria entregar ele logo agora.


<b>1. Endpoint com pilotos que venceram ao menos 1 corrida - retorna uma lista de pilotos com filtro distinct</br></b>
http://localhost:8085/api/v1/drivers/winner/1</br>

2. Eu não fiz o segundo teste por que não consegui localizar na tabela essas informações</br>

<b>3. pilotos que pilotaram pelo maior número de equipes, por ordem 
decrescente endpoint: /drivers/teams/</br></b>

http://localhost:8085/api/v1/drivers/teams</br>

4. não entendi bem como localizar as informações</br>

<b>5.Todos os pilotos que participaram de uma determinada corrida de uma </br>
determinada etapa. Exemplo: pilotos que participaram da segunda etapa</br>
da temporada de 1995: /races/1995/2</br>
endpoint: /races/{season}/{round}</br></b>

http://localhost:8085/api/v1/races/2010/5</br>

Foi adicionado swagger pra facilitar o teste na api</br>
http://localhost:8085/swagger-ui/index.html</br>

Para rodar a aplicação basta baixar o zip, abrir com intelliJ  e ele faz o resto baixando as dependencias</br>

o spring ta configurado pra iniciar o importe e criar a tabela toda vez que iniciar
