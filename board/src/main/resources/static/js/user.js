let index = {
    init: function () {
        $("#btn-save").on("click", () => {
            this.save();
        });
    },

    save: function () {
        // alert("user의 save함수 호출됨"); // 작동 테스트
        let data = {
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val(),
        }

        // console.log(data);

        // ajax 호출시 default가 비동기 호출
        // ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청!
        // ajax가 통신을 성공하고 서버가 json을 리턴해주면 자동으로 자바 오브젝트로 변환해줌
        $.ajax({
            type:"POST",
            url:"/api/user",
            data:JSON.stringify(data), // http body 데이터
            contentType: "application/json; charset=utf-8",// body 데이터가 어떤 타입인지(MIME)
            dataType:"JSON"
            // 요청을 서버로해서 응답이 왔을 때 기본적을 모든 것이 문자열(생긴게 json이라면) => js오브젝트로 변경
        }).done(function (res) {
            alert("회원가입이 완료되었습니다.")
            // console.log(res);
            location.href = "/";
        }).fail(function (err) {
            alert(JSON.stringify(err));
        });
    }
}

index.init();