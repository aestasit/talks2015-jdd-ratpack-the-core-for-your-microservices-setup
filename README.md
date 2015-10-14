
# Introduction

This is demo code that used during presentation on JDD 2015 in Krakow. 
It gives an overview of Ratpack features and a simple use case on how 
you can effectively use it for your microservices.

Before you can run the samples you will need to:

- install Java 8+ and set `JAVA_HOME` variable;
- install Groovy 2.3+ and add it your `PATH`;
- (Optionally) install Gradle 2.7+ (or just use Gradle Wrapper provided)

# Examples

## Date Server

The `01-date-server-simple` folder contains simple, but fully functional Groovy script that 
runs Ratpack application that responds to HTTP GET requests with a current date string.

To run the sample just type the following command from within the `01-date-server-simple` directory:

    groovy ratpack.groovy

# Date Server: extended

The `01-date-server-extended` folder contains more advanced date server example that shows how to render JSON, XML, HTML and plain text.

This example demonstrates usages of the following Ratpack features:

- Handlers
- Renderers
- Modules
- Assets

It makes calls to the following Ratpack API methods:

- `byContent`
- `byMethod`
- `prefix`
- `get`/`post`
- `render`
- `json`
- `groovyTemplate` 
- `groovyMarkupTemplate` 

Just run `groovy DateServer.groovy` that will give you accessto the following endpoints:

- http://localhost:5050/ (text response)
- http://localhost:5050/json (json response)
- http://localhost:5050/xml (xml response)
- http://localhost:5050/html (html response)

The script also contains "version 2" of the same Date API that allows you get different content based on sent HTTP headers. This can be retrieved with the help of `wget` or `curl` commands:

    curl -d{} -H "Accept:application/xml" http://localhost:5555/v2
    curl -d{} -H "Accept:application/json" http://localhost:5555/v2
    curl -d{} -H "Accept:text/plain" http://localhost:5555/v2

Also, a simple Geb-based test is implemented to show that functional tests can be done within single script as well as your full application (or literally "micro" service :) ):

    groovy `DateServerTest.groovy`

## (Micro)Services

This example consists of several Ratpack projects built with the help of Gradle:

- `10-shop-front` (http://localhost:8900/)
- `11-booking-server` (http://localhost:8901/)
- `12-review-server` (http://localhost:8902/)

To start each service just run the following command in its directory:

    gradlew run --continuous

Use separate terminal window for each of the services or prefix your command with `start` if you are on Windows. 
The `--continuous` flag starts the build in special mode that will update your running application whenever you update source files.

The target setup is the following:

![Setup](https://raw.githubusercontent.com/aestasit/talks2015-jdd-ratpack-the-core-for-your-microservices-setup/master/DEMO_ARCHITECTURE.png)

In actual source code, data storage connectivity is not implemented, but it does not hurt for demonstrating the principles. 
The front web application will continue to function even if both of the services it depends on will be down. 

Non-blocking HTTP client implementation coming with Ratpack is used to aggregate data for front page display from local data source and from remote web service.

Enjoy!

![Front page](https://raw.githubusercontent.com/aestasit/talks2015-jdd-ratpack-the-core-for-your-microservices-setup/master/SHOP_FRONT.png)


 

