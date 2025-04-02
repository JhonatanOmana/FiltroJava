
use booojtm25ixmoq6gzllr;

create table Ninja(
ID int auto_increment primary key,
Nombre varchar(100),
Rango varchar(100),
Aldea varchar(100)
);

create table Mision(
ID int auto_increment primary key,
Descripcion varchar(100),
Rango varchar(100),
Recompensa varchar(100)
);

create table MisionNinja (
ID_Ninja int,
ID_Mision int,
FechaInicio date,
FechaFin date,
primary key (ID_Ninja,ID_Mision),
foreign key (ID_Ninja) references Ninja(ID),
foreign key (ID_Mision) references Mision(ID)
);

create table Habilidad(
ID_Ninja int,
Nombre varchar(100),
Descripcion varchar(100),
primary key (ID_Ninja, nombre),
foreign key (ID_Ninja) references Ninja(ID)
);