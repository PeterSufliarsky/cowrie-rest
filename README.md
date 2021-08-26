# Cowrie REST

## REST API serving data collected by the Cowrie honeypot  

## About

The Cowrie honeypot can store collected data in MySQL or MongoDB. This REST API written in Java serves that data in JSON format. It can be used by web front-ends to display honeypot statistics and analyze the collected data.

**Development in progress**

## Usage

**GET /sessions/{id}**  
Get session identified by the given ID  
  
Sample request:
```
GET /sessions/5962f1d02874
```
Sample response:
```
{
  "id":"c2a7c72a8d34",
  "ip":"192.168.0.11",
  "sensor":"cowrie",
  "startTime":"2020-07-20T00:00:09",
  "endTime":"2020-07-20T00:00:15",
  "client":"SSH-2.0-libssh-0.6.3"
}
```

**GET /sessions?date=today**  
Get all sessions for the current day

**GET /sessions?date=yesterday**  
Get all sessions for the previous day

**GET /sessions?date={year}{month}{day}**  
Get all sessions for the given day.

Sample request:
```
GET /sessions?date=20191108
```

## Requirements

* JDK 11
* Apache Maven 3.6.1+

## Build and deployment

1. Clone the repository
2. Configure the database access in src/main/resources/application.properties
3. From the project directory run
```
mvn spring-boot:run
```
4. By default, the API is running on port 8080
5. (optional) Build a war file which you can deploy with Apache Tomcat
```
mvn clean package
```

## TODO
- [ ] Provide further data from the honeypot
- [ ] Data aggregation
- [ ] Pagination
- [ ] API authentication

