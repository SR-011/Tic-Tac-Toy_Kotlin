  package com.sr0112.tictactoy

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sr0112.tictactoy.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

  open class MainActivity : AppCompatActivity() {

     private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
      //  setUpOnClick()

    }

    // private fun setUpOnClick() {}
     fun buClick(view: View) {
         val buSelected:Button = view as Button
         var cId = 0
         when (buSelected.id) {
             R.id.bu1 ->{
                 cId = 1}
             R.id.bu2 -> {
                 cId = 2
             }
             R.id.bu3 ->{
                 cId = 3}
             R.id.bu4 -> {
                 cId = 4
             }
             R.id.bu5 -> {
                 cId = 5
             }
             R.id.bu6 ->{
                 cId = 6
             }
             R.id.bu7 -> {
                 cId = 7
             }
             R.id.bu8 -> {
                 cId = 8
             }
             R.id.bu9 -> {
                 cId = 9
             }
         }
         //Toast.makeText(this, "ID:"+cId, Toast.LENGTH_LONG).show()
         Play(cId,buSelected)
     }
     var plr1= ArrayList<Int>()
     var plr2= ArrayList<Int>()
     var activePlr= 1
     fun Play(cId:Int,buSelected:Button){
         if (activePlr==1){
             buSelected.text="X"
             buSelected.setBackgroundColor(Color.BLUE)
             plr1.add(cId)
             activePlr=2
             AutoPlay()
         }else{
             buSelected.text="O"
             buSelected.setBackgroundColor(Color.GREEN)
             plr2.add(cId)
             activePlr=1
         }
         buSelected.isEnabled=false
         FindWiner()
     }
     fun FindWiner(){
         var winer=-1
         //row1
         if (plr1.contains(1) && plr1.contains(2) && plr1.contains(3)){
             winer=1
         }
         if (plr2.contains(1) && plr2.contains(2) && plr2.contains(3)){
             winer=2
         }
         //row2
         if (plr1.contains(4) && plr1.contains(5) && plr1.contains(6)){
             winer=1
         }
         if (plr2.contains(4) && plr2.contains(5) && plr2.contains(6)){
             winer=2
         }
         //row3
         if (plr1.contains(7) && plr1.contains(8) && plr1.contains(9)){
             winer=1
         }
         if (plr2.contains(7) && plr2.contains(8) && plr2.contains(9)){
             winer=2
         }
         //column1
         if (plr1.contains(1) && plr1.contains(4) && plr1.contains(7)){
             winer=1
         }
         if (plr2.contains(1) && plr2.contains(4) && plr2.contains(7)){
             winer=2
         }
         //column2
         if (plr1.contains(2) && plr1.contains(5) && plr1.contains(8)){
             winer=1
         }
         if (plr2.contains(2) && plr2.contains(5) && plr2.contains(8)){
             winer=2
         }
         //column3
         if (plr1.contains(3) && plr1.contains(6) && plr1.contains(9)){
             winer=1
         }
         if (plr2.contains(3) && plr2.contains(6) && plr2.contains(9)){
             winer=2
         }
         //cross1
         if (plr1.contains(1) && plr1.contains(5) && plr1.contains(9)){
             winer=1
         }
         if (plr2.contains(1) && plr2.contains(5) && plr2.contains(9)){
             winer=2
         }
         //cross2
         if (plr1.contains(7) && plr1.contains(5) && plr1.contains(3)){
             winer=1
         }
         if (plr2.contains(7) && plr2.contains(5) && plr2.contains(3)){
             winer=2
         }
         if (winer!=-1){
            if (winer==1){
                Toast.makeText(this, "Player1: winner!!", Toast.LENGTH_LONG).show()
            }
            else if(winer==2){
                Toast.makeText(this, "Computer: winner!!", Toast.LENGTH_LONG).show()
            }else if(winer==-1){
                Toast.makeText(this, "Match Drawn!!", Toast.LENGTH_LONG).show()
            }
         }

     }
     fun AutoPlay(){
         var emptyButs=ArrayList<Int>()
         for (cId in 1..9){
             if (!(plr1.contains(cId) || plr2.contains(cId))){
                 emptyButs.add(cId)
             }
         }
         val ran=Random()
         val ranIndex=ran.nextInt(emptyButs.size-0)+0
         val cId=emptyButs[ranIndex]
         var buSelect:Button?
          when(cId){
             1->buSelect=binding.bu1
             2->buSelect=binding.bu2
             3->buSelect=binding.bu3
             4->buSelect=binding.bu4
             5->buSelect=binding.bu5
             6->buSelect=binding.bu6
             7->buSelect=binding.bu7
             8->buSelect=binding.bu8
             9->buSelect=binding.bu9
             else ->{
                 buSelect=binding.bu1
             }
         }
         Play(cId,buSelect)
     }

 }