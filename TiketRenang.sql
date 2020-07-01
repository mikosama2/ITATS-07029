Database
username : alexander_07029
password : alexander

create tablespace alex_07029
datafile ‘E:\tiketrenang.dbf’
size 30M;

create user alexander_07029
identified by alexander
default tablespace alex_07029
quota 30M on alex_07029;

grant all privileges to alexander_07029;

conn alexander_07029/alexander



create table Kasir_07029
(
Id_kasir INTEGER not null,
Nama_kasir VARCHAR2(15),
Password_kasir VARCHAR2(15),
constraint PK_kasir primary key (Id_kasir)
);

create table Member_07029
(
Id_member INTEGER not null,
Nama_member VARCHAR2(15),
No_telp_member NUMBER(12),
constraint PK_member primary key (Id_member)
);

create table Pembayaran_07029
(
Id_pembayaran INTEGER not null,
Id_kasir INTEGER,
Id_member INTEGER,
Tanggal_pembayaran DATE,
Harga_tiket NUMBER(5),
Banyak_tiket NUMBER(2),
Total NUMBER(7),
constraint PK_pembayaran primary key (Id_pembayaran)
);


create sequence id_pembayaran
minvalue 1
maxvalue 9999
start with 1
increment by 1
nocache;

create sequence id_member
minvalue 1
maxvalue 9999
start with 1
increment by 1
nocache;

alter table Member_07029
add constraint AK_member_notelp UNIQUE (No_telp_member);


create view list_kasir as select * from kasir_07029;

CREATE SEQUENCE id_member
MINVALUE 1
MAXVALUE 999
START WITH 1
INCREMENT BY 1
NOCACHE;

CREATE SEQUENCE id_pembayaran
MINVALUE 1
MAXVALUE 999
START WITH 1
INCREMENT BY 1
NOCACHE;
