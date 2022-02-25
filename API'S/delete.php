<?php

$servername="localhost";
$username="root";
$password="";
$db="poetrydb";

$conn= new mysqli($servername,$username,$password,$db);
 
if($conn->connect_error){

    die("connection failed:".$conn->connect_error);
}


$ID=$_POST['id'];



$query= "DELETE FROM poetry WHERE id=$ID"; 
$result= $conn->query($query);

if($result)
{
	$response=array("status"=>"1","message"=>"Data Successfully Updated");

}

else
{
	
	$response=array("status"=>"0","message"=>"Data Not Successfully Updated");
}

echo json_encode($response);

?>