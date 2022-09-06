SET SQL_SAFE_UPDATES = 0;
use heroku_4de1c1f87cc0fcd;

insert into Candidates(name, surname, username, password, role, enabled)values('izan', 'dueso', 'izan', '$2a$12$TxgCvCUaDQOszZ.naDgkJeO.P496h2xTIDuI8yi8HyMO.7hr8cT4W', 'ADMIN', 1);
insert into Candidates(name, surname, username, password, role, enabled)values('joel', 'romero', 'joel', '$2a$12$TxgCvCUaDQOszZ.naDgkJeO.P496h2xTIDuI8yi8HyMO.7hr8cT4W', 'USER', 1);
insert into Candidates(name, surname, username, password, role, enabled)values('jose', 'martin', 'jose', '$2a$12$TxgCvCUaDQOszZ.naDgkJeO.P496h2xTIDuI8yi8HyMO.7hr8cT4W', 'ADMIN', 1);
insert into Positions(title, description, id_HR_Users)values('Full-stack Developer', 'Software developer', 1);
insert into Candidate_positions(registry_date, test_date, completion_date, result, id_candidate, id_position)values(now(), now(), now(), 10, 1, 1);
insert into Skills(name)values('Back-end');
insert into Candidate_skills(value, notes, id_skill, id_candidate)values(6, 'Good', 1, 1);
insert into Roles(nombre)values("ADMIN");
insert into Users_Roles(user_id, role_id)values(1,1);
insert into Users_Roles(user_id, role_id)values(11,1);
insert into Users_Roles(user_id, role_id)values(21,1);
/*delete from Candidates
where name = 'Joel';*/

/*delete from HR_Users
where username = 'Izan';*/

select * from Users_Roles;