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
        <h3>Person list</h3>
        <table class="table table-striped table-sm">
            <thead class="thead-dark">
                <tr>
                    <th>Id</th>
                    <th>Number passport</th>
                    <th>First name</th>
                    <th>Middle name</th>
                    <th>Last name</th>
                    <th>birth data</th>
                    <th>Gender</th>
                    <th>IPN</th>
                    <th>Address</th>


                    <th>delete</th>
                    <th>update</th>
                </tr>
            </thead>
            <tbody>
                <#list people as person>
                    <tr>
                        <td>${person.id}</td>
                        <td>${person.passport.number}</td>
                        <td>${person.passport.firstName}</td>
                        <td>${person.passport.middleName}</td>
                        <td>${person.passport.lastName}</td>
                        <td>${person.passport.birthDate}</td>
                        <td>${person.gender}</td>
                        <td>${person.ipn}</td>
                        <td>${person.address.toString()}</td>




                        <td>  <a href="/person/delete/${person.id}" type="button" class="btn btn-danger">Delete</a></td>
                        <td>  <a href="/person/update/${person.id}" type="button" class="btn btn-primary">Update</a></td>
                    </tr>
                </#list>
            </tbody>
        </table>
        <a href="/person/create/*" type="button" class="btn btn-success">Add new person</a>
        <a href="/index.html" type="button" class="btn btn-success">Start Page</a>
    </div>



</body>
</html>