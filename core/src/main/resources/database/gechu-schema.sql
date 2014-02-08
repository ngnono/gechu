
USE Gechu;

-- user account

DROP TABLE IF EXISTS Permission;

create table Permission(
    Id int not null AUTO_INCREMENT
    ,Name varchar(80) not null
    ,constraint pk_id primary key(id)
);

DROP TABLE if EXISTS Role;

create table Role(
    Id int not null AUTO_INCREMENT
    ,Name varchar(80) not null
    ,constraint pk_id primary key(id)
);


DROP TABLE if EXISTS User;

create table User(
    Id int not null AUTO_INCREMENT
    ,Username varchar(80) not null
    ,Password varchar(256) not null
    ,constraint pk_id primary key(id)
);


DROP TABLE if EXISTS UserRoleRelation;

create table UserRoleRelation(
    Id int not null AUTO_INCREMENT
    ,User_Id int not null
    ,Role_Id int not null
    ,constraint pk_id primary key(id)
);

DROP TABLE if EXISTS RolePermissionRelation;

create table RolePermissionRelation(
    Id int not null AUTO_INCREMENT
    ,Role_Id int not null
    ,Permission_Id int not null
    ,constraint pk_id primary key(id)
);


-- user account end