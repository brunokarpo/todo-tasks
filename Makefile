# Maven
.PHONY: _clean
_clean:
	./mvnw clean


.PHONY: _build
_build: _clean
	./mvnw install

