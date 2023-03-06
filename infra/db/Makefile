#######################################
### POSTGRES DATABASE

.PHONY: start
start:
	docker container run -d --rm --name tasks-postgres \
			-e POSTGRES_USER=tasks-postgres \
			-e POSTGRES_PASSWORD=tasks-postgres \
			-e POSTGRES_DB=tasks-postgres \
			-p 5432:5432 \
			postgres:14.4;
	sleep 5

stop:
	docker container stop tasks-postgres || echo "no tasks-postgres found"



########################################
### MIGRATIONS
migrate:
	$(MAKE) _run command=migrate

_run:
	docker run --rm --name tasks-postgres-flyway \
		-v ${CURDIR}/conf:/flyway/conf \
		-v ${CURDIR}/migrations:/flyway/sql \
		--network host \
		flyway/flyway:9.6.0 -configFiles=/flyway/conf/.conf-local $(command)