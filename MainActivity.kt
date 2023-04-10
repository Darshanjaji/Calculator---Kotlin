package hiapp.tutorial.calculator

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
     var lastNumaric=false
    var lastDot = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation=(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        setContentView(R.layout.activity_main)




    }
    fun btn7(view: View)
    {
      text1?.append((view as Button).text)
        lastNumaric=true
        lastDot=false

    }
    fun onclear(view: View)
    {
       text1?.text=""
        isopertoradded(text1.toString())

    }
    fun ondot(view: View)
    {
        if(lastNumaric && !lastDot)
        {
            text1?.append(".")
            lastNumaric=false
            lastDot=true

        }

    }
    fun onoperator(view: View){
        text1?.text?.let {
            if (lastNumaric && !isopertoradded(it.toString()))
            {
                text1.append((view as Button).text)
                lastNumaric=false
                lastDot=false
            }
        }
    }




    fun isopertoradded(value:String):Boolean
    {
        return if (value.startsWith("-"))
        {
            false
        }
        else
        {
            value.contains("/")
                    ||value.contains("+")||
                    value.contains("-")
                    || value.contains("*")
        }
    }



    fun onequals(view: View)
    {
        if(lastNumaric)
        {
            var ontv=text1?.text?.toString()
            var prifix=""
            try{
                if (ontv != null) {
                    if(ontv.startsWith("-")) {
                        prifix="-"
                        ontv=ontv.substring(1)

                    }
                }
                if(ontv!!.contains("-"))
                {
                    var split = ontv.split("-")
                    var one = split[0]
                    var two = split[1]
                    text1.text=removezero((one.toDouble() - two.toDouble()).toString())
                    if(prifix.isNotEmpty())
                      one = prifix + one

                }
                else  if(ontv!!.contains("+"))
                {

                    var split = ontv.split("+")
                    var one = split[0]
                    var two = split[1]
                    text1.text=removezero((one.toDouble() + two.toDouble()).toString())
                    if(prifix.isNotEmpty())

                        one=prifix+one

                }
                else   if(ontv!!.contains("*"))
                {

                    var split = ontv.split("*")
                    var one = split[0]
                    var two = split[1]
                    text1.text=removezero((one.toDouble() * two.toDouble()).toString())
                    if(prifix.isNotEmpty())

                        one=prifix+one

                }
                else  if(ontv!!.contains("/"))
                {

                    var split = ontv.split("/")
                    var one = split[0]
                    var two = split[1]
                    text1.text=removezero((one.toDouble() / two.toDouble()).toString())
                    if(prifix.isNotEmpty())

                        one=prifix+one

                }


                }


            catch (e:Exception)
{

}
        }
    }
    fun removezero(result:String):String
    {
        var value=result
        if(result.contains(".0"))
            value=result.substring(0,result.length-2)
        return  value

    }


}