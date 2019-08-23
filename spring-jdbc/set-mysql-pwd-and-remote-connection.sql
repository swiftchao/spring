use mysql; 
update user set password=PASSWORD("123456") where user="root";
FLUSH PRIVILEGES;
grant all privileges on *.* to 'root'@'%' identified by '123456' with grant option;
GRANT ALL PRIVILEGES ON *.* TO ' root,'@'172.16.62.172' IDENTIFIED BY '123456';
FLUSH PRIVILEGES;
