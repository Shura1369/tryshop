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
        <h3>Order list</h3>
        <table class="table table-striped table-sm">
            <thead class="thead-dark">
                <tr>
                    <th>Id</th>
                    <th>active</th>
                    <th>product name</th>
                    <th>person</th>
                    <th>issuedMoney</th>
                    <th>buybackPrice</th>
                    <th>sellingPrice</th>
                    <th>getDate</th>
                    <th>retDate</th>


                    <th>delete</th>
                    <th>update</th>
                </tr>
            </thead>
            <tbody>
                <#list orders as order>
                    <tr>
                        <td>${order.id}</td>
                        <#if order.active ==true>
                        <td>Is Active</td>
                        </#if>
                        <#if order.active ==false>
                        <td> Closed</td>
                        </#if>
                        <td>${order.product.name + " " +order.product.id}</td>
                        <td>${order.person.passport.firstName +" "
                            + order.person.passport.lastName+" "+ order.person.id}</td>
                        <td>${order.issuedMoney}</td>
                        <td>${order.buybackPrice}</td>
                        <td>${order.sellingPrice}</td>
                        <td>${order.getDate}</td>
                        <td>${order.retDate}</td>




                        <td>  <a href="/order/delete/${order.id}" type="button" class="btn btn-danger">Delete</a></td>
                        <td>  <a href="/order/update/${order.id}" type="button" class="btn btn-primary">Update</a></td>
                    </tr>
                </#list>
            </tbody>
        </table>
        <a href="/order/create/*" type="button" class="btn btn-success">Add new person</a>
        <a href="/index.html" type="button" class="btn btn-success">Start Page</a>
    </div>



</body>
</html>