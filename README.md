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
  "id":"5962f1d02874",
  "startTime":"2019-11-08T20:12:15",
  "endTime":"2019-11-08T20:12:17",
  "sensor":{
    "id":1,
    "ip":"cowrie"
  },
  "ip":"127.0.0.1",
  "termSize":null,
  "client":{
    "id":1414,
    "version":"b'SSH-2.0-Go'"
  }
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
```
git clone https://github.com/PeterSufliarsky/cowrie-rest/
```
2. Move to the project directory
```
cd cowrie-rest
```
3. Build with maven:
```
mvn clean package
```
4. Run
```
java -jar target/cowrie-rest-*.jar
```
5. By default, the API is available on port 8080

## TODO
- [ ] Provide further data from the honeypot
- [ ] Data aggregation
- [ ] Pagination
- [ ] API authentication

