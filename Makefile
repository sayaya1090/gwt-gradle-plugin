LATEST_TAG  ?= `git tag|sort -t. -k 1,1n -k 2,2n -k 3,3n -k 4,4n | tail -1`
PROJECT_DIR := $(shell dirname $(realpath $(lastword $(MAKEFILE_LIST))))
BUILD_DIR   := ${PROJECT_DIR}/build

help:
	cat Makefile.txt

clean:
	./gradlew clean

.PHONY: build
build:
	${PROJECT_DIR}/gradlew build --warning-mode all

version:
	./gradlew currentVersion --warning-mode all

release:
	./gradlew release --warning-mode all

publish-local: build
	rm -rf $$HOME/.m2/repository/org/docstr/gwt
	${PROJECT_DIR}/gradlew publishToMavenLocal --warning-mode all

publish-maven: build
	rm -rf $$HOME/.m2/repository/org/docstr/gwt
	git checkout tags/${LATEST_TAG}
	${PROJECT_DIR}/gradlew publishMavenJavaPublicationToMavenLocal publishMavenJavaPublicationToMavenRepository
	git checkout main

publish: build
	rm -rf $$HOME/.m2/repository/org/docstr/gwt
	${PROJECT_DIR}/gradlew publishPlugins --warning-mode all
	git checkout main

site:
	cd ${PROJECT_DIR}/doc && docstr site build && cd ${PROJECT_DIR}/../dn-hosting-sites && make deploy-gwtgradle
