#!/bin/bash
chmod -R 777 /var/jenkins_home/workspace/teste
docker run --name Nginx -p:81:80 -d nginx
     









