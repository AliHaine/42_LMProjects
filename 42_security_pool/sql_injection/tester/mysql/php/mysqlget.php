<?php
    if(isset($_GET['get']))
    {
        $form_username = $_GET['gusername'];
        $form_password = $_GET['gpassword'];
    }

    $con = mysqli_connect("mysql", "root", "root", "db");
    if (!$con)
        die("Connection failed!" . mysqli_connect_error());

    $pass_sql = "SELECT * FROM users WHERE (username='$form_username') AND (password='$form_password')";
    echo $pass_sql . "<br>";

    if (mysqli_multi_query($con, $pass_sql)) {
        do {
            if ($result = mysqli_store_result($con)) {
                if (mysqli_num_rows($result) > 0) {
                    while ($row = mysqli_fetch_assoc($result)) {
                        foreach ($row as &$v)
                            echo $v . "<br>";
                    }
                }
                mysqli_free_result($result);
            }
        } while (mysqli_next_result($con));
    } else {
        echo "Query failed: " . mysqli_error($con);
    }
    mysqli_close($con);
?>