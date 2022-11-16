<%@page import="atu_system.inquiry_website.InquirySystem.InquiryResult"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

    <%
    InquiryResult result = (InquiryResult)request.getAttribute("inquiry-result");
    %>

    <table class="table">
        <tr>
            <th rowspan="2"> User's Input </th>
            <th> My Student ID: </th>
            <td colspan="3"> <%= request.getParameter("id") %> </td>
        </tr>
        <tr>
            <th> My Name: </th>
            <td colspan="3"> <%= result.studentName %> </td>
        </tr>
        <tr>
            <th rowspan="5"> Data Output </th>
            <th> My Team No: </th>
            <td colspan="3"> <%= result.teamID %> </td>
        </tr>
        <tr>
            <th rowspan="2"> My Teammates: </th>
            <th> 1 </th>
            <th> 2 </th>
            <th> 3 </th>
        </tr>
        <tr>
            <td> <%= result.teammateNames[0] %> </th>
            <td> <%= result.teammateNames[1] %> </td>
            <td> <%= result.teammateNames[2] %> </td>
        </tr>
        <tr>
            <th rowspan="2"> Our Team Energy: </th>
            <th> K1_Average </th>
            <th> K2_Average </th>
            <td></td>
        </tr>
        <tr>
            <td> <%= result.k1Average %> </td>
            <td> <%= result.k2Average %> </td>
            <td></td>
        </tr>
    </table>
</body>
</html>