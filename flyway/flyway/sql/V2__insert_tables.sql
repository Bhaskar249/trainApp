insert into  passenger("id","firstname" ,"lastname"  ,"email" ,"login","password","contact_no","created_at"  )
values
    (1712521000, 'Bhaskar', 'Pathak', 'b@gmail.com', 'bhaskar', 'password', 7348802897, 1712526060);
insert into  location("id","city")
values (1712526061, 'London');
insert into  location("id","city")
values (1712526062, 'France');

insert into  train("pnr"         ,
                  "name"        ,
                  "startlocation"   ,
                  "endlocation"     ,
                  "start_time"  ,
                  "end_time"   ,
                  "distance")
values (1712526023, 'Bullet train', 1712526061, 1712526062, 1712526060, 1712526060, 23456);

insert into  seats("seat_no","train","section")
values(232323, 1712526023,0);
insert into  seats("seat_no","train","section")
values(232343, 1712526023,1);

