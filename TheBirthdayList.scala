import scala.io.StdIn.readInt
import scala.io.StdIn.readLine
import scala.collection.mutable.ListBuffer

object TheBirthdayList {
  
   var name = new ListBuffer[String]()
   var month = new ListBuffer[String]()
   var day = new ListBuffer[Int]()
   
   var EntDay: Int = 0
   var EntName = "_"
   var EntMonth = "_"
   
   def PrintName (){
    println("All names within the list are as followed: " + name)
    println("All months within the list are as followed: " + month)
    println("All days within the list are as followed: " + day)
    println("All items combined are as followed: " + name, day, month)
  } 
  
  def Lookup(){
    println("In lookup you can search for data by an exact day.")
    println("Specify the day you wish to look up: ")
    var lookupDay = readInt()  //the day that the user wishes to find
    if (lookupDay > 0 && lookupDay < 32){
      if (day.contains(lookupDay)){
        var ind = day.indexOf(lookupDay)
        println(name(ind), day(ind), month (ind))
    }
      else { (println("No results found."))
    }
      }
      else {
        (println("Error! Please Try Again."))
      }
  }        
  def LookupRep(){
    Lookup
  }
  
  def DelName(){
    println("Specify whether you wish to remove a name, month or day: ")
    var choices = readLine()
    if (choices == "Name" || choices == "name" || choices == "NAME" || choices == "nAME"){
      println("Specify which name you wish to remove: ")
      var removeName = readLine()
      if (name.contains(removeName)){
      var ind2 = name.indexOf(removeName)
        name -= name(ind2); month -= month(ind2); day -= day(ind2)
        println(removeName + " successfuly removed, along with it's associated data.")
        //it deletes the first instance of names.
      }
           else { (println("No results found.")) 
      }
    }
    else if (choices == "Month" || choices == "MONTH" || choices == "month" || choices == "mONTH"){
      println("Specify which month you wish to remove: ")
      var removeMonth = readLine()
      if (name.contains(removeMonth)){
      var ind4 = month.indexOf(removeMonth)
        month -= month(ind4); name -= name(ind4); day -= day(ind4)
        println(removeMonth + " successfuly removed, along with it's associated data.")
        //it deletes the first instance of names.
      }
           else { (println("No results found."))  
      }
    }
    else if (choices == "Day" || choices == "DAY" || choices == "day" || choices == "dAY"){
      println("Specify which day you wish to remove: ")
      var removeDay = readInt()
      if (name.contains(removeDay)){
      var ind3 = day.indexOf(removeDay)
        day -= day(ind3); month -= month(ind3); name -= name(ind3)
        println("Day " + removeDay + " successfuly removed, along with it's associated data.")
      }
       else { (println("No results found.")) 
      }
    }
    else {
      println("Error! Please Try Again.")
    }            
   }
  
  def DelRep(){
    DelName
  }
  
  def Restart(){
    println("Welcome. Specify the action you wish to perform: add, remove or lookup data.")
    println("Type 'End' to exit the program.")
  }
  
  def AddDetails(){
    name += EntName
    month += EntMonth
    day += EntDay
    println("Data has been added successfully.")
  }
  
  def AddFailure(){
    println("Error! Please Try Again.")
  }
  
  def CheckAdd(){        
   if (EntName.nonEmpty && EntMonth.nonEmpty){
     EntDay match {
     case it if 1 until 32 contains it => AddDetails() 
     case whoa => AddFailure; println("Unexpected input " + whoa.toString)
    }
   }
   else (AddFailure())
  }
  
  def AddName(){
    println("You will now be able to enter data for a name, month and address. Please follow the onscreen commands.")
    println("Specify which name you wish to add: ")
    EntName = readLine()
    println("Specify which month you wish to add: ")    
    EntMonth = readLine()
    println("Specify which day you wish to add: ")
    EntDay = readInt()
    CheckAdd()
 }  
  
  def AddRep(){
    AddName
  }  
  
  def main(args: Array[String]): Unit = {
  
    println("Welcome. Specify the action you wish to perform: add, remove or lookup data.")
    println("Type 'End' to exit the program.")
    
    var selection = " "

    do {
          selection = readLine()
      
    if (selection == "add" || selection == "Add" || selection == "ADD" || selection == "aDD"){
      AddName()
    println("Add More, Yes or No?")
    var options = readLine()
    while (options == "Y" || options == "y" || options == "yes" || options == "Yes" || options == "YES" || options == "yES"){
      AddRep
      println("Add More, Yes or No?")
      options = readLine()
      }
    if (options == "N" || options == "n" || options == "no" || options == "No" || options == "NO" || options == "nO"){
    PrintName() 
    Restart()
    }
    }
    else if (selection == "remove" || selection == "Remove" || selection == "REMOVE" || selection == "rEMOVE"){
    DelName()
    println("Remove More, Yes or No?")
    var options2 = readLine()
    while (options2 == "Y" || options2 == "y" || options2 == "yes" || options2 == "Yes" || options2 == "YES" || options2 == "yES"){
      DelRep
      println("Remove More, Yes or No?")
      options2 = readLine()
      }
    if (options2 == "N" || options2 == "n" || options2 == "no" || options2 == "No" || options2 == "NO" || options2 == "nO"){
    PrintName() 
    Restart()
    }
    }
          
    else if (selection == "lookup" || selection == "Lookup" || selection == "LOOKUP" || selection == "lOOKUP"){
    Lookup()
    println("Lookup More, Yes or No?")
    var options3 = readLine()
    while (options3 == "Y" || options3 == "y" || options3 == "yes" || options3 == "Yes" || options3 == "YES" || options3 == "yES"){
      Lookup
      println("Lookup More, Yes or No?")
      options3 = readLine()
    }
    if (options3 == "N" || options3 == "n" || options3 == "no" || options3 == "No" || options3 == "NO" || options3 == "nO"){
      PrintName()
      Restart()
    }
      }
    } 
    
    while (selection != "End")
    println("Exiting program...")
  }   
}