package com.example.locationtracking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RegisterActivity : AppCompatActivity() {

    private val RC_SIGN_IN = 9001
    private lateinit var firebaseAuth: FirebaseAuth

    //파이어 베이스 인증처리
    private lateinit var databaseRef: DatabaseReference //실시간 데이터 베이스
    private lateinit var mEtEmail: EditText // 회원가입 입력 필드
    private lateinit var mEtPwd: EditText //
    private lateinit var mBtnRegister: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        firebaseAuth = FirebaseAuth.getInstance();
        databaseRef = FirebaseDatabase.getInstance().getReference("CBUS")


        mEtEmail = findViewById(R.id.et_email)
        mEtPwd = findViewById(R.id.et_pwd)
        mBtnRegister = findViewById<Button>(R.id.btn_register1)

        mBtnRegister.setOnClickListener(View.OnClickListener {
            var strEmail: String = mEtEmail.text.toString().trim()
            var strPwd: String = mEtPwd.text.toString().trim()
            // FireBase 인증 처리
            firebaseAuth.createUserWithEmailAndPassword(strEmail, strEmail)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val firebaseUser: FirebaseUser = firebaseAuth.currentUser!!
                        val account: UserAccount =
                            UserAccount(firebaseUser.email, strPwd, firebaseUser.uid)

                        // setValue database에 insert  (삽입) 행위
                        databaseRef.child("UserAccount").child(firebaseUser.uid).setValue(account)
                        Toast.makeText(this, "회원가입에 성공했습니다.", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "회원가입에 실패했습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
        })
    }


}