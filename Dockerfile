FROM eclipse-temurin:21-jammy as jre-build

RUN $JAVA_HOME/bin/jlink \
	--add-modules java.base,java.compiler,java.desktop,java.instrument,java.management,java.naming,java.net.http,java.prefs,java.scripting,java.security.jgss,java.security.sasl,java.sql,jdk.jfr,jdk.unsupported \
	--strip-debug \
	--no-man-pages \
	--no-header-files \
	--output /javaruntime

FROM debian:trixie-slim as brain-build

ENV JAVA_HOME=/opt/jdk
ENV PATH "${JAVA_HOME}/bin:${PATH}"

WORKDIR /application

COPY --from=jre-build /javaruntime $JAVA_HOME
COPY target/onecraft-spring-workshops-*.jar application.jar

RUN java -Djarmode=layertools -jar application.jar extract

FROM debian:trixie-slim

ENV JAVA_HOME=/opt/jdk
ENV PATH "${JAVA_HOME}/bin:${PATH}"

WORKDIR /application

COPY --from=jre-build /javaruntime $JAVA_HOME
COPY --from=brain-build /application/dependencies/ ./
COPY --from=brain-build /application/spring-boot-loader/ ./
COPY --from=brain-build /application/snapshot-dependencies/ ./
COPY --from=brain-build /application/application/ ./

ENTRYPOINT ["java", "-XX:+UseStringDeduplication", "-XX:+UseContainerSupport", "org.springframework.boot.loader.launch.JarLauncher"]