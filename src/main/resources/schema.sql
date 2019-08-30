CREATE TABLE employee (
  id INTEGER PRIMARY KEY,
  name VARCHAR(64) NOT NULL,
  age   int(4) NOT NULL
);


CREATE TABLE `parkingLot` (
`parkingLotID` int(10) NOT NULL,
`availablePositionCount` int(3) NULL,
`capacity` int(3) NULL,
`parkingBoyID` int(3) NULL,
);

insert into employee values(0,'eason',666);
insert into employee values(1,'cat',17);
insert into employee values(2,'dog',1);

insert into parkingLot values(0,13,10,0);
insert into parkingLot values(1,10,10,2);
insert into parkingLot values(2,11,15,3);
insert into parkingLot values(3,12,16,4);
insert into parkingLot values(4,13,17,5);
insert into parkingLot values(5,10,10,6);
insert into parkingLot values(7,13,16,7);
insert into parkingLot values(1,10,10,8);


