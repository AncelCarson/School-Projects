class Checking extends Account{ //sub class of Account

   Checking(){
   }

   boolean withdraw(float balance, float change){
      boolean result = true;
       balance = balance - change;
      return result;
   }

   void overdraw(float balance, float change){
      double serviceCharge = 35.0;
      double overAmt = change - balance;
      double oweAmt = overAmt + serviceCharge;

      if(change > balance){
         System.out.println("You have overdrawn your account and it is now locked. To unlock your account for further actions, you must deposit $" + (oweAmt) + ".");
      }
   }

   overdrawCheck(){
      
   }



}