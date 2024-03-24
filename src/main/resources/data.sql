CREATE TABLE IF NOT EXISTS account
(
    id         INTEGER NOT NULL PRIMARY KEY,
    user_id    VARCHAR(20) NOT NULL UNIQUE,
    loan_status VARCHAR(15)
);

insert into account (id, user_id, loan_status)
values (1, '49002010965', 'DEBT');
insert into account (id, user_id, loan_status)
values (2, '49002010976', 'SEGMENT_3');
insert into account (id, user_id, loan_status)
values (3, '49002010987', 'SEGMENT_2');
insert into account (id, user_id, loan_status)
values (4, '49002010934', 'SEGMENT_3');
insert into account (id, user_id, loan_status)
values (5, '49002010951', 'SEGMENT_3');
insert into account (id, user_id, loan_status)
values (6, '49002010985', 'SEGMENT_2');
insert into account (id, user_id, loan_status)
values (7, '49002010973', 'SEGMENT_1');