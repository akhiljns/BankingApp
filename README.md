# following project contains the repository for sample hall booking system


requirements - 
maven
java

## steps to build the project and run it:

- ./mvnw clean install
- ./mvnw spring-boot:run

OR

I have also kept jar of the project which can be run without having to build using maven build by (from project home directory)
- java -jar target/hallBookingSystem-0.0.1-SNAPSHOT.jar

## testing the project APIs using postman or curl

1) RESERVE A HALL

HTTP method - POST 
url - http://localhost:8080/booker/halls/book
post sample data - 
{
    "booking_Id":2,
    "capacity":100,
    "start_Time":"2019-12-31T02:00:00",
    "end_Time":"2019-12-31T03:00:00"
}

sample curl command for the same - 

curl -X POST -H 'Content-Type: application/json' -i http://localhost:8080/booker/halls/book --data '{
"booking_Id":2,
"capacity":100,
"start_Time":"2019-12-31T02:00:00",
"end_Time":"2019-12-31T03:00:00"
}'

sample response - 
{
  "hall_id": 2,
  "capacity": 100,
  "request": [{
    "booking_Id": 1,
    "capacity": 100,
    "start_Time": "2019-12-31T02:00:00.000+00:00",
    "end_Time": "2019-12-31T03:00:00.000+00:00"
  }]
}

2) FETCH DETAILS OF SCHEDULED SEMINARS FOR A DATE RANGE

HTTP method - GET 
url - http://localhost:8080/booker/seminars/2019-12-31 02:00:00/2020-01-31 02:00:00

sample curl command for the same - 

curl -X GET -i 'http://localhost:8080/booker/seminars/2019-12-31 02:00:00/2020-01-31 02:00:00'

sample response - 
[{
  "booking_Id": 1,
  "capacity": 100,
  "start_Time": "2019-12-31T02:00:00.000+00:00",
  "end_Time": "2019-12-31T03:00:00.000+00:00"
}]

## steps to view the database using h2 console on web browser

url to hit on browser http://localhost:8080/h2-console/
click on connect button


