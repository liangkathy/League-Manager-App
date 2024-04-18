# League Manager App - Spring Boot Application

## Overview

This guide details the creation of League Manager App, aimed at managing sports teams, players, and their participation in various tournaments.

## Getting Started

### Initial Setup
Create Spring Boot Application: Use Spring Initializr to start a new Spring Boot project, adding dependencies for Spring Web, Spring Data JPA, and an appropriate SQL database connector for postgres and also Lombok.

### Define Models

Develop models that represent the core entities of the application and their relationships:

#### Team: Should have fields such as id, name, and a list of players (one-to-many relationship with players). You can add more fields if you would like to.

#### Player: Include fields like id, name, and the team they play for (many-to-one relationship with teams). You can add more fields if you would like to.

#### Tournament: Should contain fields like id, name, and a list of teams that compete in it (many-to-many relationship with teams). You can add more fields if you would like to.

### Implement Repositories
Create repository interfaces for each model, extending Spring Data JPA's JpaRepository. This will provide basic CRUD operations out of the box.

### Create Service Layer
Implement service classes that handle the business logic for each entity. These services should inject the needed repositories and provide methods for CRUD operations and any additional functionality required.

### Develop REST Controllers
Create REST controllers for each entity, exposing endpoints for CRUD operations. These controllers should inject the corresponding services and handle HTTP requests and responses.

### Implement CRUD Operations
Develop endpoints in the controllers for the following CRUD operations:

#### team
- Create a new team
- Retrieve a team by ID
- Update a team's details
- Delete a team

#### player
- Create a new player
- Retrieve a player by ID
- Update a player's details
- Delete a player

#### tournament
- Create a new tournament
- Retrieve a tournament by ID
- Update a tournament's details
- Delete a tournament


### Implement Additional Functionality
Develop endpoints in the controllers for the following additional operations:

- Add a player to a team
- Add a team to a tournament
- Delete a player from a team
- Delete a team from a tournament
- Get all teams in a tournament
- Get a list of all the players in a tournament

### Bonus: Pagination
- Add a limit parameter in the query URL of the endpoint that retrieves a list of all the players in a tournament.
  Modify the endpoint to return only a set of players from the tournament based on the provided limit.


### Error Handling and Validation
Implement appropriate error handling and validation for the endpoints. This may include handling scenarios such as:

- Trying to add a player to a non-existent team
- Attempting to delete a non-existent player from a team
- Requesting a tournament that does not exist
- Providing invalid or missing data when creating or updating entities


### Testing Endpoints
Test all endpoints using Postman or another HTTP client to ensure they work as expected and validate all business rules.

### Deliverables
Source code of the Spring Boot application.


### Incorporating Git Flow in the FootballLeagueManagerApp Development

#### Feature Branch Workflow
-Create a Feature Branch for every new feature from the develop branch. Name it meaningfully related to the feature you're working on.

- Develop your feature on this branch. Commit your changes with descriptive messages.

- Push the Feature Branch to the remote repository once the feature is complete and you have committed all changes.

#### Create a Pull Request (PR):

- Open a pull request from your feature branch to the develop branch on your repository hosting service (like GitHub).
- Describe what changes have been made and any other comments relevant to the update.
  Review and Merge the PR:

- Have one or more team members review the pull request.
- Incorporate any feedback and commit further changes if necessary.
- Once the PR is approved, merge it into the develop branch.