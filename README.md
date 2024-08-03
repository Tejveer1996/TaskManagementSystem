The Task Management System is designed to streamline task handling through a well-structured API and robust role management. 
By implementing a role-based access control system, the application ensures that tasks are managed securely and appropriately based on user roles. 
This approach provides a scalable and maintainable solution for task management needs.

API Design:
The system exposes a set of RESTful APIs that allow users to perform CRUD operations on tasks. 

Role Management
The system supports multiple user roles, which are crucial for managing access and permissions. 
The roles are managed through a dedicated Role class and associated RoleController. 

Signup generates a hashed token that is stored in Bcryption. That token is used for further Authentication.


Dockerfile is created for containerization.
dock hub repository link where image of the taskmanager is present
https://hub.docker.com/r/teveer/taskmanager/tags
