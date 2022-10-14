# governar_ti_test


Teste da governar ti concluido

Api feita com java 17</br>
Porta 8085</br>

Ao iniciar o spring boot todos os arquivos csv são importados para o banco utilizando spring batch</br>

Foi utilizado, jpa, lombock e postegresql

Em resources -> aplication.properties
 
spring.datasource.url=url_database
spring.datasource.username=nome
spring.datasource.password=senha

Fiz um filtro com distinct no postegresql para poder lidar com os ids que se repetiam 

1. Endpoint com pilotos que venceram ao menos 1 corrida - retorna uma lista de pilotos com filtro distinct
http://localhost:8085/api/v1/drivers/winner/1

Eu não fiz o segundo teste por que não consegui localizar na tabela essas informações

3. pilotos que pilotaram pelo maior número de equipes, por ordem 
decrescente endpoint: /drivers/teams/

http://localhost:8085/api/v1/drivers/teams
