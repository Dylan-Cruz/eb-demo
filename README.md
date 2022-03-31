# eb-demo
This is a repo containing the demo for EB. Since it's public I will be exdluding verbage that may lead a search engine here. 

## Building and running the project

## Project Setup
### Spring
- I decided to roll with spring boot to get a quicker start versus running with a pure spring approach. 
- The project is configured to generate a deployable war file instead of a runnable jar as spring boot does by default.
- The embedded tomcat dependency is set to be provided so that it's not wrapped in the war. 

### Spring webflux
- I thought it'd be a cool experiment to try using web flux for this project. 
- Spring webflux generally provides better scalability since it's completely non blocking where spring mvc and spring mvc async are both blocking and partly blocking respectively.

### Lombok
- I use lombok to simplify my pojos so if code seems to be missing it's provided at compile time by lombok
- The @Data annotation on classes in the models package provides implementations of getters, setters, equals, hashcode, toString, and a required args constructor at compile time. 
- https://projectlombok.org/features/Data

## Design Considerations
### Handling the xml file
### Repo
### Controller
