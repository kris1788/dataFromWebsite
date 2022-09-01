How project works

1. Open android project in android studio
2. While opening select Empty Activity as Template and Java as language.
3. Change the code in Activity_main.xml as in this project
4. Change the code in Main_activity.java as in this project except first line
5. Create FetchData.Java java class under Main_activity.java by right clicking on it and copy and paste code from project except first line
6. Add 2 lines in AndroidManifest.xml 1. <uses-permission android:name="android.permission.INTERNET" /> 2.android:usesCleartextTraffic="true" (second for http support)
7. Change URL in Main_activity.java as supported to your webserver

Now android project is OK

1. Login to mysql database
2. Create table as: CREATE TABLE `empmaster` (empnumber int(5) primary key,empname varchar(50),empdob date,empdoj date,empbranch int(3),gender int(1)) ENGINE=InnoDB AUTO_INCREMENT=15827 DEFAULT CHARSET=latin1;
3. insert data into table as: insert into empmaster values (1,'Emp name 1','1980-01-02','1990-02-05',200,1),(2,'Emp name 2','1980-02-02','1990-02-06',200,2),(3,'Emp name 3','1984-01-02','1994-02-05',200,1);

Now table creation in Mysql is OK

1. Create a file name index.php and place it in android folder in web root folder
2. Open the file and enter the following code

<?php
$empnumber=$_POST['empid'];
$mysqli = new mysqli("dbhostname", "dbusername", "dbpassword","dbname");
$sql="select empnumber as 'Emp Number',empname as 'Emp Name',DATE_FORMAT(empdob,'%d/%m/%Y') as 'Emp DOB',DATE_FORMAT(empdoj,'%d/%m/%Y') as 'Emp DOJ',empbranch 'Emp Branch',ELT(gender,'Male','Female') Gender from empmaster where empnumber=$empnumber";
$result = $mysqli->query($sql);
$row_cnt = $result->num_rows;
$dbdata = array();
for ($i=0;$i<$row_cnt;$i++) {
$row = $result->fetch_assoc();
$dbdata[]=$row;
}
$data1 = json_encode($dbdata);
echo $data1;
?>

Now Web server is OK
