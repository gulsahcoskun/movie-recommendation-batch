<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Movie Recommendation Weekly Mail</title>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>

    <!-- use the font -->
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            font-size: 48px;
        }

        b{
            font-size: 15px;
        }
    </style>
</head>
<body style="margin: 0; padding: 0;">

<table align="center" border="0" cellpadding="0" cellspacing="0" width="800" style="border-collapse: collapse;">
    <tr>
        <td align="center" bgcolor="#33C7FF" style="padding: 40px 0 30px 0;">
            <p style="color: ivory"><b>HAFTALIK FİLM ÖNERİLERİ</b></p>
        </td>
    </tr>
    <tr>
        <td bgcolor="#eaeaea" style="padding: 40px 50px 40px 50px;">
        <#list movies as movie>
            <p style="color:crimson;"><b><i> ${movie.type},</i></b></p>
            <p>Film adı : ${movie.title}</p>
            <p>Özet: ${movie.overview} </p>
            <p>Oylama Puanı: ${movie.vote}</p>
            <p>Popülerlik: ${movie.popularity} </p>
            <p>Tarihi: ${movie.releaseDate} </p>
            <hr>
        </#list>
        </td>
    </tr>
    <tr>
        <td bgcolor="#777777" style="padding: 10px 50px 10px 50px;">
            <p>İyi Seyirler,</p>
            <p><i>Gülşah Coşkun</i></p>
        </td>
    </tr>
</table>

</body>
</html>