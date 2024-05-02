## ABOUT THE TECHNOLOGIES
## - - - - - - - - - - - - - - - - - - - - -- - - - - - - - -
* Java version: 17
* Framework: Spring
* Database: PostgreSQL
* Dependencies Manager: Maven
* Containers: Docker

## - - - - - - - - - - - - - - - - - - - - -- - - - - - - - -
## HOW TO RUN DE APPLICATION
## - - - - - - - - - - - - - - - - - - - - -- - - - - - - - -
Para o funcionamento da aplicação foram feitos 2 passos:
1. Subir a imagem postgres no docker
2. Configurar as variáveis de ambiemte na IDE

1. Subindo a imagem postgres no docker
Primeiramente vá até o diretório onde se encontra a paste docker com o arquivo docker-compose.yaml.
ex: /home/quintiliano-leo/git-leadersofts/salsa tech/beachstuffrental/docker

Então execute o seguinte comando:
sudo docker-compose up -d

OBS: Caso o sistema operacional seja windows, rever as permissões de super usuário para o comando "docker-compose up -d" uma vez que o sudo não funciona

2. Configurando as variáveis de ambiente na IDE:

* Foram criadas as seguintes variáveis de ambiente dentro da IDE Intellij, o mesmo pode ser feito no Eclipse ou outra IDE: 
database_name = okta_beach_rental
salsa_pg_pass = sergtsop
salsa_pg_user = postgres

## - - - - - - - - - - - - - - - - - - - - -- - - - - - - - -
## MAIN COVERED REQUIREMENTS
## - - - - - - - - - - - - - - - - - - - - -- - - - - - - - -
* Testes unitários
* Docker
* Clean architecture
* Design Patters (factory e singleton)

## - - - - - - - - - - - - - - - - - - - - -- - - - - - - - -
## CONTACT
## - - - - - - - - - - - - - - - - - - - - -- - - - - - - - -
* Para dúvidas e sugestões me encontre em 3599127-5734 ou leandroquintilianolavras@hotmail.com
