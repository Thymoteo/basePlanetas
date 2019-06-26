create table classe_Planeta (
	id_classe char not null,
    descricao varchar(100) not null,
    primary key (id_classe)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

create table tipo_atmosfera (
	id_tipo_atmosfera int not null auto_increment,
    descricao varchar(100) not null,
    primary key (id_tipo_atmosfera)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

create table quadrante_estelar (
	id_quadrante int not null auto_increment,
    descricao varchar(100) not null,
    primary key (id_quadrante)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

create table planeta (
	id_planeta int(11) not null auto_increment,
    nome varchar(100) not null,
	massa int(11) not null,
    diametro int(11) not null,
    planeta_colonizado boolean,
    data_descobrimento datetime not null,
    id_classe char not null,
    id_tipo_atmosfera int not null,
    id_quadrante int not null,
    primary key (id_planeta),
    foreign key (id_classe) references classe_Planeta(id_classe),
    foreign key (id_tipo_atmosfera) references tipo_atmosfera(id_tipo_atmosfera),
    foreign key (id_quadrante) references quadrante_estelar(id_quadrante)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
