# T-Jobs API REST  
The API REST methods that are used on the fron-end of T-Jobs web application.  
**API URL:** https://team3-c6-project.herokuapp.com/api  

# Candidates End-points  
## Get list of candidates  

```
GET /candidates
```  

## Get candidates by name  

```
GET /candidates/name/{name}
```

## Get candidates by username  

```
GET /candidates/username/{username}
```

## Get candidates by id  

```
GET /candidates/{id}
```

## Create a new candidate  

```
POST /candidates  
```

## Update candidate by id  

```
PUT /candidates/{id}
```

## Delete candidate by id 

```
DELETE /candidates/{id}
```

# Candidate Positions End-points  
## Get list of Candidate Positions  

```
GET /candidatePositions
```  

## Get Candidate Position by id  

```
GET /candidatePositions/{id}
```

## Create a new Candidate Position

```
POST /candidatePositions
```  

## Update Candidate Position by id

```
PUT /candidatePositions/{id}
```

## Delete Candidate Position by id

```
DELETE /candidatePositions/{id}
```

# Candidate Positions End-points    
## Get Candidate Skills list
```
GET /candidateSkills
```
## Create new Candidate Skill
```
POST /candidateSkills
```
## Get Candidate Skills by id
```
GET /candidateSkills/{id}
```
## Update Candidate Skills by id
```
PUT /candidateSkills/{id}
```
## Delete Candidate Skills by id
```
DELETE /candidateSkills/{id}
```
# Positions End-points  
## Get positions list
```
GET /positions
```
## Get positions list by title
```
GET /positions/title/{title}
```
## Create a new position
```
POST /positions
```
## Get position by id
```
GET /positions/{id}
```
## Update position by id
```
PUT /positions/{id}
```
## Delete position by id
```
DELETE /positions/{id}
```








