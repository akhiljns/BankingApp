# following project contains the repository for sample banking app


requirements - 
maven
java

## steps to build the project and run it:

- ./mvnw clean install
- ./mvnw spring-boot:run

OR

I have also kept jar of the project which can be run without having to build using maven build by (from project home directory)
- java -jar target/app-0.0.1-SNAPSHOT.jar

## testing the project APIs using postman or curl

1) OPEN ACCOUNTS
HTTP method - POST
url - http://localhost:8080/account/open
REQUEST BODY sample data - 
{
  "account_number":1,
  "balance_value":234,
  "transactions": [{
    "transaction_id": 1,
    "transaction_type": "CREDIT",
    "transaction_amount": 2,
    "transaction_timestamp": "2021-04-29T03:00:00.000+00:00"
  },
  {
    "transaction_id": 3,
    "transaction_type": "CREDIT",
    "transaction_amount": 3,
    "transaction_timestamp": "2021-04-30T03:00:00.000+00:00"
  },
  {
    "transaction_id": 2,
    "transaction_type": "DEBIT",
    "transaction_amount": 1,
    "transaction_timestamp": "2021-03-30T03:00:00.000+00:00"
  }]
}

curl -X POST -H 'Content-Type: application/json' -i http://localhost:8080/account/open --data '{
  "account_number":1,
  "balance_value":234,
  "transactions": [{
    "transaction_id": 1,
    "transaction_type": "CREDIT",
    "transaction_amount": 2,
    "transaction_timestamp": "2021-04-29T03:00:00.000+00:00"
  },
  {
    "transaction_id": 3,
    "transaction_type": "CREDIT",
    "transaction_amount": 3,
    "transaction_timestamp": "2021-04-30T03:00:00.000+00:00"
  },
  {
    "transaction_id": 2,
    "transaction_type": "DEBIT",
    "transaction_amount": 1,
    "transaction_timestamp": "2021-03-30T03:00:00.000+00:00"
  }]
}'

sample curl command for the same - 

2) CREATE TRANSACTIONS

HTTP method - PUT 
url - http://localhost:8080/account/createTransaction 
REQUEST BODY sample data - 
{
    "senderAccountNo":2,
    "recepientAccountNo":1,
    "amount":2
}

sample curl command for the same - 

curl -X PUT -H 'Content-Type: application/json' -i http://localhost:8080/account/createTransaction --data '{
"senderAccountNo":1,
"recepientAccountNo":2,
"amount":2
}'


3) FETCH STATEMENT OF AN ACCOUNT

HTTP method - POST 
url - http://localhost:8080/account/statement
REQUEST BODY sample data - 
{
  "accNo":1,
  "fromTimestamp":"2021-05-22T23:11:50.934+00:00",
  "toTimestamp":"2021-05-22T23:40:50.934+00:00",
}

sample curl command for the same - 

curl -X POST -H 'Content-Type: application/json' -i http://localhost:8080/account/statement --data '{
"accNo":1,
"fromTimestamp":"2021-05-22T23:11:50.934+00:00",
"toTimestamp":"2021-05-22T23:40:50.934+00:00"
}'

## steps to view the database using h2 console on web browser

url to hit on browser http://localhost:8080/h2-console/
click on connect button


