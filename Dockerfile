FROM adoptopenjdk/openjdk11

ADD target/oms-project.jar oms-project.jar

ENTRYPOINT [ "java" , "-jar" ,"/oms-project.jar" ]