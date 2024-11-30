<?php
    // getting all values from the HTML form
    if(isset($_GET['get']))
    {
        $fname = $_GET['1fname'];
        $lname = $_GET['1lname'];
    }

    // database details
    $host = "mysql";
    $username = "root";
    $password = "root";
    $dbname = "testdb";

    // creating a connection
    $con = mysqli_connect($host, $username, $password, $dbname);

    // to ensure that the connection is made
    if (!$con)
    {
        die("Connection failed!" . mysqli_connect_error());
    }

    $pass_sql = "SELECT email FROM contactform_entries WHERE (fname='$fname') AND (lname='$lname')";

    // send query to the database to add values and confirm if successful
    $pass_res = mysqli_query($con, $pass_sql);
    if($pass_res && mysqli_num_rows($pass_res) > 0)
    {
        while ($row = mysqli_fetch_assoc($pass_res)) {
            echo $row['email'] . "<br>";
        }
    } else
        echo "Wrong password";

    // close connection
    mysqli_close($con);

?>