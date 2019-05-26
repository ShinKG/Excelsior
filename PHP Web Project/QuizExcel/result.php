<?php
    include("accessdb.php");
    include 'getname.php';

    echo $gname;

    // $query = "SELECT * FROM players WHERE player_name = '$fname' "; 
    // $result = $conn->query($query) or die($conn->error);

    // $query1 = "SELECT * FROM questionanswer LIMIT $numque "; 
    // $result1 = $conn->query($query1) or die($conn->error);

    // $question = [];
    // $answer = [];

    // while ($row = $result1->fetch_assoc()) {
    //     $question[] = $row['question'];
    //     $answer[] = $row['answer'];
    // }

    // $questionlength = count($question);

    for( $x = 0 ; $x < $questionlength ; $x ++){
        echo "$question[$x]";
        echo "$answer[$x]";
        echo "<br><br>";
    }

