package kz.edil.jusanhomeworks6

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        initButtons()
    }

    private fun initButtons() {
        initShareButton()
        initSendEmailButton()
        initCallButton()
        initCameraButton()
    }

    private fun initShareButton() {
        val btnShare: Button = findViewById(R.id.btn_share)
        btnShare.setOnClickListener {
            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Here is my profile!")
            sendIntent.type = "text/plain"
            startActivity(sendIntent)
        }
    }

    private fun initSendEmailButton() {
        val btnSendViaEmail: Button = findViewById(R.id.btn_send_via_email)
        btnSendViaEmail.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.type = "text/plain"
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Касательно вашего приложения")
            emailIntent.putExtra(
                Intent.EXTRA_TEXT,
                "Хотел пожаловаться на ваше приложение. Оно очень сырое и "
            )

            if (emailIntent.resolveActivity(packageManager) != null) {
                startActivity(Intent.createChooser(emailIntent, "Отправить через..."))
            }
        }

    }



    private fun initCallButton() {
        val btnCall: Button = findViewById(R.id.btn_call)
        btnCall.setOnClickListener {
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "+7777838"))
        startActivity(intent) }

    }

    private fun initCameraButton() {
        val btnCamera: Button = findViewById(R.id.btn_camera)
        btnCamera.setOnClickListener {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(cameraIntent)
        }

    }

}