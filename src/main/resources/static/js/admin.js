// var updatepwd=document.getElementById("updatePwdButton");
// updatepwd.addEventListener('click',function(){
// 	var xhr,url='/updatpwd',data='pwd'+document.getElementById('pwd').value+'&npwd'+document.getElementById('npwd').value+'&fpwd'+document.getElementById('fpwd').value;
// 	xhr=doajax(url,data);
// 	xhr.onload = function(){
// 		var text;
// 		if(xhr.status==200){
// 			if(xhr.response=='ture'){
// 				text="비밀번호변경완료";
// 				location.href="/";
// 		 }else{
// 			text="틀립니다.";
// 		}
// 		alert(text);
// 		}
// 	}
// })

let index = {
  init: function () {
    $("#btn-save").on("click", () => {
      this.save();
    });
    $("#btn-update").on("click", () => {
      this.update();
    });
    $("#btn-delete").on("click", () => {
      this.delete();
    });
  },

  save: function () {
    let data = {
      role: $("#role1").val(),
      role: $("#role2").val(),
      username: $("#username").val(),
      userId: $("#userId").val(),
      password: $("#password").val(),
      email: $("#email").val(),
      phone: $("#phone").val(),
    };

    console.log(data);

    $.ajax({
      type: "POST",
      url: "/auth/joinProc",
      data: JSON.stringify(data),
      contentType: "application/json; charset=utf-8",
      dataType: "json",
    })
      .done(function (resp) {
        alert("회원가입이 완료되었습니다.");
        location.href = "/amin";
      })
      .fail(function (error) {
        alert(JSON.stringify(error));
      });
  },
  update: function () {
    let data = {
      id: $("#id").val(),
      userId: $("#userId").val(),
      username: $("#username").val(),
      password: $("#password").val(),
      phone: $("#phone").val(),
      email: $("#email").val(),
    };

    $.ajax({
      type: "POST",
      url: "/auth/user",
      data: JSON.stringify(data),
      contentType: "application/json; charset=utf-8",
      dataType: "json",
    })
      .done(function (resp) {
        alert("회원수정이 완료되었습니다.");
        location.href = "/";
      })
      .fail(function (error) {
        alert(JSON.stringify(error));
      });
  },
  delete: function () {
    let id = $("#id").text();

    $.ajax({
      type: "DELETE",
      url: "/delete/" + id,
      dataType: "json",
    })
      .done(function (resp) {
        alert("삭제가 완료되었습니다.");
        location.href = "/";
      })
      .fail(function (error) {
        alert(JSON.stringify(error));
      });
  },
};

index.init();

/*01 function doAjax(u,p,f){
02  var args = doAjax.arguments;
03  var xmlHttp = getXmlHttpRequest();
04  xmlHttp.open("POST", u, false); // POST 방식, GET 방식 선택
05  xmlHttp.setRequestHeader('Content-Type','application/x-www-form-urlencoded; charset=euc-kr'); // EUC-KR
06  xmlHttp.setRequestHeader('Cache-Control','no-cache,must-revalidate'); // 캐시 없앰
07  xmlHttp.setRequestHeader('Pragma','no-cache'); // 캐시 없앰
08  xmlHttp.onreadystatechange = function() {
09   if(xmlHttp.readyState==4){
10    if(xmlHttp.status==200){
11     window[f](args[3], xmlHttp); // args[3] 은 4번째 파라미터를 의미, xmlHttp 는 Ajax 결과물
12    }
13   }
14  }
15  xmlHttp.send(p); // get 방식이면 p 대신 null
16 }
17
18
19 function goWhere(where){
20  var url, params;
21  if(where=='AA') url = '...';
22  else if(where=='BB'){
23   url = '...';
24   params = '';
25  }else if(where=='CC') url = '...';
26  else if(where=='DD') url = '...';
27
28  doAjax(url,params,'doAfterAjax',where);
29 }
30
31
32 function doAfterAjax(where,xmlHttp){
33  if(where=='AA'){
34   document.getElementById('idContent1').innerHTML = xmlHttp.responseText;
35  }
36 }
*/
