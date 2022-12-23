FROM tomcat:9.0.69-jdk11
RUN rm -rvf /usr/local/tomcat/webapps/ROOT
ADD /target/FourT-Shop-E-commerce.war /usr/local/tomcat/webapps/ROOT.war
CMD ["catalina.sh", "run"]