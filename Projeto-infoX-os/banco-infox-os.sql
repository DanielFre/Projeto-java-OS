create database if not exists dbinfox default character set utf8 default collate utf8_general_ci;
use dbinfox;

create table if not exists tbusuarios (
	id int not null auto_increment primary key,
    usuario varchar (50) not null,
    fone varchar (15) default '',
	login varchar (15) unique not null,
	senha varchar (15) not null,
    nivelacesso varchar (15) default 'normal' not null, 
    constraint CHECK (nivelacesso in ('admin', 'normal', 'especial'))
) default charset = utf8mb4;

insert into tbusuarios(usuario, login, senha, nivelacesso) values ('Daniel','admin', 'admin','admin');
select * from tbusuarios;
desc tbusuarios;
#drop table tbusuarios;
#select * from usuario where usuario = 'daniel' and senha = '123';
#alter table usuario 

create table if not exists tbclientes (
	id int not null auto_increment primary key,
    nome varchar (50) not null,
    endereco varchar (100),
    fone varchar (15) not null,
    email varchar (50)
	
) default charset = utf8mb4;

desc tbclientes;
insert into tbclientes(nome, fone) values ('Daniel Frey','55 55555-5555');
select * from tbclientes;

create table if not exists tbos (
	os int not null auto_increment primary key,
    data_os timestamp default current_timestamp,
    equipamento varchar (150) not null,
    defeito varchar (150)not null,
    servico varchar (150),
    tecnico varchar (30),
    valor decimal (10,2),
    id_cliente int not null,
    foreign key (id_cliente) references tbclientes(id)

) default charset = utf8mb4;
desc tbos;

insert into tbos (equipamento, defeito, servico, tecnico, valor, id_cliente) 
	values ('celular','não liga','trocar bateria','Daniel','150','1');

select * from tbos;
    
