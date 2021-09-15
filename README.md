I have exposed an API - “exchangerateapi” and built an API that fetches data from bin records and forwards required data to exchangerateapi to fetch the current exchange rate of their country.
Functionality: A bin number that API takes as an input and the API responses with current exchange rate along with particular data
Technologies: Java, Spring Boot

![Screenshot (698)](https://user-images.githubusercontent.com/70435819/130627334-7ac99069-ad3d-44ec-8e5a-6d18ad15f32e.png)
# SpringBoot-app
Spring Boot App

Changes path code: (Somehow I got errors while puting relative paths in code)

In path /springBoot-appp/src/main/java/com/springBootApp/HashCSV/HashCSV.java update the file path on line 11 with file path of out4.csv

In path /springBoot-app/src/main/java/com/springBootApp/CSV/ReadDataFromCSV.java update the file path on line 17 with file path of latest.csv

In path /springBoot-app/src/main/java/com/springBootApp/CSV/ReadDataFromCSV.java update the file path on line 54 and 57 with file path of output.json
