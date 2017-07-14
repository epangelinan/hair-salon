# _Hair Salon_

#### _This web application allows the user to add hair stylists and their corresponding clients, July 14, 2017_

#### By _**Esvethlynna Pangelinan**_

## Description

_This is a web app that allows the user to view the list of stylists and their corresponding clients.  It also allows the user to add new stylists and clients, update the stylist and client details, and delete the stylist and client._

## Setup/Installation Requirements

* _At terminal, enter postgres_
* _In a different terminal window, enter psql_
* _Create the databases and tables as follows. In psql, enter:_
* _CREATE DATABASE hair_salon;_
* _\c to_do;_
* _CREATE TABLE clients (id serial PRIMARY KEY, name varchar, stylistID int);_
* _CREATE TABLE stylists (id serial PRIMARY KEY, name varchar);_
* _CREATE DATABASE hair_salon_test WITH TEMPLATE hair_salon;_
* _To run the program, go into the project folder on the terminal and enter gradle run_
* _In the browser, enter localhost:4567_

## To Backup Databases:
* _Clear the tables (skip the first two DELETE steps if you want to keep the data in the database):  from psql, enter:_
* _DELETE FROM clients;_
* _DELETE FROM stylists;_
* _DROP DATABASE hair_salon_test;_
* _In your "normal" terminal window, not psql, enter: pg_dump hair_salon > media.sql_
* _Add changes via add . and commit your changes_
* _Upload project to Github._

## To Restore Databases:
* _Clone or download the hair-salon project from Github_
* _At terminal, enter postgres_
* _In a different terminal window, enter psql_
* _From psql, run: CREATE DATABASE hair_salon;_
* _Run the following command in the terminal (not psql): psql hair_salon < media.sql_
* _Confirm success.  Switch to psql and run:  \c hair_salon_
* _Then run: \dt_

## Known Bugs
_No known issues that I am aware of._

## Support and contact details

_If you have any questions or suggestions, please contact Lynn at esveth@aol.com_

## Technologies Used

_Java, Gradle, Spark, JUnit, Velocity, Postgres, HTML, CSS, Bootstrap_

### License

*This software is licensed under the MIT license.*

Copyright (c) 2017 **_Esvethlynna Pangelinan_**
