## Synopsis

This application finds movie details based on movie name and API type. It accepts request in `json` format and returns success or failure response.

## Code Example

Application accepts input as a `GET` request with following parameters:

```javascript
movie
api
```

And produces the following output:

```javascript
{
    "movies": [
        {
            "title": "Rambo",
            "release_date": "2008-01-24"
        },
        {
            "title": "Rambo III",
            "release_date": "1988-05-24"
        },
        {
            "title": "Rambo",
            "release_date": "2018-02-01"
        },
        {
            "title": "First Blood",
            "release_date": "1982-10-22"
        }
    ]
}
```

## Installation

To install the app, run through the following steps:

* Clone the repository
* Make sure the machine has [Java](http://www.oracle.com/technetwork/java/javase/downloads/index-jsp-138363.html) and [Maven](https://maven.apache.org/download.cgi) installed.
* From the command line, type `mvn clean install`, this will start the installation process
* Once installation is complete, the `jar` file will be present inside `target` folder. This file is an executable file and can be run via `java -jar <file>.jar` command
* By default, the application starts on 8686 port and has `/moviefinder` configured as context path. However, these parameters can be changed via application.properties file

Below is the example curl request to test the app once it's up and running:

```
curl -X GET \
  'http://localhost:8686/moviefinder/find?movie=Rambo&api=IMDB' \
  -H 'content-type: application/json' \
```

## Tests

This application has built in tests. While building the app with `mvn clean install` command, these tests are exectuted and result is displayed in the console.
