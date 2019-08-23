#########################################################################
# File Name: set-mysql-firewall.sh
# Author: chaofei
# mail: chaofeibest@163.com
# Created Time: 2019-08-23 15:14:57
#########################################################################
#!/bin/bash

#添加需要监听的端口
sudo /sbin/iptables -I INPUT -p tcp --dport 3306 -j ACCEPT
#保存设置
sudo iptables-save
#查看状态
systemctl status firewalld.service
