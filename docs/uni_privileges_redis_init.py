#!/usr/bin/env python
# -*- coding: utf-8 -*-

#先手动插入MySQL的数据，然后运行此脚本，把MySQL的数据自动同步到Redis上来


import os,sys
import MySQLdb
import redis

try:
	mysql_connect = MySQLdb.connect(host = '127.0.0.1', user = 'root', passwd = 'weilianbo', db = 'uni_privileges', port=4306, charset='utf8')
	redis_connect = redis.Redis(host='127.0.0.1', port=6379, db=5)
	#pipe = r.pipeline()
except MySQLdb.Error, e:
	print "Error %d:%s"%(e.args[0],e.args[1])
	exit(1)
except redis.ConnectionError, e:
	print "Error %d:%s"%(e.args[0],e.args[1])
	exit(1)


uro_sql = "select uro.u_id ,uro.ro_id from users u \
			inner join user_role uro on u.u_id = uro.u_id"

rore_sql = "select rore.ro_id, re.url, re.type from role_resource rore \
			inner join resources re on rore.re_id = re.re_id"

ure_sql = "select ure.u_id, re.url, re.type from user_resource ure \
			inner join resources re on ure.re_id = re.re_id"

ubl_sql = "select ure.u_id, re.url, re.type from user_block ure \
			inner join resources re on ure.re_id = re.re_id"


#把userid与roleid对应的信息add到redis
uro_cur = mysql_connect.cursor()
uro_cur.execute(uro_sql)
uro_result = uro_cur.fetchall()

for r in uro_result:
	uroIndex = "uro:" + str(r[0]) 
	roreIndex = "rore:" + str(r[1])
	redis_connect.lpush(uroIndex, roreIndex)
	#print redis_connect.lrange(uroIndex, 0, -1)


#把roleid与resource对应的信息add到redis
rore_cur = mysql_connect.cursor()
rore_cur.execute(rore_sql)
rore_result = rore_cur.fetchall()

for r in rore_result:
	roreIndex = "rore:" + str(r[0])
	roreVal = str(r[2]) + ":" + str(r[1]) 
	redis_connect.sadd(roreIndex, roreVal)
	


#把userid与resource对应的信息add到redis
ure_cur = mysql_connect.cursor()
ure_cur.execute(ure_sql)
ure_result = ure_cur.fetchall()

for r in ure_result:
	ureIndex = "ure:" + str(r[0])
	ureVal = str(r[2]) + ":" + str(r[1]) 
	redis_connect.sadd(ureIndex, ureVal)


#把userid与resource对应的reject的信息add到redis
ubl_cur = mysql_connect.cursor()
ubl_cur.execute(ubl_sql)
ubl_result = ubl_cur.fetchall()

for r in ubl_result:
	ublIndex = "ubl:" + str(r[0])
	ublVal = str(r[2]) + ":" + str(r[1]) 
	redis_connect.sadd(ublIndex, ublVal)




uro_cur.close()

mysql_connect.close()

#r.close()

