FROM tomcat:9.0.69-jdk11
ADD ./target/FourT-Shop-E-commerce.war /usr/local/tomcat/webapps/FourT-Shop-E-commerce.war
CMD ["catalina.sh", "run"]