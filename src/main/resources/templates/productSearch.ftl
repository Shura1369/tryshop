<#import "/spring.ftl" as spring/>
<#import "ui.ftl" as ui/>

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

        <!--div-->
            <fieldset>
                <legend>Поиск</legend>
                <form name="searchForm" action="search" method="POST">
                    <@ui.formInput id="t3" name="searchProductName" label="Поиск"/> <br/>
                    <input type="submit" value="Search" />
                </form>
            </fieldset>
        <!--/div-->
        <p><#if lastSearch??>Поиск для: ${lastSearch}<#else></#if></p>
        <@ui.table id="table1" rows=products![]/>

        <h3>Product list</h3>
        <table class="table table-striped table-sm">
            <thead class="thead-dark">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Price</th>
                <th>Type product</th>
                <th>Sold</th>

                <th>delete</th>
                <th>update</th>
            </tr>
            </thead>
            <tbody>
            <#list products as product>
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td>${product.typeProduct}</td>
                    <#if product.sold ==true>
                        <td>Sold</td>
                    </#if>
                    <#if product.sold ==false>
                        <td>Is Active</td>
                    </#if>



                    <td>  <a href="/product/delete/${product.id}" type="button" class="btn btn-danger">Delete</a></td>
                    <td>  <a href="/product/update/${product.id}" type="button" class="btn btn-primary">Update</a></td>
                </tr>
            </#list>
            </tbody>
        </table>
        <a href="/index.html" type="button" class="btn btn-success">Start Page</a>
    </div>



</body>
</html>