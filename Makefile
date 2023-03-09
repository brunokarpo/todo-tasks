# Maven
.PHONY: _clean
_clean:
	./mvnw clean


.PHONY: _build
_build: _clean
	./mvnw install

.PHONY: build
build: _clean _build

.PHONY: run-locally
run-locally: build
	./mvnw spring-boot:run -f app/startup

#########################################
### INFRA

### Database

.PHONY: _db-start
_db-start:
	$(MAKE) -C infra/db start

.PHONY: db-migrate
db-migrate:
	$(MAKE) -C infra/db migrate

.PHONY: db-initialize
db-initialize: _db-start db-migrate

.PHONY: db-stop
db-stop:
	$(MAKE) -C infra/db stop