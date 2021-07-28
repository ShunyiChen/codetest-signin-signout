# Demo01

APIs:

注册
POST localhost:8080/signup
{
"username":"tester",
"password":"123456",
"admin":false
}

登录
POST localhost:8080/signin
{
"username":"tester",
"password":"123456"
}

生成token


获取用户
GET localhost:8080/getusers
需要携带头信息 Authorization       Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0ZXIiLCJleHAiOjE2Mjc0MDIxNjAsImlhdCI6MTYyNzQwMTU2MH0.63X9ABfyiLVUrtFP04vN64_PIBoJRJ0ROaleDtD2IfZOzIGJvJ8zHVWfqAaY9P8CGbtbNgoeD4T99IEodSpidA


获取Token
GET localhost:8080/gettokens
需要携带头信息 Authorization       Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0ZXIiLCJleHAiOjE2Mjc0MDIxNjAsImlhdCI6MTYyNzQwMTU2MH0.63X9ABfyiLVUrtFP04vN64_PIBoJRJ0ROaleDtD2IfZOzIGJvJ8zHVWfqAaY9P8CGbtbNgoeD4T99IEodSpidA


退出
POST localhost:8080/signout
需要携带头信息 Authorization       Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0ZXIiLCJleHAiOjE2Mjc0MDIxNjAsImlhdCI6MTYyNzQwMTU2MH0.63X9ABfyiLVUrtFP04vN64_PIBoJRJ0ROaleDtD2IfZOzIGJvJ8zHVWfqAaY9P8CGbtbNgoeD4T99IEodSpidA
参数名：token
参数值：eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0ZXIiLCJleHAiOjE2Mjc0MDIxNjAsImlhdCI6MTYyNzQwMTU2MH0.63X9ABfyiLVUrtFP04vN64_PIBoJRJ0ROaleDtD2IfZOzIGJvJ8zHVWfqAaY9P8CGbtbNgoeD4T99IEodSpidA











