use heroku_4de1c1f87cc0fcd;

drop table if exists Users_Roles, Roles, Candidate_skills, Candidate_positions, Positions, Candidates, Skills;

create table Candidates (
	id int auto_increment primary key,
    name varchar(255),
    surname varchar(255),
    username varchar(255) unique key,
    password varchar(255),
    role varchar(255),
    enabled int default null
);

create table Roles(
	id int auto_increment primary key,
    nombre varchar(255)
);

create table Users_Roles(
	user_id int NOT NULL,
    role_id int NOT NULL,
	KEY user_fk_idx (user_id),
	KEY role_fk_idx (role_id),
	CONSTRAINT role_fk FOREIGN KEY (role_id) REFERENCES Roles (id),
	CONSTRAINT user_fk FOREIGN KEY (user_id) REFERENCES Candidates (id)
);

create table Positions (
	id int auto_increment primary key,
    title varchar(255),
    description varchar(255),
    id_HR_Users int,
    constraint positions_fk foreign key (id_HR_Users) references Candidates(id)
    on update cascade on delete cascade
);

create table Candidate_positions (
	id int auto_increment primary key,
    registry_date date,
    test_date date,
    completion_date date,
    result float,
    id_candidate int,
    id_position int,
    constraint candidate_positions_fk foreign key (id_candidate) references Candidates(id)
    on update cascade on delete cascade,
    constraint candidate_positions_fk_01 foreign key (id_position) references Positions(id)
    on update cascade on delete cascade
);

create table Skills (
	id int auto_increment primary key,
    name varchar(255)
);

create table Candidate_skills (
	id int auto_increment primary key,
    value float,
    notes varchar(255),
    id_skill int,
    id_candidate int,
    constraint candidate_skills_fk foreign key (id_skill) references Skills(id)
    on update cascade on delete cascade,
    constraint candidate_skills_fk_01 foreign key (id_candidate) references Candidates(id)
    on update cascade on delete cascade
);