[![Codacy Badge](https://api.codacy.com/project/badge/Grade/56f4826f4e3941259ebd868bd847074d)](https://app.codacy.com/gh/PeterSufliarsky/cowrie-rest?utm_source=github.com&utm_medium=referral&utm_content=PeterSufliarsky/cowrie-rest&utm_campaign=Badge_Grade_Settings)
[![deepcode](https://www.deepcode.ai/api/gh/badge?key=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJwbGF0Zm9ybTEiOiJnaCIsIm93bmVyMSI6IlBldGVyU3VmbGlhcnNreSIsInJlcG8xIjoiY293cmllLXJlc3QiLCJpbmNsdWRlTGludCI6ZmFsc2UsImF1dGhvcklkIjoyMzI3MSwiaWF0IjoxNjA3MjAzNTUxfQ.jcJHS0pqPlVz7JG6MdL1ullDqUyn-nVoPyG2QJD2o8U)](https://www.deepcode.ai/app/gh/PeterSufliarsky/cowrie-rest/_/dashboard?utm_content=gh%2FPeterSufliarsky%2Fcowrie-rest)

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

