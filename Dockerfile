FROM amazoncorretto:17

EXPOSE 8080 8081

#RUN ln -sf /usr/share/zoneinfo/Asia/Ho_Chi_Minh /etc/localtime

#RUN apk add --no-cache curl
#RUN rm -rf /var/cache/apk/*

ADD target/dashboard-0.0.1-SNAPSHOT.jar dashboard-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/dashboard-0.0.1-SNAPSHOT.jar"]