CREATE TABLE IF NOT EXISTS osworks.comentarios(
    id int not null auto_increment,
    ordem_servico_id int not null ,
    descricao text not null,
    data_envio datetime not null,

    primary key(id));
);

alter table osworks.comentarios add constraint fk_comentario_ordem_servico
foreign key(ordem_servico_id) references ordem_servico (id);