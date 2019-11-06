
<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div class="container">
    <fieldset>
        <legend>Create address</legend>
        <form name="address" action="" method="POST">
            Country     :<@spring.formInput "addressForm.country" 'class ="form-control"' "text"/>
            <br> Area  :<@spring.formInput "addressForm.area" 'class ="form-control"' "text"/>
            <br> City :<@spring.formInput "addressForm.city" 'class ="form-control"' "text"/>
            <br> Street   :<@spring.formInput "addressForm.street" 'class ="form-control"' "text"/>
            <br> Building   :<@spring.formInput "addressForm.building" 'class ="form-control"' "text"/>
            <br> House   :<@spring.formInput "addressForm.house" 'class ="form-control"' "text"/>

            <br>



            <br>
            <input type="submit" value="Create"/>
        </form>
    </fieldset>
</div>

</body>
</html>
