mysql:
	docker build -t test-mysql tester/mysql
	docker run -d --name mysql -p 3306:3306 -v ./data_mysql:/var/lib/mysql test-mysql


down:
	@docker stop mysql
	@docker rm mysql