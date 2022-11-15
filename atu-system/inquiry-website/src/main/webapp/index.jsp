<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <title>ATU Inquiry System</title>
    <style>
        body {
            width: 100%;
            padding: 10%;
            display: flex;
            align-items: start;
            justify-content: center;
            flex-direction: column;
        }
    </style>
</head>
<body>
    <h1>Automatic Teaming Up Inquiry System</h1>
    
    <br/>

    <form action="/inquiry-website/" method="post" class="w-50">
        <label for="id" class="form-label">Student ID</label>
        <input type="text" class="form-control mb-4" name="id" id="id">
        <input type="submit" class="btn btn-primary mb-3" value="Submit">
    </form>
</body>
</html>