DROP TABLE Barriers;
DROP TABLE  Sensors;
DROP TABLE  Parking;


CREATE TABLE Parking(
    id serial primary key,
    parking_name varchar (100),
    parking_size integer
);

CREATE TABLE Barriers(
     id serial primary key,
     barrier_open boolean,
     barrier_name text,
     barrier_type varchar (10),
     parking_id integer,
     CONSTRAINT fk_parking_barriers FOREIGN KEY (parking_id) REFERENCES Parking(id)
);
CREATE TABLE Sensors(
    id serial primary key,
    sensor_active boolean,
    parking_id integer,
    CONSTRAINT fk_parking_sensors FOREIGN KEY (parking_id) REFERENCES Parking(id)
);