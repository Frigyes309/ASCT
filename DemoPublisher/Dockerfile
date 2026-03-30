FROM openjdk:11
COPY ./libs /app
COPY ./rti_license.dat /app/rti_license.dat
ARG main
ENV main=$main
COPY ./build/libs/DemoPublisher-1.0-SNAPSHOT-all.jar /app/app.jar
WORKDIR /app
CMD LD_LIBRARY_PATH=. java -cp app.jar $main