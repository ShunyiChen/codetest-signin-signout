# User signin,signup and signout

一个简单的用户注册，登录登出功能基于spring boot,spring mvc,spring security,jwt,mybatis-plus的实现。

```sh
API接口：

注册
POST localhost:8080/signup
参数
{
"username":"tester",
"password":"123456",
"admin":false
}

登录
POST localhost:8080/signin
参数
{
"username":"tester",
"password":"123456"
}
描述：登录成功后会生成一个token，并保持token到数据库，同时根据用户类型创建角色；

获取用户
GET localhost:8080/getusers
无参数
描述：需要携带头信息Authorization比如Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0ZXIiLCJleHAiOjE2Mjc0MDIxNjAsImlhdCI6MTYyNzQwMTU2MH0.63X9ABfyiLVUrtFP04vN64_PIBoJRJ0ROaleDtD2IfZOzIGJvJ8zHVWfqAaY9P8CGbtbNgoeD4T99IEodSpidA


获取Token
GET localhost:8080/gettokens
无参数
描述：需要携带头信息Authorization比如Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0ZXIiLCJleHAiOjE2Mjc0MDIxNjAsImlhdCI6MTYyNzQwMTU2MH0.63X9ABfyiLVUrtFP04vN64_PIBoJRJ0ROaleDtD2IfZOzIGJvJ8zHVWfqAaY9P8CGbtbNgoeD4T99IEodSpidA

退出
POST localhost:8080/signout
参数名：token
参数值：eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0ZXIiLCJleHAiOjE2Mjc0MDIxNjAsImlhdCI6MTYyNzQwMTU2MH0.63X9ABfyiLVUrtFP04vN64_PIBoJRJ0ROaleDtD2IfZOzIGJvJ8zHVWfqAaY9P8CGbtbNgoeD4T99IEodSpidA
注意：参数值不包含Bearer 
描述：需要携带头信息Authorization比如Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0ZXIiLCJleHAiOjE2Mjc0MDIxNjAsImlhdCI6MTYyNzQwMTU2MH0.63X9ABfyiLVUrtFP04vN64_PIBoJRJ0ROaleDtD2IfZOzIGJvJ8zHVWfqAaY9P8CGbtbNgoeD4T99IEodSpidA
```















