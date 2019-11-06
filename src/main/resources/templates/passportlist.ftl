<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h3>Passport list</h3>
        <table class="table table-striped table-sm">
            <thead class="thead-dark">
                <tr>
                    <th>Id</th>
                    <th>Number</th>
                    <th>First name</th>
                    <th>Middle name</th>
                    <th>Last name</th>
                    <th>birth data</th>
                    <th>date obtain</th>
                    <th>delete</th>
                    <th>update</th>
                </tr>
            </thead>
            <tbody>
                <#list passports as passport>
                    <tr>
                        <td>${passport.id}</td>
                        <td>${passport.number}</td>
                        <td>${passport.firstName}</td>
                        <td>${passport.middleName}</td>
                        <td>${passport.lastName}</td>
                        <td>${passport.birthDate}</td>
                        <td>${passport.dataObt}</td>


                        <td>  <a href="/passport/delete/${passport.id}" type="button" class="btn btn-danger">Delete</a></td>
                        <td>  <a href="/passport/update/${passport.id}" type="button" class="btn btn-primary">Update</a></td>
                    </tr>
                </#list>
            </tbody>
        </table>
        <a href="/passport/create" type="button" class="btn btn-success">Add new passport</a>
        <a href="/index.html" type="button" class="btn btn-success">Start Page</a>
    </div>



</body>
</html>