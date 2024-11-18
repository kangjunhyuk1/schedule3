# schedule-management2

* ERD : https://lucid.app/lucidchart/f3f39b42-142e-4b72-a2fb-447b7e4c3b2e/edit?beaconFlowId=3D32FF37A8FE87D3&invitationId=inv_4592da2a-b0e5-4180-88d1-beb59a3bd8c4&page=0_0#
-----
* 일정 생성 API
  
|기능|Method|URL|Header|상태코드|Request필수 여부|
|------|---|---|---|---|---|
|일정 추가|POST|/schedules|content-type : application/json|200 정상등록, 400 잘못된 요청|scheduleName : O, task : O

* 일정 추가 Request
```
{
   "userId":"1",
   "scheduleName":"일본 여행",
   "task":"아침 7시까지 공항 도착"
}
```

* 일정 추가 Response
```
{
   "message":"저장되었습니다",
   "scheduleId":"1"
}
```

* 에러(400) Response
```
{
   "error":"작성을 완료해주세요"
}
```

|기능|Method|URL|Header|상태코드|Request필수 여부|
|------|---|---|---|---|---|
|일정 조회(단건)|GET|/schedules/{scheduleId}||200정상 등록, 404 리소스를 찾을 수 없음|

* 일정 조회(단건) Response
```
{
   "userId":"1",
   "scheduleId":"1",
   "scheduleName":"일본 여행",
   "task":"아침 7시까지 공항 도착"
}
```
* 에러(404) Response
```
{
   "error":"존재하지 않는 일정입니다"
}
```


|기능|Method|URL|Header|상태코드|Request필수 여부|
|---|---|---|---|---|---|
|일정 조회(다건)|GET|/schedules||200 정상 등록, 404 리소스를 찾을 수 없음|

* 일정 조회(다건) Request
```
{
   "shcedules":[
      {
         "userId":"1",
         "scheduleId":"1",
         "scheduleName":"일본 여행",
         "task":"아침 7시까지 공항 도착"
      },
      {
         "userId":"1",
         "scheduleId":"2",
         "scheduleName":"내 생일",
         "task":"저녁에 외식"
      }
   ]
}
```
* 에러(404) Response
```
{
   "error":"존재하지 않는 일정입니다"
}
```

|기능|Method|URL|Header|상태코드|Request필수 여부|
|---|---|---|---|---|---|
|일정 수정|PUT|/schedules/{scheduleId}|content-type : application/json|200 정상 등록, 404 리소스를 찾을 수 없음|

* 일정 수정 Request
```
{
   "userId":"1",
   "scheduleId":"1",
   "scheduleName":"일본 여행",
   "task":"아침 7시까지 공항 도착, 은행가서 환전하기"
}
```
* 일정 수정 Response

```
{
   "message":"저장되었습니다"
}
```

* 에러(404) Response
```
{
   "error":"존재하지 않는 일정입니다"
}
```


|기능|Method|URL|Header|상태코드|Request필수 여부|
|---|---|---|---|---|---|
|일정 삭제|DELETE|/schedules/{scheduleId}||200 정상 등록, 404 리소스를 찾을 수 없음||

* 삭제 완료 Response
```
{
   "message":"삭제되었습니다"
}
```

*  에러(404) Response
```
{
   "error":"존재하지 않는 일정입니다"
}
```
-----

* 유저 생성 API

|기능|Method|URL|Header|상태코드|Request필수 여부|
|------|---|---|---|---|---|
|유저 추가|POST|/users|content-type : application/json|200 정상 등록, 400 잘못된 요청|userName : O, password : O, email : O|

* 유저 추가 Request

```
{
   "userName":"강준혁",
   "password":"test123",
   "email":"tast@email.com"
}
```
* 유저 추가 Response

```
{
   "message":"저장되었습니다",
   "userId":"1"
}
```

* 에러(400) Response

```
{
   "error":"작성을 완료해주세요"
}
```

|기능|Method|URL|Header|상태코드|Request필수 여부|
|------|---|---|---|---|---|
|유저 조회(단건)|GET|/users/{user_id}||200 정상 등록, 404 리소스를 찾을 수 없음||

* 유저 조회(단건) Response

```
{
   "userId":"1",
   "userName":"강준혁",
   "password":"test123",
   "email":"tast@email.com"
}
```

* 에러(404) Response

```
  {
   "error":"존재하지 않는 유저입니다"
  }
```

|기능|Method|URL|Header|상태코드|Request필수 여부|
|------|---|---|---|---|---|
|유저 조회(다건)|GET|/users||200 정상 등록, 404 리소스를 찾을 수 없음||

* 유저 조회(다건) Response

```
{
   "users":[
      {
         "userId":"1",
         "userName":"강준혁1",
         "password":"test123",
         "email":"tast1@email.com"
      },
      {
         "userId":"2",
         "userName":"강준혁2",
         "password":"test456",
         "email":"tast2@email.com"
      }
   ]
}
```

* 에러(404) Response

```
  {
   "error":"존재하지 않는 유저입니다"
  }
```

|기능|Method|URL|Header|상태코드|Request필수 여부|
|---|---|---|---|---|---|
|유저 수정|PUT|/users/{userId}|content-type : application/json|200 정상 등록, 404 리소스를 찾을 수 없음|

* 유저 수정 Request

```
{
   "userId":"1",
   "userName":"강준혁1",
   "password":"test567",
   "email":"tast1@email.com"
}
```
* 유저 수정 Request
```
{
   "message":"저장되었습니다"
}
```
* 에러(404) Request

```
  {
   "error":"존재하지 않는 유저입니다"
  }
```

|기능|Method|URL|Header|상태코드|Request필수 여부|
|---|---|---|---|---|---|
|유저 삭제|DELETE|/users/{userId}||200 정상 등록, 404 리소스를 찾을 수 없음||

* 삭제 완료 Response
```
{
   "message":"삭제되었습니다"
}
```

*  에러(404) Response
```
{
   "error":"존재하지 않는 일정입니다"
}
```

-----


* SQL

```
create database Schedule_management;

create table users (
	user_id bigint not NULL auto_increment,
    user_name varchar(12) not null,
    user_password varchar(15) not null,
    email varchar(100) not null,
    created_date datetime DEFAULT CURRENT_TIMESTAMP,
    modified_date datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    primary key(user_id)
	);


create table calendar(
	calendar_id bigint(30) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id bigint,
    schedule_name varchar(100) not null,
    task varchar(100) not null,
    created_date datetime DEFAULT CURRENT_TIMESTAMP,
    modified_date datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    primary key(calendar_id),
    foreign key (user_id) references users (user_id)
    );
    
    
   -- 데이터 추가--
    INSERT INTO
		users (id, user_name, user_password, emali, created_date, modified_date)
    VALUES
		(1, '강준혁', 'test', 'test123@email.com', now(), now());
        
	-- 데이터 조회(단건)--
    select user_id
    from users
    where user_id = 1;
    
    -- 데이터 조회(다건) --
    select *
    from users;
    
    -- 데이터 수정 --
    update users
    set user_name = '강준혁3';
    
    -- 데이터 삭제 --
    delete from user
    where user_name = '강준혁3';
```
