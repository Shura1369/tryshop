
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
        <legend>Create passport</legend>
        <form name="passport" action="" method="POST">
            Number      :<@spring.formInput "passportForm.number" 'class ="form-control"' "text"/>
            <br> First name  :<@spring.formInput "passportForm.firstName" 'class ="form-control"' "text"/>
            <br> Middle name :<@spring.formInput "passportForm.middleName" 'class ="form-control"' "text"/>
            <br> Last name   :<@spring.formInput "passportForm.lastName" 'class ="form-control"' "text"/>
            <br> Birth date  :<@spring.formInput "passportForm.birthDate"'class ="form-control" readonly width="300"' />
            <br>

            <script>
                $('#birthDate').datepicker({
                    uiLibrary: 'bootstrap4'
                });
            </script>

            <br>
            <br> Date obtain :<@spring.formInput "passportForm.dataObt"'class ="form-control" readonly width="300"' />
            <br>

            <script>
                $('#dataObt').datepicker({
                    uiLibrary: 'bootstrap4'
                });
            </script>

            <br>
            <input type="submit" value="Create"/>
        </form>
    </fieldset>
</div>

</body>
</html>
