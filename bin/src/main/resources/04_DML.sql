SET SQL_SAFE_UPDATES = 0;
use heroku_4de1c1f87cc0fcd;

insert into Candidates(name, surname, username, password)values('izan', 'dueso', 'izan', '$2a$12$TxgCvCUaDQOszZ.naDgkJeO.P496h2xTIDuI8yi8HyMO.7hr8cT4W');
insert into Candidates(name, surname, username, password)values('eliminar', 'eliminar', 'eliminar', '$2a$12$TxgCvCUaDQOszZ.naDgkJeO.P496h2xTIDuI8yi8HyMO.7hr8cT4W');
insert into Positions(title, description, id_HR_Users)values('Full-stack Developer', 'Software developer', 1);
insert into Candidate_positions(registry_date, test_date, completion_date, result, id_candidate, id_position)values(now(), now(), now(), 10, 1, 1);
insert into Skills(name)values('Back-end');
insert into Candidate_skills(value, notes, id_skill, id_candidate)values(6, 'Good', 1, 1);

/*delete from Candidates
where name = 'Joel';*/

/*delete from HR_Users
where username = 'Izan';*/

select * from Candidates;