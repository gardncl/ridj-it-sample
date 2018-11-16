# Ridj-It Sample [![Build Status](https://travis-ci.org/gardncl/ridj-it-sample.svg?branch=master)](https://travis-ci.org/gardncl/ridj-it-sample)

## Checklist

 - [ ] Implement rendering of a List of destination with ability to get full details on particular trip.
   - [ ] Implement rendering list of destinations that each contain list of trip ids
   - [x] Implement get for a single trip for "get full details on particular trip"
 - [x] Implement ability to update an existed trip via REST call.
 - [x] Implement deleting of existed trip.

## Setup database
1. Install docker
2. Copy `docker-compose.yml.example` to `docker-compose.yml`
3. Give your docker file a real volume to store data then run it
4. Connect to your database `psql -p 5432`
5. Create a role for `dev` which is who we are connecting as
```sql
CREATE USER dev;
```
6. Create the database we are connecting to
```sql
CREATE DATABASE ridjit;
```
7. You're ready!

## Prompt

Imagine you work on a web application based around an MVC framework.

There is a page or rather API endpoint that displays (returns) a list of destinations (trips) with some information including Trip ID. These destinations are pulled from a database that supports this application. Assuming destination (trip) has a clickable attribute, when clicked it pulls all available trip information.

To demonstrate your understanding of frameworks and your coding style please detail what steps you would take to implement these features, it is your choice whether to implement a proper MVC view or a REST-like controller responses with JSON. Solution is not required to be in customer shipping state, as it primarily serves a purpose of demonstrating your backend skills.
1) Implement rendering of a List of destination with ability to get full details on particular trip.
2) Implement ability to update an existed trip via REST call.
3) Implement deleting of existed trip.


Sample model (UML):

 Trip
————————
 -id: Long
 -name: String
 -description: String
 -date: Date
 -displayAttributes: Map<String, String>
 -location: Location
 ...

 Location
——————————
 -id: Long
 -name: String
 -address: String
 -city: String
 -state: String
 ...

Required stack:
-Spring;
-Backed by PostgresSQL/MySQL with ORM via Hibernate.

You may extend or add as many fields as you want, as model above has a typical set of properties you would expect, but please use proposed properties for this test assignment.

Your answer is encouraged to have a working code, however if time is a constraint, feel free to fill in with pseudo code to give broad strokes to some of the functionality.

You can include your answer in one text file with headings to denote the different files you might put code in.
ORM_test.txt
Displaying ORM_test.txt.
