-- Active: 1731087758247@@127.0.0.1@3306@bankmanagementsystem
show DATABASES;

use bankmanagementsystem;

CREATE table signup_1(
    formno VARCHAR(20), 
    name VARCHAR(20), 
    father_name VARCHAR(20), 
    dob VARCHAR(20), 
    gender VARCHAR(20), 
    email VARCHAR(30), 
    marital_status VARCHAR(20), 
    address VARCHAR(50), 
    city VARCHAR(30), 
    pincode VARCHAR(20), 
    state VARCHAR(30)
    );

CREATE TABLE signup_2 (
    formno VARCHAR(20),
    religion VARCHAR(20),
    category VARCHAR(20),
    income VARCHAR(20),
    education VARCHAR(20),
    occupation VARCHAR(20),
    pan VARCHAR(20),
    aadhar VARCHAR(20),
    seniorcitizen VARCHAR(20),
    existingaccount VARCHAR(20)
);

CREATE TABLE signup_3 (
    formno VARCHAR(20),
    accountType VARCHAR(40),
    cardNumber VARCHAR(25),
    pin VARCHAR(10),
    facility VARCHAR(100)
);


CREATE TABLE login(
    formno VARCHAR(20),
    cardNumber VARCHAR(25),
    pin VARCHAR(10)
);


CREATE TABLE bank(
    pin VARCHAR(10),
    date VARCHAR(50),
    type varchar(20),
    amount VARCHAR(50)
);

drop Table signup_1, signup_2, signup_3, bank, login;



show TABLES;



SELECT * FROM signup_1;

SELECT * FROM signup_2;

SELECT * FROM signup_3;

SELECT * FROM bank;

SELECT * FROM login;

