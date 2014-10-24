#!/bin/sh
#@Depected 此shell过期不用
#先手动插入MySQL的数据，然后运行此脚本，把MySQL的数据自动同步到Redis上来

REDIS_CLINE="/home/uniweibo/redis/redis-2.6.13/src/redis-cli -h 127.0.0.1 -p 6379"
MYSQL_CLINE="/home/uniweibo/mysql/mysql-5.5.32/bin/mysql -uroot -pweilianbo --port=4306 -h 127.0.0.1"

$REDIS_CLINE <<EOF
	select 5
	lpush uro:11011 rore:1	
EOF

$MYSQL_CLINE <<EOF
	use uni_privileges;
	select * from users;
EOF