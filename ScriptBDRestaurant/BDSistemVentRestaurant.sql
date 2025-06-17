create database bdRestaurant;
use bdRestaurant;

CREATE TABLE Clientes (
    cliente_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    telefono VARCHAR(20),
    direccion VARCHAR(255),
    email VARCHAR(100)
);
create table Pedido (
	pedido_id int auto_increment primary key,
    plato varchar(200),
    cantidad int
);
create table Registro_pedido (
    registro_id int auto_increment primary key,
    cliente_id int,
    pedido_id int,
    fecha datetime default current_timestamp,
    foreign key (cliente_id) references Clientes(cliente_id),
    foreign key (pedido_id) references Pedido(pedido_id)
);
	

    


