run: build

runall: build inquisitor

build:
	@echo " Starting environment.. "
	@docker compose up -d
	@docker exec -it server chmod -R 755 /home/username

down:
	@docker compose down

INFO=$(shell echo $(shell docker inspect filezilla --format='{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}') $(shell docker inspect filezilla --format='{{range .NetworkSettings.Networks}}{{.MacAddress}}{{end}}') $(shell docker inspect server --format='{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}') $(shell docker inspect server --format='{{range .NetworkSettings.Networks}}{{.MacAddress}}{{end}}'))

info:
	@echo $(INFO)

inquisitor:
	docker exec -it python python3 inquisitor.py $(INFO)