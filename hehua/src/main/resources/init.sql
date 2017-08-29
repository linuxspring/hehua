create user nsgeoinfo identified by nsgeoinfo;
create tablespace nsgeoinfo datafile 'D:\OracleDatabase\nsgeoinfo.ora' size 60M autoextend on
maxsize 32676M   nologging
online
permanent extent management local autoallocate
blocksize 8k
segment space management auto
flashback on;
alter user nsgeoinfo default tablespace nsgeoinfo;
grant dba, resource, connect,create table,create type,create view,create session to nsgeoinfo;
