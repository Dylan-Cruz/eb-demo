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
The XML file gets read in at launch by a JPA repository populator. This approach essentially pidgeon holed me into defining topic list as its own entity. This does provide functionality for the real world use case of passing and storing curated lists of publications however this was not specced out in the exam. If this were not a desired outcome I would approach the problem differently and write a parser with Spring Batch that would give me finer control over the process. 
### Data Model
- ApiResponse delegates how objects can be uniformly marshalled to json
- TopicList is a list of publications. They are persisted entities in this approach as previously mentioned
- Topic is a url-publish node. 
### Repo
Just your standard default spring crud repo's for topics and topic lists.
### Controller

### Tests
I opted to only include test coverage for functions manually defined by me or functions that would be used in the project. This was to save time as this is an exam. In production I would likely include contract and unit tests for other functionality. For instance a contract test on what happens when a topic is read in with all null values. 
