create table Funcionario(
	id SERIAL UNIQUE,
   cpf varchar(30) NOT NULL,
   nome varchar(100) NOT NULL
);

create table Veiculo(
	id SERIAL UNIQUE,
   Placa VARCHAR (20) NOT NULL,
   Marca VARCHAR (50) NOT NULL,
   KmPorLitro FLOAT NOT NULL
);

create table Chamado(
	id SERIAL,
   DistanciaKm int NOT NULL,
   funcionario int NOT NULL,
   veiculo int NOT NULL,
   constraint fk_id_funcionario foreign key (funcionario) references Funcionario (id),
	constraint fk_id_veiculo foreign key (veiculo) references Veiculo (id)
);