# T-Jobs API REST  
The API REST methods that are used on the fron-end of T-Jobs web application.  
**API URL:** https://team3-c6-project.herokuapp.com/api  

# API Authentication
## Log-in
```
POST /login
Example: POST /login @RequestBody {"username":"example", "password":"1234"}
```
## Register
```
POST /register
Example: POST /register @RequestBody {"username":"example_register", "password":"12345"}
```

# Candidates End-points  
## Get list of candidates  

```
GET /candidates
```  

## Get candidates by name  

```
GET /candidates/name/{name}
Example: GET /candidates/name/izan
```

## Get candidates by username  

```
GET /candidates/username/{username}
Example: GET /candidates/username/joel
```

## Get candidates by id  

```
GET /candidates/{id}
Example: GET /candidates/11
```

## Create a new candidate  

```
POST /candidates  
Example: POST /candidates @RequestBody {"name":"izan", "surname":"dueso", "username":"Izan", "password":"temp123"}
```

## Update candidate by id  

```
PUT /candidates/{id}
Example: PUT /candidates/11 @RequestBody {"name":"izan", "surname":"dueso", "username":"Izan", "password":"temp123"}
```

## Delete candidate by id 

```
DELETE /candidates/{id}
Example: DELETE /candidates/11
```

# Candidate Positions End-points  
## Get list of Candidate Positions  

```
GET /candidatePositions
```  

## Get Candidate Position by id  

```
GET /candidatePositions/{id}
Example: GET /candidatePositions/11
```

## Create a new Candidate Position

```
POST /candidatePositions
Example: POST /candidatePositions @RequestBody {}
```  

## Update Candidate Position by id

```
PUT /candidatePositions/{id}
Example: PUT /candidatePositions/11 @RequestBody {"registry_date":"2000-12-20", "test_date":"2022-09-22", "completion_date":"2022-09-23", "result":"10", "id_candidate":"11", "id_position":"11"}
```

## Delete Candidate Position by id

```
DELETE /candidatePositions/{id}
Example: DELETE /candidatePositions/11
```

# Candidate Positions End-points    
## Get Candidate Skills list
```
GET /candidateSkills
```
## Create new Candidate Skill
```
POST /candidateSkills
Example: POST /candidateSkills @RequestBody {"value":"10", "notes": "good", "id_skill":"11", "id_candidate":"11"}
```
## Get Candidate Skills by id
```
GET /candidateSkills/{id}
Example: GET /candidateSkills/11
```
## Update Candidate Skills by id
```
PUT /candidateSkills/{id}
Example: PUT /candidateSkills/11 @RequestBody {"value":"10", "notes": "good", "id_skill":"11", "id_candidate":"11"}
```
## Delete Candidate Skills by id
```
DELETE /candidateSkills/{id}
Example: DELETE /candidateSkills/11
```
# Positions End-points  
## Get positions list
```
GET /positions
```
## Get positions list by title
```
GET /positions/title/{title}
Example: GET /positions/title/java-angular
```
## Create a new position
```
POST /positions
Example: POST /positions @RequestBody {"title":"java", "description":"developer", "id_HR_Users":{}}
```
## Get position by id
```
GET /positions/{id}
Example: GET /positions/11
```
## Update position by id
```
PUT /positions/{id}
Example PUT /positions/11 @RequestBody {"title":"java", "description":"developer", "id_HR_Users":{}}
```
## Delete position by id
```
DELETE /positions/{id}
Example: DELETE /positions/11
```
# Skills End-points
## Get Skill list
```
GET /skills
```
## Get Skill list by name
```
GET /skills/name/{name}
Example: GET /skills/name/Java
```
## Create a new Skill
```
POST /skills
Example: POST /skills @RequestBody {"name":"angular"}
```
## Get Skills by id
```
GET /skills/{id}
Example: GET /skills/11 
```
## Update Skills by id
```
PUT /skills/{id}
Example: PUT /skills/11 @RequestBody {"name":"angular"}
```
## Delete Skills by id
```
DELETE /skills/{id}
Example: DELETE /skills/11
```








