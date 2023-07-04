## Spring Boot Application <span style="color:red">(to be modified )</span> 

This project is a simple practice of SB application 
that handles http requests and connected to a database.

### Content
#### main content
inside <span style="color:#3944bc">src/main/java/com.example.content</span> there are 1 class and  5 packages:

1. <span style="color:yellow">ContentApplication </span>class which contain the main function.
2. <span style="color:yellow">packages</span> :
   1. <span style="color:yellow">controller</span> : contain class(controller) which is responsible for handling http requests.
   2. <span style="color:yellow">service</span>: contain Interface(service) which is responsible for the business logics(methods signature).
   3. <span style="color:yellow">serviceImp</span>:contain class(DTMemberserviceImp) which is responsible for the business logics
   3. <span style="color:yellow">repository</span> : contain interface(repo) which is responsible for data access
   4. <span style="color:yellow">entity </span>: contain class(DTMember), which represents the db table as java class.
   5. <span style="color:yellow">configuration</span> (have @bean method?تاكدي).

#### Test content


### Dependencies used (pom.xml)
1. Spring web (contain common web specifics)
2. data JPA(for mapping entity objs with database records)
3. Postgres (database used)
4. Test
5. h2(for testing)
6. junit