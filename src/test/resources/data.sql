Delete from Barriers;
Delete from Sensors;
Delete from Parking;

Insert into Parking(id,parking_name,parking_size) Values(1,'Тестовая парковка',5);
Insert into Sensors(id,sensor_active, parking_id) Values
                                                         (1,false,1),
                                                         (2,false,1),
                                                         (3,false,1),
                                                         (4,false,1),
                                                         (5,false,1);
Insert into Barriers(id,barrier_open,barrier_type,barrier_name, parking_id) Values
                                                                      (1,false,'in','Шлагбаум 1',1),
                                                                      (2,true,'in','Шлагбаум 2',1),
                                                                      (3,false,'in','Шлагбаум 3',1),
                                                                      (4,false,'out','Шлагбаум 4',1),
                                                                      (5,false,'out','Шлагбаум 5',1);
