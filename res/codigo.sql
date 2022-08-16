create database if not exists registro;

use registro;

create table acesso(
	id INT(11) NOT NULL AUTO_INCREMENT,
	nome VARCHAR(250) NOT NULL,
	senha VARCHAR(250),
	primary key(id)
);