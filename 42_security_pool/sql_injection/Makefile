mysql:
	docker compose -f ./tester/mysql/compose.yml up -d

dmysql:
	docker compose -f ./tester/mysql/compose.yml down
	@docker rmi mysql-mysql
	@docker rmi mysql-php