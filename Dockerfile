FROM java:8

EXPOSE 8081

ADD target/fullcurdOperation.jar fullcurdOperation.jar


ENTRYPOINT [ "java"."-jar","fullcurdOperation.jar"]