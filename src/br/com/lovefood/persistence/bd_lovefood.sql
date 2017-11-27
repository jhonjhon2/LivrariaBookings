create database if not exists lovefood;

use lovefood;

create or replace table lovefood.funcionario (
	id BIGINT PRIMARY KEY auto_increment,
	nome varchar(150) not null,
	login varchar(50) not null unique,
	senha varchar(255) not null,
	nivel enum('ADMIN', 'NORMAL')
);

select * from lovefood.funcionario;
select id, nome, login, nivel from lovefood.funcionario;

create or replace table lovefood.cliente (
	id BIGINT PRIMARY KEY auto_increment,
	nome varchar(150) not null,
	login varchar(50) not null unique,
	cpf varchar(11) not null unique,
	endereco text not null,
	telefone varchar(255) not null,
	senha varchar(255) not null
);


insert into lovefood.cliente values (null, 'Luis', 'lpjr', '12345678900', 'rua 0', '(21)2222-2222', md5('123'));

select * from lovefood.cliente;

select id, nome, login, cpf, endereco, telefone from lovefood.cliente where login like 'lpjr' and senha = md5('123');

SET @sql = CONCAT('SELECT ', (
		SELECT REPLACE(GROUP_CONCAT(COLUMN_NAME), 'senha,', '') 
		FROM INFORMATION_SCHEMA.COLUMNS 
		WHERE TABLE_NAME = 'funcionario' 
		AND TABLE_SCHEMA = 'lovefood'), ' FROM funcionario');

PREPARE stmt_find FROM @sql;
EXECUTE stmt_find;