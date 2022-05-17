package `in`.csias.tcclient.allcountryotp

import `in`.csias.tcclient.MainActivity
import `in`.csias.tcclient.MainFragment
import `in`.csias.tcclient.R
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main_otp.*

class MainOtpActivity : AppCompatActivity(), View.OnClickListener {

    private var phoneNumber: String? = null
    private var countryCode: String? = null
    private var alertDialogBuilder: AlertDialog.Builder? = null

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_otp)
        supportActionBar?.hide()
        initViews()

        auth = FirebaseAuth.getInstance()

        if (auth.currentUser != null) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun initViews() {
        next_btn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            next_btn -> {
                countryCode = ccp!!.selectedCountryCodeWithPlus
                phoneNumber = phoneNumberEt.text.toString()
                phoneNumber = "" + countryCode + phoneNumber

                //Log.e("User Phone Number ===  ", phoneNumber)

                if (validatePhoneNumber(phoneNumberEt.text.toString())) {
                    notifyUserBeforeVerify("We will be verfiying the phone number:\n\n$phoneNumber\n" +
                            "Is this OK, or would you like to edit the number? -_-")
                } else {
                    toast("Please enter a valid number to continue!")
                }

            }
        }

    }

    private fun toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun validatePhoneNumber(phone: String): Boolean {
        if (TextUtils.isEmpty(phone)) {
            return false
        }

        return true
    }

    private fun notifyUserBeforeVerify(message: String) {
        alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder!!.setMessage(message)
        alertDialogBuilder!!.setPositiveButton("Ok") { _, _ ->
            showLoginActivity()
        }

        alertDialogBuilder!!.setNegativeButton("Edit") { dialog, _ ->
            dialog.dismiss()
        }

        alertDialogBuilder!!.setCancelable(false)
        alertDialogBuilder!!.create()
        alertDialogBuilder!!.show()
    }


    private fun showLoginActivity() {
        startActivity(
            Intent(this, LoginActivity::class.java).putExtra("phoneNumber", phoneNumber))
        // close the current ;)
        finish()
    }


}
