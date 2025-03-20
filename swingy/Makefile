build:
	$(MAKE) database
	$(MAKE) jarfile

jarfile:
	mvn clean package
	@cp target/swingy.jar .

database:
	docker build . -t mysql -f ./mysql/Dockerfile
	docker run -d --name mysql -p 3310:3306 mysql

down:
	docker stop mysql
	docker rm mysql
	docker image rm mysql