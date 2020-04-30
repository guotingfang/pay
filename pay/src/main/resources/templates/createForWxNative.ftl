<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" >
    <title>支付</title>

</head>
<body>
    <div id="myQrcode"></div>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
    <script src="https://cdn.bootcdn.net/ajax/libs/qrcodejs/1.0.0/qrcode.min.js"></script>

    <script type="text/javascript">
            new QRCode(document.getElementById("myQrcode"), "${codeUrl}");
    </script>

</body>
</html>
