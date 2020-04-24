create table osworks.cliente (
    id int not null auto_increment,
    nome varchar(55) not null,
    email varchar(255) not null,
    telefone varchar(55) not null,

    primary key (id)
);