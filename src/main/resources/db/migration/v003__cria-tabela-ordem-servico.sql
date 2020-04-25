CREATE TABLE IF NOT EXISTS osworks.ordem_servico(
id INT NOT NULL AUTO_INCREMENT,
cliente_id INT NOT NULL,
descricao TEXT NOT NULL,
preco DECIMAL(10,2) NOT NULL,
status VARCHAR(30) NOT NULL,
data_abertura DATETIME NOT NULL,
data_finalizacao DATETIME,
PRIMARY KEY(id));

alter table osworks.ordem_servico add constraint fk_ordem_servico_cliente
foreign key(cliente_id) references cliente(id) ;
