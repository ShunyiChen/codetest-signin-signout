drop table tb_user if exists;
drop table tb_user_token if exists;
CREATE TABLE tb_user(id IDENTITY PRIMARY KEY,username VARCHAR(64),password VARCHAR(128), admin BOOLEAN);
CREATE TABLE tb_user_token(id IDENTITY PRIMARY KEY,token VARCHAR(255));


