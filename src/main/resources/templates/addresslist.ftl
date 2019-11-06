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
        <h3>Address list</h3>
        <table class="table table-striped table-sm">
            <thead class="thead-dark">
                <tr>
                    <th>Id</th>
                    <th>Country</th>
                    <th>Area</th>
                    <th>City</th>
                    <th>Street</th>
                    <th>Building</th>
                    <th>House</th>
                    <th>delete</th>
                    <th>update</th>
                </tr>
            </thead>
            <tbody>
                <#list addressList as address>
                    <tr>
                        <td>${address.id}</td>
                        <td>${address.country}</td>
                        <td>${address.area}</td>
                        <td>${address.city}</td>
                        <td>${address.street}</td>
                        <td>${address.building}</td>
                        <td>${address.house}</td>



                        <td>  <a href="/address/delete/${address.id}" type="button" class="btn btn-danger">Delete</a></td>
                        <td>  <a href="/address/update/${address.id}" type="button" class="btn btn-primary">Update</a></td>
                    </tr>
                </#list>
            </tbody>
        </table>
        <a href="/address/create" type="button" class="btn btn-success">Add new address</a>
        <a href="/index.html" type="button" class="btn btn-success">Start Page</a>
    </div>



</body>
</html>