insert into company(id, joining_date, company_name, cuit) 
values (10001, '2021-10-15', 'AGRIMARKETING S.A', '30686529289');

insert into company(id, joining_date, company_name, cuit) 
values (10002, '2021-03-17', 'MONSANTO ARGENTINA S.R.L.', '30503508725');

insert into company(id, joining_date, company_name, cuit) 
values (10003, '2025-01-17', 'TECNOMYL S.A.', '30619257487');

insert into company(id, joining_date, company_name, cuit) 
values (10004, '2022-01-27', 'UPL ARGENTINA S.A.', '30522189894');

insert into company(id, joining_date, company_name, cuit) 
values (10005, '2025-01-01', 'SPEED AGRO S.R.L.', '30707633197');

insert into transfer(id, sender_id, execution_date, amount, credit_account, debit_account)
values (20001, 10001, '2025-01-24 11:50:34', 135678.67, '9490112211100027270179', '7441019811100079824201');

insert into transfer(id, sender_id, execution_date, amount, credit_account, debit_account)
values (20002, 10002, '2019-09-14 15:30:24', 4234442.34, '5515514411100055886997', '3093937811100090722944');

insert into transfer(id, sender_id, execution_date, amount, credit_account, debit_account)
values (20003, 10003, '2025-01-04 09:30:34', 14234545.88, '9167095111100073458303', '6464301611100069870997');

insert into transfer(id, sender_id, execution_date, amount, credit_account, debit_account)
values (20004, 10001, '2019-09-24 11:50:34', 42356546.25, '2622962111100038646235', '6566153011100041046714');

insert into transfer(id, sender_id, execution_date, amount, credit_account, debit_account)
values (20005, 10005, '2025-01-03 10:24:23', 123675756.23, '1217593211100092283748', '4767972811100079250231');