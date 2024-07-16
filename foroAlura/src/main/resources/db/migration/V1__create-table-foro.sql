create table foros(

     id bigint not null auto_increment,
     nombre varchar(100) not null,
     tipo varchar(100) not null
     direccion varchar(100) not null unique,

     primary key(id)

);