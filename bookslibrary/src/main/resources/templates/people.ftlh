<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Пользователи библиотеки</title>
</head>
<body>
<p>
    <#list people as person>
        <a href="/people/${person.id}">${person.fullName}, #{person.yearOfBirth}</a><br>
    </#list>
</p>
<hr>
<a href="person_addition.html">Добавить человека</a>
</body>
</html>