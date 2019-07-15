
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>
    <script>
        $(function(){
            $().click(function(){
                $.ajax({
                    url:
                    contentType:
                    data:
                    dataType:
                    type:
                    success:function(data){
                        alert(data);
                        alert(data.addresName);
                    }
                })
            })
        });

    </script>
</head>
<body>

</body>
</html>
