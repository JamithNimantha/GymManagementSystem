drop database GMS;
create database GMS;
Use GMS;

create table Member(
  member_id varchar(20) not null,
  full_name varchar (100) not null,
  address varchar(200) not null,
  gender varchar(15) not null,
  mobile_number varchar(20) not null,
  date_of_birth date not null,
  email varchar(100) not null,
  constraint primary key(member_id)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into Member values('M0001','Jamith Nimantha','N0:150,Kanampitiya Road, Galle','Male','0776644682','1998-04-19','jamith@mail.com');


create table Registration(
  registration_id varchar(20)  not null,
  joining_date date not null,
  member_id varchar(20) not null,
  constraint primary key(registration_id),
  constraint foreign key(member_id) references Member(member_id) on delete cascade on update cascade
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into Registration values('R0001','2018-05-20','M0001');

create table Package(
    package_id varchar(20) not null,
    package_name varchar(100) not null,
    package_description varchar(200),
    package_fee decimal(10,2) not null,
    constraint primary key(package_id)
  )ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into Package values('P0001','Gold','cardio + weight','2500.00');

create table Trainer(
  trainer_id varchar(20) not null,
  full_name varchar (100) not null,
  address varchar(200) not null,
  gender varchar(15) not null,
  mobile_number varchar(20) not null,
  date_of_birth date not null,
  email varchar(100) not null,
  joining_date date,
  trainer_description varchar(200),
  constraint primary key(trainer_id)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into Trainer values('T0001','Arnold Perera','NO:20,Colombo','Male','0777828678','1987-03-08','arnold@gmail.com','2017-08-07','Sri lankan body builder');


create table Membership(
  membership_id varchar(20) not null,
  first_payment_date date,
  registration_id varchar(20) not null,
  package_id varchar(20) not null,
  trainer_id varchar(20) not null,
  constraint primary key (membership_id),
  constraint foreign key(registration_id) references Registration(registration_id) on delete cascade on update cascade,
  constraint foreign key (package_id) references Package(package_id) on delete cascade on update cascade,
  constraint foreign key(trainer_id) references Trainer(trainer_id) on delete cascade on update cascade
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into Membership values('M0001','2018-06-29','R0001','P0001','T0001');



create table Attendance(
  attendance_id varchar(20) not null,
  attendance_date date not null,
  in_time time not null,
  membership_id varchar(20) not null,
  constraint primary key(attendance_id),
  constraint foreign key(membership_id) references Membership(membership_id) on delete cascade on update cascade
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into Attendance values('A0001','2018-06-12','20:30:44','M0001');

create table Payment(
  payment_id varchar(20) not null,
  payment_date date not null,
  payment_time time not null,
  payment_description varchar(200),
  payment_amount decimal(10,2) not null,
  membership_id varchar(20) not null,
  constraint primary key (payment_id),
  constraint foreign key(membership_id) references Membership(membership_id) on delete cascade on update cascade
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into Payment values('P0001','2018-05-23','10:30:23','Monthly Fee for July','2500.00','M0001');


create table Measurement(
  measurement_id varchar(20) not null,
  height decimal(10,2),
  weight decimal(10,2),
  bmi decimal(10,2),
  bmi_status varchar(20),
  chest decimal(10,2),
  waist decimal(10,2),
  thigs decimal(10,2),
  arms decimal(10,2),
  result_date date,
  membership_id varchar(20) not null,
  constraint primary key(measurement_id),
  constraint foreign key(membership_id) references Membership(membership_id) on delete cascade on update cascade
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

create table Schedule(
  schedule_id varchar(20) not null,
  membership_id varchar(20) not null,
  trainer_id varchar(20),
  schedule_date date,
  constraint primary key(schedule_id),
  constraint foreign key(membership_id) references Membership(membership_id) on delete cascade on update cascade,
  constraint foreign key(trainer_id) references Trainer(trainer_id) on delete cascade on update cascade
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

create table Workout(
  workout_id varchar(20) not null,
  workout_name varchar(50) not null,
  workout_description varchar(200),
  constraint primary key(workout_id)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

create table ScheduleDetail(
  schedule_id varchar(20) not null,
  workout_id varchar(20) not null,
  sets varchar(10),
  reps varchar(10),
  rest varchar(10),
  constraint foreign key(schedule_id) references Schedule(schedule_id) on delete cascade on update cascade,
  constraint foreign key(workout_id) references Workout(workout_id) on delete cascade on update cascade
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

create table User(
login_id varchar(20) not null,
login_name varchar(20) not null,
user_name varchar(20) not null,
password varchar(600) not null,
constraint primary key(login_id)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into User values('U0001','Jamith','admin','1234');

select * from User where user_name='"+username+"' && password='"+pass"';
select * from User where user_name==admin && password==1234;
