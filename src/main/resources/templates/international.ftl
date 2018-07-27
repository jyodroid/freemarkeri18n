<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Internationalization</title>
</head>
<body>
<h1><@spring.message "greetings"/></h1>
<span><@spring.message "lang.change"/></span>:
<select id="locales">
    <option value="">Select</option>
    <option value="en"><@spring.message "lang.en"/></option>
    <option value="sp_CO"><@spring.message "lang.sp"/></option>
    <option value="pt_BR"><@spring.message "lang.pt"/></option>
</select>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">
</script>

<script type="text/javascript">
    $(document).ready(function() {
        $("#locales").change(function () {
            var selectedOption = $('#locales').val();
            if (selectedOption != ''){
                window.location.replace('international?lang=' + selectedOption);
            }
        });
    });
</script>
</body>
</html>