mysql:
	docker compose -f ./tester/mysql/compose.yml up -d

dmysql:
	docker compose -f ./tester/mysql/compose.yml down
	@docker rmi mysql-mysql
	@docker rmi mysql-php

sqlite:
	docker build . -t php -f ./tester/sqlite/Dockerfile
	docker run -p 7979:80 --name php -d -t php

dsqlite:
	docker stop php
	docker rm php
	docker rmi php

rmysql: dmysql mysql

rsqlite: dsqlite sqlite
