package com.palette.zoopi.ui.signUp


class SignUpStep {
    enum class EmailPassword(val title: String) {
        EMAIL(title = "이메일을 입력해주세요"),
        PASSWORD(title = "비밀번호를 입력해주세요")
    }

    enum class AuthenticatePhone(val title: String, val offsetIndex: Int) {
        WIRE_SERVICE("통신사를 선택해주세요", offsetIndex = 0),
        PHONE_NUMBER("핸드폰 번호를 입력해 주세요", offsetIndex = 1),
        VERIFICATION_CODE("인증번호를 입력해 주세요", offsetIndex = 2),
        NAME("이름을 입력해 주세요", offsetIndex = 3),
        RECHECK_INFO("김여진님 정보가 맞나요?", offsetIndex = 3)
    }
}