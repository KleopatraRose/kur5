/*создаем объект WebSocked и указываем путь для подключения.
 * Подключение произойдет сразу после создания компонента.
 */

var id = 1;
var idseans=1;
var message;
var date;
var time;
var price;
var pl;
var mes="";
var webSocket = new WebSocket("ws://" + document.location.host + document.location.pathname + "websocket");
//var messages=document.getElementById("messages");
//var message=document.getElementById("message");

//обработчик события открытия соединения с сервером
webSocket.onopen=function(message){
    alert("Соединение установлено \n");
};
//обработчик события закрытия соединения с сервером
webSocket.onclose=function(message){
    alert("Соединение закрыто \n");
}
//обработчик ошибки при работе с сокетом.
webSocket.onerror=function (messag){
    alert("Произошла ошибка \n"+ messag.message);
}
//обработчик нажатия кнопки отправки сообщения

function getinfo() {

    message = "1#" + id;
    sendMessage();
    message = "2#" + id;
    sendMessage();
}


function getindex() {

    message = "3#" + id;
    sendMessage();
    message = "4#" + id;
    sendMessage();

}
function getfilms() {

    message = "5#" + id;
    sendMessage();

}

function filter(type, str)
{


    message = "6#" + type +"#"+str;
    alert("***"+str);
    sendMessage();
}

function getorder()
{
    message = "8#" + idseans;
    sendMessage();
}

function bookingconfirm()
{
    alert(arguments.length);
    var t=0;
    var b=1;
    p=pl.split('');
    for(var i=1; i< 49; i++)
    {
        if (i==parseInt(arguments[t])){
            p[i-1]= b.toString();
            t++;
        }
    }

    var pattern = RegExp("((.{8})+?|(.{1,8})$)", "g");
    p= p.join('');
    var splitted = p.match(pattern);
    mes="";
    for( var j=0; j<6; j++)
    {
        mes=mes+splitted[j]+"#";
    }
    alert(mes);

    message = "9#" + idseans+"#"+mes;
    sendMessage();
}



function setnewfilm(name, genre, country,year,about, age){
    message = "10#" + name+"#"+genre+"#"+age+"#"+about+"#"+year+"#"+country;
    sendMessage();
}

function getallfilms(i) {

    message = i+"#" + id;
    sendMessage();

}

function seteditfilm(iid,name, genre, country,year,about, age){
    message = "13#"+iid+"#"+ name+"#"+genre+"#"+age+"#"+about+"#"+year+"#"+country;
sendMessage();
}

function addseansform() {

    message = 16+"#" + id;
    sendMessage();

}

