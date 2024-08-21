<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Download Resume</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f4f8;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            width: 80%;
            height:60%;
            background: #ffffff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        button {
            background-color: #00796b;
            color: #ffffff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }
        button:hover {
            background-color: #004d40;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Download Resume</h1>
        <form action="ResumeServlet" method="post">
            <input type="hidden" name="action" value="save">
            <button type="submit">Download as .doc</button>
        </form>
    </div>
</body>
</html>
