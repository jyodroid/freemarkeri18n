<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Internationalization</title>
</head>
<body>
<h1>Hello</h1>
<span>Change</span>:
<select id="locales">
    <option value=""></option>
    <option value="en">English</option>
    <option value="sp">Spanish</option>
</select>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">
</script>

<script type="text/javascript">
    $(document).ready(function() {
        $("#locales").change(function () {
            var selectedOption = $('#locales').val();
            if (selectedOption != ''){
                window.location.replace('hardcoded?lang=' + selectedOption);
            }
        });
    });
</script>
</body>
</html>