function sendMessage() {
    //отправляем сообщение на сервер
    webSocket.send(message);
    // alert("На сервер отправлено:>"+message+" \n");
    //message.value="";
}
//обработчик получения сообщения ОТ сервера.
webSocket.onmessage = function (message) {
    //messages.value+="Получено сообщение от сервера: "+message.data+" \n";

    var temp = message.data.split('#');
    var t =parseInt(temp[0]);
    alert(message.data);
    switch (t) {
        case 1:
        {
            document.getElementById('name').innerHTML = temp[2];
            document.getElementById("genre").innerHTML = temp[3];
            document.getElementById("rat").innerHTML = temp[4];
            document.getElementById("descr").innerHTML = temp[5];
            document.getElementById("year").innerHTML = temp[6];
            document.getElementById("country").innerHTML = temp[7];
            document.getElementById("cover").innerHTML = "<img src = 'css/covers/" + temp[1] + ".jpg'>";
            break;

        }
        case 2:
        {

            var kolseans= parseInt(temp[1]);

            s="";
            h=2;
            for (var i=0; i<kolseans; i++)
                s=s+"<tr><td>"+temp[h++]+"</td><td>"+temp[h++]+"</td><td>"+temp[h++]+
                    "</td><td><button class='order' id='"+temp[h++]+"' onclick='idseans=(this.id)'><a href='order.html'>Забронировать</a></button></td></tr>"

            document.getElementById('seans').innerHTML=s;

            break;
        }
        case 3:
        {

            var kolfilms= parseInt(temp[1]);
            s="";
            h=2;
            for (var i=0; i<kolfilms; i++) {
                tid = temp[h++];
                name = temp[h++];
                s = s + "<div class='movie' id=" + tid + ">" +
                    "<div class='movie-image'>" +
                    "<a href='#'><span class='play'><span class='name' >"+name+
                    "</span></span><img onclick=saveid("+tid+") src='css/images/movie" + tid + ".jpg' alt='movie' /></a>" +
                    "</div>            <div class='rating'>" +"<div id='namefilm'>"+name+"</div>"+
                    "<span class='commentsgreen'> + " + temp[h++] + "</span><span class='commentsred'>   " + temp[h++] + " - </span> </div></div>"
            }
            document.getElementById('lastmovie').innerHTML=s;
            break;
        }
        case 4:
        {
            var kolfilms= parseInt(temp[1]);
            s="";
            h=2;
            for (var i=0; i<kolfilms; i++) {
                tid = temp[h++];
                name = temp[h++];
                s = s + "<div class='movie' id=" + tid + ">" +
                    "<div class='movie-image'>" +
                    "<a href='#'><span class='play'><span class='name' >"+name+
                    "</span></span><img onclick=saveid("+tid+") src='css/images/movie" + tid + ".jpg' alt='movie' /></a>" +
                    "</div>            <div class='rating'>" +"<div id='namefilm'>"+name+"</div>"+
                    "<span class='commentsgreen'> + " + temp[h++] + "</span><span class='commentsred'>   " + temp[h++] + " - </span> </div></div>"
            }
            document.getElementById('popularmovie').innerHTML=s;
            break;
        }
        case 5:
        case 6:
        {
            var kolfilms= parseInt(temp[2]);
            s="";
            h=3;
            for (var i=0; i<kolfilms; i++) {
                tid = temp[h++];
                name = temp[h++];
                s = s + "<div class='movie' id=" + tid + ">" +
                    "<div class='movie-image'>" +
                    "<a href='#'><span class='play'><span class='name' >"+name+
                    "</span></span><img onclick=saveid("+tid+") src='css/images/movie" + tid + ".jpg' alt='movie' /></a>" +
                    "</div>            <div class='rating'>" +"<div id='namefilm'>"+name+"</div>"+
                    "<span class='commentsgreen'> + " + temp[h++] + "</span><span class='commentsred'>   " + temp[h++] + " - </span> </div></div>"
            }
            if (kolfilms==0) s="ФИЛЬМЫ ДАННОЙ КАТЕГОРИИ ОТСУТСТВУЮТ";
            document.getElementById('allmovie').innerHTML=s;
            document.getElementById('filterfilm').innerHTML=temp[1];
            break;
        }
        case 7:
        {

            break;
        }
        case 8:
        {
            onclick = "this.setAttribute('style', 'color: red;);";
            s = "";
            tids = temp[1];
            date=temp[3];
            time=temp[4];
            price=temp[5];
            pl = temp[6];
            name=temp[7];
            document.getElementById('namefilm1').innerHTML=name;
           for (var i = 1; i <=48; i++) {
               // alert(i);
              if (parseInt(pl[i-1])== 1) {
                  document.getElementById(i.toString()).setAttribute('style', 'background-color: #413E3E;');

              }
               if (parseInt(pl[i-1])== 0) {
                    document.getElementById(i.toString()).setAttribute('style', 'background-color: #ea7500; color: black');


                   document.getElementById(i.toString()).setAttribute('onclick', 'setplace('+i+');');
                   document.getElementById(i.toString()).setAttribute('type', 'free');
               }


          }

            break;
        }
        case 9:
        {
            document.getElementById('out').innerHTML="<br> <b>Ваш заказ подтвержден </b><br> "
            break;
        }
        case 10:
        {
            document.getElementById('addform').innerHTML="<br> <b>Фильм "+temp[1]+" успешно добавлен </b><br> "
            break;
        }
        case 11:
        {
            s="";
            h=2;
            for(var i=0; i< temp[1]; i++) {
                s = s + "<div id='allfilm'><label><input name='fil' type='radio' checked id="+temp[h++]+">"+temp[h++]+"</label><br></div>";
            }
            mes=s;
            var ss="<br><br>Изменение фильма:<br><br>"+s
            +"  <button class='order3'  onclick='editfilmform()'><b>Показать информацию</b></button>";
            document.getElementById('addform').innerHTML=ss;

            break;
        }
        case 12:
        {
            editfilmform1(temp[1],temp[2],temp[3],temp[4],temp[5],temp[6],temp[7]);
            break;
        }
        case 13:
        {
            document.getElementById('addform').innerHTML="<br> <b>Фильм "+temp[1]+" успешно изменен</b><br> "
            break;
        }
        case 14:
        {
            s="";
            h=2;
            for(var i=0; i< temp[1]; i++) {
                s = s + "<div id='allfilm'><label><input name='fil' type='radio' checked id="+temp[h++]+">"+temp[h++]+"</label><br></div>";
            }
            mes=s;
            var ss="<br><br>Удаление фильма:<br><br>"+s
                +"  <button class='order3'  onclick='delfilmform()'><b>Удалить</b></button>"+
                "  <button class='order3' onclick='closeform()'><b>Закрыть</b></button>";
            document.getElementById('addform').innerHTML=ss;

            break;
        }
        case 15:
        {
            document.getElementById('addform').innerHTML="<br> <b>Фильм успешно удален </b><br> "
            break;
        }
        case 16:
        {
            s="";
            h=2;
            for(var i=0; i< temp[1]; i++) {
                s = s + "<div id='allfilm'><label><input name='fil' type='radio' checked id="+temp[h++]+">"+temp[h++]+"</label><br></div>";
            }
            mes=s;
            addseansform1(mes);

            break;
        }

    }
}

