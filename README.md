# eb-demo
This is a repo containing the demo for EB. Since it's public I will be exdluding verbage that may lead a search engine here. 

## Building and running the project
- project can be built with a standard gradle build task. 
- tests can be run with a standard gradle test task
- build output will be in the build/libs directory
- in the event a build is not possible I included the war in the root level of the repo. Feel free to contact me if there are any issues. The very last thing I test is that the project builds and I will not submit an exam that doesn't build on my machine.
- in the event you're unable to deploy the war I included a jar with an embedded server also at the root level of the repo. You can run this via `java -jar <path_to_jar>`. This server will run on 8080. 
## Making calls
- the api endpoint paths are as specced in the test doc. eb/topic/{topicId}, 
## Project Setup
### Spring
- I decided to roll with spring boot to get a quicker start versus running with a pure spring approach. 
- The project is configured to generate a deployable war file instead of a runnable jar as spring boot does by default.
- The embedded tomcat dependency is set to be provided so that it's not wrapped in the war.
### Spring webflux
- I thought it'd be a cool experiment to try using web flux for this project. 
- Spring webflux generally provides better scalability since it's completely non blocking where spring mvc and spring mvc async are both blocking and partly blocking respectively.
- Of course we lose some efficiency here since the underlying db is blocking.
### Lombok
- I use lombok to simplify my pojos so if code seems to be missing it's provided at compile time by lombok
- The @Data annotation on classes in the models package provides implementations of getters, setters, equals, hashcode, toString, and a required args constructor at compile time. 
- https://projectlombok.org/features/Data

## Design Considerations
### Handling the xml file
NOTE: I changed the name of the xml file so google can't lead other devs here as easily as this is a public repo.  
The XML file gets read in at launch by a JPA repository populator. This approach essentially pidgeon holed me into defining topic list as its own managed entity. This does provide functionality for the real world use case of passing and storing curated lists of publications however this was not specced out in the exam. If this were not a desired outcome I would approach the problem differently and write a parser with Spring Batch that would give me finer control over the process. 
### Data Model
- ApiResponse delegates how objects can be uniformly marshalled to json
- TopicList is a list of publications. They are persisted entities in this approach as previously mentioned
- Topic is a url-publish node. 
### Repo
Just your standard default spring jpa repo's for topics and topic lists.
### Service layer (lack of)
I chose not to define a service layer here for the sake of time and complexity. There's no logic to handle here that exposing the topic repo directly in the controller couldn't provide. 
### Controller
The controller returns data wrapped in an ApiResponse object. When this serializes to json the field is labeled as data. This is preferred to returning an anonymous object at the same level as the error field. Additionally I decided to not return empty values but nulls instead so client side there is never a doubt when a value isn't present.
### Tests
I opted to only include test coverage for functions manually defined by me or functions that would be used in the project. This was to save time as this is an exam. In production I would likely include contract and unit tests for other functionality. For instance a contract test on what happens when a topic is read in with all null values. 
