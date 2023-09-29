create database SportsTeam;
use sportsTeam;

create table team(
name varchar(50) primary key,
owner varchar(25),
trophies_Won int
);

create table player(
player_id int primary key,
name varchar(25),
age int,
role varchar(10),
TeamName varchar(50),
foreign key(TeamName) references team(name)
);

create table season(
season_id int primary key,
year year,
winner varchar(50)
);

create table scorecard(
scorecard_id int primary key,
player_id int,
score int,
foreign key(player_id) references player(player_id)
);

create table singlematch(
match_id int primary key,
team1 varchar(50),
team2 varchar(50),
team1_score int,
team2_score int,
type varchar(15),
date date,
scorecard_id int,
result varchar(50),
foreign key(scorecard_id) references scorecard(scorecard_id)
);

create table matches(
match_id int,
season_id int,
primary key(match_id,season_id),
foreign key(match_id) references singlematch(match_id),
foreign key(season_id) references season(season_id)
);