function saveid(idd){
    id=idd;
}

function makeit(it){
    it.onclick='';
    alert('Делаем что-то');
}

function like(o)
{
    alert(o);
    message = "7#" + id+"#"+o;
    sendMessage();
    // makeit(this);
    document.getElementById('likes').innerHTML="Ваш голос учтен";
}

function setplace(idpl){

    if (document.getElementById(idpl.toString()).getAttribute('type')=="free") {
        document.getElementById(idpl.toString()).setAttribute('style', 'background-color: red; color:black;');
        document.getElementById(idpl.toString()).removeAttribute('type');
        document.getElementById(idpl.toString()).setAttribute('type', 'nofree');
        return;
    }
    if (document.getElementById(idpl.toString()).getAttribute('type')=="nofree") {
        document.getElementById(idpl.toString()).setAttribute('style', 'background-color: #ea7500; color:black;');
        document.getElementById(idpl.toString()).removeAttribute('type');
        document.getElementById(idpl.toString()).setAttribute('type', 'free');
        return;
    }

}

function booking()
{
    var kol= 0, s="", outstr="";
    var  a=[];
    var sa="";
    for (var i = 1; i <=48; i++) {
        if (document.getElementById(i.toString()).getAttribute('type')=="nofree") {
            a[kol++]=i;
            s=s+"#"+i;
            sa=sa+" "+i;
        }
    }

    outstr="<br><br> <h2 class='name1'>Ваш заказ</h2><br> Название фильма: "+  document.getElementById('namefilm1').innerHTML+
           "<br> Дата сеанса: " + date+
           "<br> Время сеанса: " + time +
           "<br> Дата сеанса: " + date+
           "<br> Цена билета: " + price+
           "<br> Количество билетов: " + kol+
           "<br> Номера мест: " + sa+
           "<br> <br> <b>Стоимость: " + (kol*price)+
           "<br>НДС: " + (kol*price*0.2)+
           "<br> <br> Итого: " + (kol*price*1.2)+"<br> <br>";

    outstr=outstr +
        "<div class='orderbut'>"+
        "<button class='order1' onclick='bookingconfirm("+a+")'><b>Подтвердить заказ</b></button>"+
        "</div>";
    document.getElementById('out').innerHTML=outstr;


}

function addfilmform(){
    var s="<br><br>Добавление фильма:<br><br>"+
        " Название:<br>"+
        " <input type='text' name='text1' id='aname' >"+
        "<br><br>"+
        " Жанр:<br>"+
        " <input type='text' name='text2' id='agenre'>"+
        "<br><br>"+
        "  Возрастной рейтинг:<br>"+
        "  <input type='text' name='text2' id='aage'>"+
        "<br><br>"+
        "  Страна:<br>"+
        " <input type='text' name='text2' id='acountry'>"+
        "<br><br>"+
        " Год:<br>"+
        "  <input type='text' name='text2' id='ayear'>"+
        "<br><br>"+
        "    Описание:<br>"+
        " <textarea name='text2' rows='6' id='aabout'></textarea>"+
        "  <br><br>"+
        "  <button class='order3'  onclick='addfilm();'><b>Добавить</b></button>"+
        "  <button type='reset' class='order3' ><b>Очистить</b></button>"+
        "  <button class='order3' onclick='closeform()'><b>Закрыть</b></button>";
    document.getElementById('addform').innerHTML=s;

}

function editfilmform(){

    var idd;
   // var s="<br><br>Изменение фильма:<br><br>"+ss;
   // document.getElementById('addform').innerHTML=s;
    var c = document.getElementsByName('fil');
    for (var i=0; i< c.length; i++)
    {
        if (c[i].checked == true)
        {
            idd = c[i].id;
            break;
        }
    }
    message = "12#" + idd;
    sendMessage();



}

