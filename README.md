CrudApp

The CrudApp is a simple web-application that allows you to store entities in remote database and perform CRUD operations using HTTP-requests.

Technologies used in project:

Java, JDBC, MySQL, H2 database, Liquibase, Servlets, JSP

Project structure:

Model layer is represented by POJO classes Developer, Account, Skill.

Repository layer includes the basic application's functionality. Classes DeveloperRepository, AccountRepository and SkillRepository provide 
access to appropriate tables in database and execution of CRUD operations.

Service layer is represented by DeveloperService, AccountService, SkillService classes. In this project Service layer classes don't contain
any business logic. These classes are used only for representation of appropriate application's layer.

REST API layer is represented by DeveloperServlet, AccountServlet and SkillServlet classes. These classes handle HTTP requests, therefore it
provide remote access to data storage.

Please visit application's main page: https://crud-app-rv86.herokuapp.com
