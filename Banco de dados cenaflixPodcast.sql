create database cenaflixPodcast;

use cenaflixPodcast;

CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(20) NOT NULL,
	senha VARCHAR(20) NOT NULL,
    permissao varchar(20) not null
);

create table podcast(
id int auto_increment primary key,
produtor varchar(30) not null,
nomeEpisodio varchar(60) not null,
duracao varchar(20),
urlRepositorio varchar(60)
);

select * from usuario;

select * from podcast;