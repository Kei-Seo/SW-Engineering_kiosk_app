package com.example.locationtracking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    //구글 로그인
    private lateinit var googleSignInClient: GoogleSignInClient
    val GOOGLE_REQUEST_CODE = 99
    val TAG = "googleLogin"
    //파이어 베이스 인증처리
    private lateinit var mEtEmail: EditText // 회원가입 입력 필드
    private lateinit var mEtPwd: EditText //
    private lateinit var btn_login: Button
    private  var auth: FirebaseAuth? = null
    var backKeyPressedTime : Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //구글 로그인 구성성
        var gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient (this, gso)


        login_google.setOnClickListener { GoogleSignIn() }


        auth = FirebaseAuth.getInstance(); //파이어베이스 통합 객체 생성
        mEtEmail = findViewById(R.id.login_email)
        mEtPwd = findViewById(R.id.login_pwd)
        btn_login = findViewById(R.id.btn_login)


        /*btn_login.setOnClickListener(View.OnClickListener {
            //로그인 요청
            val strEmail: String = mEtEmail.text.toString().trim()
            val strPwd: String = mEtPwd.text.toString().trim()
            if (strEmail.length < 1 || strPwd.length < 1) {
                var toast = Toast.makeText(this, "입력칸이 공란입니다.", Toast.LENGTH_SHORT)
                toast.show()
            } else {

                auth!!.signInWithEmailAndPassword(strEmail, strPwd)
                    .addOnCompleteListener { signIn ->
                        if (signIn.isSuccessful) {
                            val intent: Intent = Intent(this, MapsActivity::class.java)
                            startActivity(intent)
                            finish()// 현재 activity destroy
                        } else {
                            Toast.makeText(this, "이메일 혹은 비밀번호를 확인해주세요!", Toast.LENGTH_SHORT).show()
                        }

                    }


            }
        }
        )*/


        btn_login.setOnClickListener {
               val intent: Intent = Intent(this, SelectMenuActivity::class.java)
               startActivity(intent)
        }


        btn_register.setOnClickListener {
            val intent: Intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }


    }

    private fun GoogleSignIn(){
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, GOOGLE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == GOOGLE_REQUEST_CODE) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)!!
                Log.d(TAG, "firebaseAuthWithGoogle:" + account.id)
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e)
                Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth?.signInWithCredential(credential)
            ?.addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "로그인 성공")
                    val user = auth!!.currentUser
                    loginSuccess()
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithCredential:failure", task.exception)
                }
            }
    }
    private fun loginSuccess(){
        val intent = Intent(this,SelectMenuActivity::class.java)
        startActivity(intent)
        finish()
    }
    public override fun onStart() {
        super.onStart()
        //유저가 로그인되어있는지 확인 //
        val currentUser = auth!!.currentUser
        moveMain(currentUser)
    }
    //유저가 로그인하면 메인액티비티로 이동
    private fun moveMain(user: FirebaseUser?) {
        if (user != null) {
            startActivity(Intent(this,SelectMenuActivity::class.java))
            finish()
        }
    }


    override fun onBackPressed() {
        //1번째 백버튼 클릭
        if(System.currentTimeMillis()>backKeyPressedTime+2000){
            backKeyPressedTime = System.currentTimeMillis();
            Toast.makeText(this, "한번 더 누르시면 앱이 종료됩니다", Toast.LENGTH_SHORT).show();
        }
        //2번째 백버튼 클릭 (종료)
        else{
            finishAffinity()
            System.exit(0)
            android.os.Process.killProcess(android.os.Process.myPid())
        }
    }

}