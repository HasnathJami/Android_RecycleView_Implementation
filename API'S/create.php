<?php


$servername="localhost";
$username="root";
$password="";
$db="poetrydb";
$connection= new mysqli($servername,$username,$password,$db);

if($connection->connect_error){
	
	die("connection failed: ".$connection->connect_error);
	
}


$POETRY =$_POST['poetry_data']; //we can use any name instead of poetry_data
$POET_NAME= $_POST['poet_name'];


$query="INSERT INTO poetry(poetry_data,poet_name) VALUES('$POETRY','$POET_NAME')";

//query execution
$result= $connection->query($query);


if($result==1)
	$response= array("status"=>"1","message"=>"successfully insterted");

else{
	
	$response= array("status"=>"0","message"=>"Not insterted");
	
}

echo json_encode($response);
?>