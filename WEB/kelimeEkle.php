<?php
 
if($_POST){
require_once('databaseBaglan2.php');
 
$ENG = $_POST["ENG"];
$grup = $_POST["grup"];
$seviye = $_POST["seviye"];
$TR = $_POST["TR"];
$ENGES = $_POST["ENGES"];
$ENGZIT = $_POST["ENGZIT"];
$ENGCUMLE = $_POST["ENGCUMLE"];
$TRCUMLE = $_POST["TRCUMLE"];

	 
$sql = "INSERT INTO kelimeler (INGKelime,grup,seviye,TRKelime,INGKelimeEs,INGKelimeZit,INGKelimeCumle,TRKeliemeCumle) VALUES 		('$ENG','$grup','$seviye','$TR','$ENGES','$ENGZIT','$ENGCUMLE','$TRCUMLE')";
	 
	 
	 
if(mysqli_query($con,$sql)){
	echo "Successfully Uploaded";
}else{
	echo "Hata Olustu.";
}

mysqli_close($con);
	
}else{
	echo "Error";
}
?>
