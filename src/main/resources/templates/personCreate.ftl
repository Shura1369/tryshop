
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
        <legend>Create person</legend>
        <form name="person" action="" method="GET">

<tr>

<tr>
        </form>

                <form name="person" action="" method="POST">
                    <br> Passport      :<@spring.formInput  "personForm.passport" 'class ="form-control" readonly' "text" />
                    <td> <a href="/passport/create/" type="button" class="btn btn-success">CreatePassport</a>
                    <br> Address      :<@spring.formInput  "personForm.address" 'class ="form-control" readonly' "text" />
                    <td>  <a href="/address/create/" type="button" class="btn btn-success">CreateAddress</a>
                        <br>Gender : <@spring.formSingleSelect "personForm.gender",genders 'class="form-control"'/>
                    <br>   IPN : <@spring.formInput "personForm.ipn" 'class ="form-control"' "text"/>
                   <br> <input type="submit" value="Create"/>
                </form>
    </fieldset>
</div>

</body>
</html>
