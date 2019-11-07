SELECT * FROM orderproduct
DROP TABLE orderproduct
CREATE TABLE orderproduct(
orderId INT PRIMARY KEY  AUTO_INCREMENT,
produceNumber INT,
produceMoney NUMERIC,
finishNumber INT,
employName VARCHAR(20),
orderDate VARCHAR(20),
produceState VARCHAR(20) DEFAULT '未完成',
materialState VARCHAR(20)DEFAULT '未领料',
auditState VARCHAR(20)DEFAULT '未审核',
dayPlanId INT
)
INSERT INTO orderproduct(produceNumber,produceMoney,finishNumber,employName,orderDate,produceState,materialState,auditState,dayPlanId) VALUES(200,2000,200,'张三','2019-10-20','已完成','已领料','已审核',1)
INSERT INTO orderproduct(produceNumber,produceMoney,finishNumber,employName,orderDate,produceState,materialState,auditState,dayPlanId) VALUES(200,2000,200,'张三','2019-10-20','已完成','已领料','已审核',2)

INSERT INTO orderproduct(produceNumber,produceMoney,finishNumber,employName,orderDate,produceState,materialState,auditState,dayPlanId) VALUES(200,2000,200,'张三','2019-10-20','已完成','已领料','未审核',3)
SELECT * FROM Dailyplan LIMIT 0,10
SELECT * FROM 
TRUNCATE TABLE Dailyplan 
DROP TABLE Dailyplan
CREATE TABLE Dailyplan(
dailyPlanid  INT PRIMARY KEY AUTO_INCREMENT,
planId INT ,
productionQuantity INT,
daypracticalQuantity  INT,
auditingDate VARCHAR(50),
auditingStatue VARCHAR(50) DEFAULT '未审核',
auditorName VARCHAR(50),
productDate VARCHAR(50),
dailyplanDes VARCHAR(50)
)
SELECT * FROM Dailyplan LIMIT 0,10
SELECT * FROM Dailyplan 
INSERT INTO Dailyplan VALUES(Dailyplanid,1,500,0,'2019-10-29',1,'2019-10-29',dailyplanDes)
CREATE TABLE dailyPlanDetails(
dpdId INT PRIMARY KEY AUTO_INCREMENT,
dpId INT,
proId INT,
productionQuantity INT,
daypracticalQuantity INT,
planDetailDes VARCHAR(50)
)
TRUNCATE TABLE orderproductdetail
TRUNCATE TABLE orderproduct
INSERT INTO dailyPlanDetails VALUES(dpdId,1,1,100,0,planDetailDes)
INSERT INTO dailyPlanDetails VALUES(dpdId,1,2,100,0,planDetailDes)
INSERT INTO dailyPlanDetails VALUES(dpdId,1,3,100,0,planDetailDes)
INSERT INTO dailyPlanDetails VALUES(dpdId,1,4,100,0,planDetailDes)
INSERT INTO dailyPlanDetails VALUES(dpdId,1,5,100,0,planDetailDes)
SELECT * FROM dailyPlanDetails dpd JOIN Dailyplan dp ON dpd.dpId =dp.Dailyplanid 
CREATE TABLE orderproductdetail(
orderproductdetailid INT PRIMARY KEY  AUTO_INCREMENT,
orderproductId INT,
proId INT,
productionQuantity INT
)
