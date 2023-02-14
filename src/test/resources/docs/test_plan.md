## Table of Contents
1. [Test Plan Introduction](#1-test-plan-introduction)
2. [Test Objects](#2-test-objects)
3. [Tested Features](#3-tested-features)
4. [Test Type](#4-test-type)
5. [Test Objectives](#5-test-objectives)
6. [Test Model](#6-test-model)

## 1. Test Plan Introduction
This test plan describes required test activities

## 2. Test Object
<a href="https://restful-booker.herokuapp.com/apidoc/index.html" target="_blank">restful-booker API</a>

Test object is Restful Booker API. This test suite is related CRUD operations and some edge cases.
It is not a comprehensive test suite. There is no any NFR test. It can be done by using any tool
like JMeter, Gatling, or etc.

## 3. Requirement Traceability Matrix
| Traceability Matrix           | Create Booking | Delete Booking | Get Booking By Id | Get Booking Ids | Health Check | Update Booking | Partial Update Booking  |
| ------------------------------|----------------|----------------|-------------------|-----------------|--------------| ---------------|-------------------------|
| CreateBooking.feature         | x              |                |                   |                 |              |                |                         |
| DeleteBooking.feature         |                | x              |                   |                 |              |                |                         |
| GetBookingById.feature        |                |                | x                 |                 |              |                |                         |
| GetBookingIds.feature         |                |                |                   | x               |              |                |                         |
| HealthCheck.feature           |                |                |                   |                 | x            |                |                         |
| UpdateBooking.feature         |                |                |                   |                 |              |x               |                         |
| PartialUpdateBooking.feature  |                |                |                   |                 |              |                | x                       |

## 4. Test Type
It is a functional API testing which each feature is tested individually.
Even there is no dependency between tests, tests run sequentially in a correct order.

## 5. Test Objectives
To verify the requirements which I specified in the "Tested Feautures" have been fulfilled.
Also to validate whether test object works as the user expects.

# 6. Test Model
The functional tests in this project follow "Arrange-Act-Assert" zephyr.model:

* Arrange, or set up: Pre conditions for the test
* Act: Calling controller functions or methods
* Assert: Verify that conditions are true