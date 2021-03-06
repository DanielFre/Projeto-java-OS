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
insert into tbusuarios(usuario, login, senha, nivelacesso) values ('Carlos','carlos', 'carlos','normal');
insert into tbusuarios(usuario, login, senha, nivelacesso) values ('Juca','especial', 'especial','especial');

insert into tbusuarios(usuario, fone, login, senha, nivelacesso) values ('Juca', '55 55555-5555', 'especial', 'especial','especial');

select * from tbusuarios;
desc tbusuarios;
#drop table tbusuarios;
#select * from usuario where usuario = 'daniel' and senha = '123';
#alter table usuario 

create table if not exists tbclientes (
	id int not null auto_increment primary key,
    nome varchar (50) not null,
    endereco varchar (100) default '',
    fone varchar (15) not null,
    email varchar (50) default ''
	
) default charset = utf8mb4;

desc tbclientes;
insert into tbclientes(nome, fone) values ('Daniel Frey','55 55555-5555');
select * from tbclientes;
#drop table tbos;
create table if not exists tbos (
	os int not null auto_increment primary key,
    data_os timestamp default current_timestamp,
    
    tipo varchar(20) not null default 'Ordem de Serviço',
    situacao varchar (50) default 'Aguardando Aprovação' not null, 
    equipamento varchar (150) not null default '',
    defeito varchar (150)not null default '',
    servico varchar (150) default '',
    valor decimal (10,2) default '0.00',
    id_cliente int not null,
    id_usuario_tecnico int not null,
    
    foreign key (id_cliente) references tbclientes(id),
    foreign key (id_usuario_tecnico) references tbusuarios(id),
    constraint CHECK (situacao in ('Entrega OK', 'Orçamento Reprovado', 'Orçamento Aprovado', 'Aguardando Aprovação','Aguardando Peças','Abandonado Pelo Cliente','Na Bancada','Retornou','Aguardando Entrega','Irreparável')),
    constraint CHECK (tipo in ('Ordem de Serviço','Orçamento'))

) default charset = utf8mb4;
desc tbos;

insert into tbos (situacao, equipamento, defeito, servico, valor, id_cliente,id_usuario_tecnico) 
	values ('Aguardando Aprovação','celular','não liga','trocar bateria','200.00','1','1');

select * from tbos;
select * from tbusuarios;
select login, senha from tbusuarios where login = 'admin' and senha = 'admin';

select nivelacesso from tbusuarios where login = 'admin' and senha = 'admin';
select * from tbusuarios where usuario like "%Dani%" limit  1;
delete from tbusuarios where id = 7 and login = 'teste';

desc tbclientes;
insert into tbclientes(nome, fone) values ('Daniel Frey','55 55555-5555');
select * from tbclientes;
select id as 'ID', nome as 'Nome', endereco as 'Endereço', fone as 'Telefone', email as 'E-mail' from tbclientes;


desc tbos;
select * from tbos;

select id as 'Id', nome as 'Nome', fone as 'Telefone' from tbclientes where nome like '%d%' order by nome asc;

insert into tbos (tipo, situacao, equipamento, defeito, servico, valor,id_cliente, id_usuario_tecnico) 
                values ('Ordem de Serviço','Na Bancada','celular','tela quebrada','trocar tela','250.00','15','1');


select * from tbos where os = 2;

update tbos set 
tipo = 'Ordem de Serviço', 
situacao = 'Aguardando Entrega', 
equipamento = 'celular', 
defeito = 'não liga', 
servico = 'trocar bateria', 
valor = '200.00', 
id_usuario_tecnico = '3' 
where os = 2;

select os, date_format(data_os, '%d/%m/%Y - %H:%i') as data_os, tipo, situacao, equipamento, defeito, servico, valor, id_cliente, id_usuario_tecnico from tbos where os = 2;

select * from tbclientes order by nome;

#################

select 
OS.os as 'OS', date_format(OS.data_os, '%d/%m/%Y - %H:%i') as 'Data OS', OS.tipo as 'Tipo', OS.situacao as 'Situação', OS.equipamento as 'Equipamento', OS.valor as 'Valor R$',
CLI.nome as 'Cliente', CLI.fone as 'Telefone',
US.usuario as 'Usuário'
from tbos as OS 
inner join tbclientes as CLI
inner join tbusuarios as US
on CLI.id = OS.id_cliente and US.id = OS.id_usuario_tecnico;

select 
OS.os, date_format(OS.data_os, '%d/%m/%Y') as data_os, OS.tipo, OS.situacao, OS.equipamento , OS.valor,
CLI.nome, CLI.fone,
US.usuario
from tbos as OS 
inner join tbclientes as CLI
inner join tbusuarios as US
on CLI.id = OS.id_cliente and US.id = OS.id_usuario_tecnico;


select 
OS.os, date_format(OS.data_os, '%d/%m/%Y') as data_os, OS.tipo, OS.situacao, OS.equipamento, OS.defeito, OS.servico, OS.valor,
CLI.nome, CLI.fone,
US.usuario
from tbos as OS 
inner join tbclientes as CLI
inner join tbusuarios as US
on CLI.id = OS.id_cliente and US.id = OS.id_usuario_tecnico where os = 1;

select * from tbos;
select max(os) from tbos;