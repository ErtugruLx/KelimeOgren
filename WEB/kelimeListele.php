<?php

if($_SERVER["REQUEST_METHOD"]=="GET"){
	include 'databaseBaglan.php';
	kelimeListele();
}

function kelimeListele()
{
	global $connect;

	$seviye = $_GET['seviye'];	
	
	
	$query = " SELECT * FROM kelimeler where seviye = '$seviye' order by id ASC; ";
		
	$result = mysqli_query($connect, $query);
	$number_of_rows = mysqli_num_rows($result);
		
	$temp_array  = array(); 
		
		
	if($number_of_rows > 0) {
		while ($row = mysqli_fetch_assoc($result)) {
			$temp_array[] = $row;
		}
	}
		

		

	header('Content-Type: application/json; charset=utf-8');
	echo json_encode(array("kelimeler"=>$temp_array));

		 
	mysqli_close($connect);	

		
}
?>

