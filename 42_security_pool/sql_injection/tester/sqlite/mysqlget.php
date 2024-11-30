<?php
    if(isset($_GET['get']))
    {
        $form_username = $_GET['gusername'];
        $form_password = $_GET['gpassword'];
    }

    // Connecting to SQLite
    $con = new SQLite3('./data/testdb.sqlite');
    if (!$con) {
        die("Connection failed: " . $con->lastErrorMsg());
    }

    // Vulnerable SQL Query
    $pass_sql = "SELECT * FROM users WHERE username='$form_username' AND password='$form_password'";
    echo $pass_sql . "<br>"; // For debugging: Show the generated SQL query.

    $result = $con->query($pass_sql);

    if ($result) {
        while ($row = $result->fetchArray(SQLITE3_ASSOC)) {
            foreach ($row as $key => $value) {
                echo "$key: $value<br>";
            }
        }
    } else {
        echo "Query failed: " . $con->lastErrorMsg();
    }

    $con->close();
?>