function editfilmform1(qid,qname, qgenre,qrat,qdescr,qyear,qcountry)
{

    var sold="<br><br>Изменение фильма:<br><br>"+
        " Название:<br>"+
        " <input type='text' name='text1' id='aname' >"+
        "<br><br>"+
        " Жанр:<br>"+
        " <input type='text' name='text2' id='agenre'>"+
        "<br><br>"+
        "  Возрастной рейтинг:<br>"+
        "  <input type='text' name='text2' id='aage'>"+
        "<br><br>"+
        "  Страна:<br>"+
        " <input type='text' name='text2' id='acountry'>"+
        "<br><br>"+
        " Год:<br>"+
        "  <input type='text' name='text2' id='ayear'>"+
        "<br><br>"+
        "    Описание:<br>"+
        " <textarea name='text2' rows='6' id='aabout'></textarea>"+
        "  <br><br>"+
        "  <button class='order3'  onclick='editfilm("+qid+");'><b>Сохранить</b></button>"+
        "  <button class='order3' onclick='closeform()'><b>Закрыть</b></button>";
    document.getElementById('addform').innerHTML=sold;
    document.getElementById('aname').value=qname;
    document.getElementById('agenre').value=qgenre;
    document.getElementById('ayear').value=qyear;
    document.getElementById('acountry').value=qcountry;
    document.getElementById('aage').value=qrat;
    document.getElementById('aabout').value=qdescr;


}

function addfilmform1(element_id) {

    //Если элемент с id-шником element_id существует
    if (document.getElementById(element_id)) {
        //Записываем ссылку на элемент в переменную obj
        var obj = document.getElementById(element_id);
        //Если css-свойство display не block, то:
        if (obj.style.display != "block") {
            obj.style.display = "block"; //Показываем элемент
        }
    else obj.style.display = "none"; //Скрываем элемент
    }
    //Если элемент с id-шником element_id не найден, то выводим сообщение
else alert("Элемент с id: " + element_id + " не найден!");

}

function delfilmform() {

    var idd;
    // var s="<br><br>Изменение фильма:<br><br>"+ss;
    // document.getElementById('addform').innerHTML=s;
    var c = document.getElementsByName('fil');
    for (var i = 0; i < c.length; i++) {
        if (c[i].checked == true) {
            idd = c[i].id;
            break;
        }
    }


    message = "15#" + idd;
    sendMessage();
}

function valName(a, id, b,c){
    if (a.length<b || a.length>c) {
       // document.getElementById(id).setAttribute('style', 'color: red');
        return 1;
    }
    return 0;
}

function addfilm()
{
    var  res=0;

    var name=document.getElementById('aname').value;
    var genre=document.getElementById('agenre').value.toLowerCase();
    var country=document.getElementById('acountry').value;
    var year=document.getElementById('ayear').value;
    var about=document.getElementById('aabout').value;
    var age=document.getElementById('aage').value;

    res=validate(name, genre, country,year,about, age);


    if (res==0) setnewfilm(name, genre, country,year,about, age);
    if (res==1) alert('Форма заполнена неверно');


}

function editfilm(iid)
{
    var  res=0;
    var name=document.getElementById('aname').value;
    var genre=document.getElementById('agenre').value.toLowerCase();
    var country=document.getElementById('acountry').value;
    var year=document.getElementById('ayear').value;
    var about=document.getElementById('aabout').value;
    var age=document.getElementById('aage').value;

    res=validate(name, genre, country,year,about, age);


    if (res==0) seteditfilm(iid,name, genre, country,year,about, age);
    if (res==1) alert('Форма заполнена неверно');


}

function closeform(){
    document.getElementById('addform').innerHTML="";
}

function validate(name, genre, country,year,about, age){
    res=0;
    if (valName(name,aname,1,40)!=0) res=1;
    if (valName(genre,agenre,1,40)!=0) res=1;
    if (valName(country,acountry,1,40)!=0) res=1;
    if (valName(year,ayear,4,4)!=0) res=1;
    if (valName(about,aabout,10,480)!=0) res=1;
    if (valName(age,aage,1,2)!=0) res=1;
    d=new Date();
    if (year<1900 || year>d.getFullYear()) res=1;
    if (!(/^[а-яёa-z]+$/i.test(genre))) res=1;
    if (!(/^[а-яёa-z]+$/i.test(country))) res=1;
    if (!(/[0-9]/g.test(year))) res=1;
    if (!(/[0-9]/g.test(age))) res=1;





    return res;
}




function addseansform1(mes){
    var s="<br><br>Добавление сеанса :<br><br>"+mes+



        " Дата:<br>"+
        " <input  type='date' name='text1' id='aname' >"+
        "<br><br>"+
        " Время:<br>"+
        " <input type='time' name='text2' id='agenre'>"+
        "<br><br>"+
        " Цена билета:<br>"+
        "  <input type='text' name='text2' id='aage'>"+
        "<br><br>"+

        "  <button class='order3'  onclick='addseans();'><b>Добавить</b></button>"+
        "  <button type='reset' class='order3' ><b>Очистить</b></button>"+
        "  <button class='order3' onclick='closeform()'><b>Закрыть</b></button>";
    document.getElementById('seansform').innerHTML=s;

}





















