import java.nio.charset.*;
import java.util.Random;
import java.io.*;
import java.*;

class MyIO {

   private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in, Charset.forName("ISO-8859-1")));

   public static void print(){
   }

   public static void print(int x){
      System.out.print(x);
   }

   public static void print(double x){
      System.out.print(x);
   }

   public static void print(String x){
      System.out.print(x);
   }

   public static void print(boolean x){
      System.out.print(x);
   }

   public static void println(){
   }

   public static void println(int x){
      System.out.println(x);
   }

   public static void println(double x){
      System.out.println(x);
   }

   public static void println(String x){
      System.out.println(x);
   }

   public static void println(boolean x){
      System.out.println(x);
   }

   public static double readDouble(){
      double d = -1;
      try{
         d = Double.parseDouble(readString().trim());
      }catch(Exception e){}
      return d;
   }

   public static double readDouble(String str){
      System.out.print(str);
      return readDouble();
   }

   public static float readFloat(){
      return (float) readDouble();
   }

   public static float readFloat(String str){
      return (float) readDouble(str);
   }

   public static int readInt(){
      int i = -1;
      try{
         i = Integer.parseInt(readString().trim());
      }catch(Exception e){}
      return i;
   }

   public static int readInt(String str){
      System.out.print(str);
      return readInt();
   }

   public static String readString(){
      String s = "";
      char tmp;
      try{
         do{
            tmp = (char)in.read();
            if(tmp != '\n' && tmp != ' ' && tmp != 13){
               s += tmp;
            }
         }while(tmp != '\n' && tmp != ' ');
      }catch(IOException ioe){
         System.out.println("lerPalavra: " + ioe.getMessage());
      }
      return s;
   }

   public static String readString(String str){
      System.out.print(str);
      return readString();
   }

   public static String readLine(){
      String s = "";
      char tmp;
      try{
         do{
            tmp = (char)in.read();
            if(tmp != '\n' && tmp != 13){
               s += tmp;
            }
         }while(tmp != '\n');
      }catch(IOException ioe){
         System.out.println(" lerPalavra:: " + ioe.getMessage());
      }
      return s;
   }

   public static String readLine(String str){
      System.out.print(str);
      return readLine();
   }

   public static char readChar(){
      char resp = ' ';
      try{
         resp = readString().charAt(0);
      }catch(Exception e){}
      return resp;
   }

   public static char readChar(String str){
      System.out.print(str);
      return readChar();
   }

   public static boolean readBoolean(){
      boolean resp = false;
      String str = "";

      try{
         str = readString();
      }catch(Exception e){}

      if(str.equals("true") || str.equals("TRUE") || str.equals("t") || str.equals("1") || 
         str.equals("verdadeiro") || str.equals("VERDADEIRO") || str.equals("V")){
         resp = true;
      }

      return resp;
   }

   public static boolean readBoolean(String str){
      System.out.print(str);
      return readBoolean();
   }

   public static void pause(){
      try{
         in.read();
      }catch(Exception e){}
   }

   public static void pause(String str){
      System.out.print(str);
      pause();
   }
}

class Metodo{

//----------------------------------------------------------------------------------
	public static void Palindromo(String palavra){ 
		
		String nova ="";
            
		for(int i = palavra.length()-1; i >=0; i--){

			nova+= palavra.charAt(i);
		}  
			if(nova.equals(palavra)){
				System.out.println("SIM");	
			}
			else{
				System.out.println("NAO");
			}					
	}

//----------------------------------------------------------------------------------
	public static void Concatena(String s1 , String s2){

		for(int i =0;i< s2.length();i++){
			s1+= s2.charAt(i);
		}
		System.out.println(s1);  
	}

//----------------------------------------------------------------------------------
	public static void Replace(String s, char atual , char novo ){

		String result ="";

		for(int i = 0 ; i < s.length(); i++){
			
			if(s.charAt(i) == atual){
			
				result = result + novo;
			}	
			else{		
				result = result + s.charAt(i);

			}
		}
		System.out.println(result);
	}
//----------------------------------------------------------------------------------


	public static void ReplaceAleatorio(String s, char atual , char novo ){

		String result ="";

		for(int i = 0 ; i < s.length(); i++){
			
			if(s.charAt(i) == atual){
			
				result = result + novo;
			}	
			else{		
				result = result + s.charAt(i);

			}
		}
		System.out.println(result);
	}

//----------------------------------------------------------------------------------
	

   
   	public static int CompareTo(String s1, String s2){
        
	int cs1 = 0, cs2 = 0;

      	if( cs1< s1.length() && cs1 < s2.length()){
			System.out.println("a");
        	if( s1.charAt(cs1) != s2.charAt(cs1)){ //diferentes
                         System.out.println("ab");
      			if( s1.charAt(cs1) < s2.charAt(cs1)){ //primeira menor
      
        			cs2 = -1; // condição

      			}
      			
			else if( s2.charAt(cs1) < s1.charAt(cs1)){ //segunda menor
      
        			cs2 = 1; // s.condição
      			}
      		}//se diferentes
 
      		 else if( s1.charAt(cs1) == s2.charAt(cs1)){

			cs1++;
				
       		}
       }
      
      	return cs2;
       }  
       


//----------------------------------------------------------------------------------
  
       public static int CompareToIgnoreCase(String s1, String s2){
   
   	 int cs1 = 0, cs2 = 0; // incio variaveis
    	 String a = toUpper(s1);//condicao1
    	 String b = toUpper(s2);//condicao2
    	 
	 cs2 = -3;
    	 cs2 = CompareTo(a,b);
    	 return cs2;
  	}

	public static String toUpper( String s ){ 
     
	int x = 0, y = 0;
     	return toUpper(s, x, y);
   
	}
  	
        public static String toUpper( String s, int x, int y ){
     
	 String nova = "";  
      
     	if(x < s.length()){

      		if( s.charAt(x) >= 'a' && s.charAt(x) <= 'z' || s.charAt(x) >= 224 && s.charAt(x) <= 255){
     	//pegando o codigo ASCII da string e subtraindo para encontrar seu                                 		valor correspondente ao caractere maiusculo e concaternando apos o mesmo
       
			y = s.charAt(x)-32;
       			nova = nova + (char)y;     
      		}
      	
		else{//concatenando na nova string do caractere
        
			 nova = nova + s.charAt(x);
       		}

      			 nova = nova + toUpper(s,x=x+1,y);
    	 }
     
       return nova;
     }
//----------------------------------------------------------------------------------

	
	public static int contarCaractere(String s, char c){

	int x = 0;
	for(int i = 0; i < s.length(); i++){
	
		if(s.charAt(i) == c){

			x++;
		}
	}			
	
	return x;	

	}

//----------------------------------------------------------------------------------


	public static int contarLetra(String s){

	int x = 0;
	for(int i = 0; i < s.length(); i++){
		
		if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'|| s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){

			x++;
		}
	}	

	return x;
	}

//----------------------------------------------------------------------------------


	public static int contarNaoLetra(String s){

	int x = 0;
	for(int i = 0; i < s.length(); i++){
		
		if(!(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'|| s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')){

			x++;
		}
	}	

	return x;
	}	


//----------------------------------------------------------------------------------


   public static int contarDoidao(String s){  
     
     int resp = 0; 

     for(int cont = 0; cont < s.length(); cont++){
      
	   
    if(isConsoante(s.charAt(cont))== true ){
        resp = ((int)s.charAt(cont) %  5 == 0 && (int)s.charAt(cont) % 2 != 0 ? resp: resp+1);
	}      
	
        if( isVogal(s.charAt(cont)) == true ){ 
        resp =  (((int)s.charAt(cont)) % 5 != 0 && ((int)s.charAt(cont)) % 8 != 0 ? resp+1: resp);

        }
     }
      return resp;
   }


 	public static boolean isVogal(char c){
    
       	   boolean resp = false;
    
	   int w = (int)c;
    	   if( !(c>='0'&& c<= '9' ) || c == 'a'|| c == 'A'|| c == 'e'|| c == 'E'|| c == 'i'|| c == 'I'||
                 c == 'o'|| c == 'O'|| c == 'u'|| c =='U'|| w >= 128 && w<= 223 ){
      
		resp = true;
	   }

        return resp;
       }

      
	public static boolean isConsoante(char c){
    
	    boolean resp = false;

	    int w = (int)c;

	    if( !(c>='0'&& c<= '9' ) || c != 'a'|| c != 'A'|| c != 'e'|| c != 'E'|| c != 'i'|| c != 'I'||
            c != 'o'|| c != 'O'|| c != 'u'|| c !='U' ||  ! ( w >= 1 && w <= 64) || (w >= 128 && w <= 217)){
      		
	    resp = true;
        }

            return resp;
        }
//----------------------------------------------------------------------------------

 public static boolean isVogal( String s)
   {
     boolean resp = false;
     int y = 0;
     for( int x = 0; x < s.length(); x++){
     
     //testar se posicao da string e uma vogal
     	if( s.charAt(x) == 'a'|| s.charAt(x) == 'A'|| s.charAt(x) == 'e'||
         s.charAt(x) == 'E'|| s.charAt(x) == 'i'|| s.charAt(x) == 'I'|| 
         s.charAt(x) == 'o'|| s.charAt(x) == 'O'|| s.charAt(x) == 'u'|| 
         s.charAt(x) =='U'){
      	 y++;
    	 }
    }
    if( y == s.length() ){
    
     resp = true;
    }

    return resp;
   }


//----------------------------------------------------------------------------------
        

  public static boolean isConsoante( String s){
     
   boolean resp = false; int w,y = 0;
   
     for( int x = 0; x < s.length(); x++){
     
    w = s.charAt(x);// armazenando em w para faciltar 
    
    //caso a string contenha uma vogal incrementar + 1
     if(!( s.charAt(x) == 'a'|| s.charAt(x) == 'A'|| s.charAt(x) == 'e'||
         s.charAt(x) == 'E'|| s.charAt(x) == 'i'|| s.charAt(x) == 'I'||
         s.charAt(x) == 'o'|| s.charAt(x) == 'O'|| s.charAt(x) == 'u'||
         s.charAt(x) =='U' || w <= 222 && w >= 129 || s.charAt(x) >= '0' && s.charAt(x) <= '9')){
       y++;
     
      }
     }
    if( y == s.length() )
    {
     resp = true;
    }

    return resp;
   }

//----------------------------------------------------------------------------------
  
  
   public static boolean isInteiro( String s){
     
    boolean resp = false; int y = 0;
    
     for( int x = 0; x < s.length(); x++){
     
  
      if( s.charAt(x) >= '0' && s.charAt(x) <= '9' ){
        y++;
       }
     }

     if( y == s.length() ){
     
      resp = true;
      }
      return resp;
   }
//----------------------------------------------------------------------------------
     

   public static boolean isReal( String s){
        
     boolean resp = true; int j = 0;

     for( int cont = 0; cont < s.length(); cont++){
      
      if(s.charAt(cont) < 0 ||  s.charAt(cont) >= '0'  && s.charAt(cont) <= '9'|| s.charAt(cont) == '.'&&
     s.charAt(cont) == ','){
    
        j++; 
      }
      
     }

      if ( j< s.length()-1  ){
       resp = false;
      }

      return resp;
   }
//----------------------------------------------------------------------------------

  	
	 public static String ToUpper( String s){
     
	 String nova = ""; int y =0;
      
     	for( int x = 0; x < s.length(); x++){

      		if( s.charAt(x) >= 'a' && s.charAt(x) <= 'z' || s.charAt(x) >= 224 && s.charAt(x) <= 255){
       
			y = s.charAt(x)-32;
       			nova = nova + (char)y;     
      		}
      	
		else{
        
			 nova = nova + s.charAt(x);
       		}

      			
    	 }
     
       return nova;
     }
//---------------------------------------------------------------------------------


   	public static String ToLower( String s){ 
     
	String nova = ""; int y =0;
    
     	for( int x = 0; x < s.length(); x++){
     		
      		if( s.charAt(x) >= 'A' && s.charAt(x) <= 'Z'|| s.charAt(x) >= 192 && s.charAt(x) <= 221 ){//
      
   
      			 y = s.charAt(x)+32;
     			 nova = nova + (char)y;
     		 }
      			else{
  
         			nova = nova + s.charAt(x);
       			}
        }
     
     return nova;
   }
	
//----------------------------------------------------------------------------------

   public static String trim ( String s){
     
     String nova = "";
     int cont = 0;
     while( cont < s.length()){
      
	if( s.charAt(cont) != ' ' ){
       
        nova = nova + s.charAt(cont);
        cont++;
        }         
      else{
 	cont++;    
      }
     }
     return nova;
   }
 
//----------------------------------------------------------------------------------

   public static String trim(String s, char c){
     
	String nova = "";
    	int cont = 0;

	while(cont <s.length()){
        	
		 if(s.charAt(cont) != c){

		 	nova = nova + s.charAt(cont);
        	 	cont++;
        	
       		 }

		 else{
			cont++;
       
         	}
        }
    
	return nova;
   }	

//=========================================================================================================//

}
class TP1{
	

	public static void testePalindromo(String [] entrada, int numEntrada){
		
		for(int i = 0; i <numEntrada; i++){	
			Metodo.Palindromo(entrada[i]);
		}
	}

	public static void testeConcatena(String [] entrada, int numEntrada){
		for(int i = 0; i<numEntrada -1; i+=2){
			Metodo.Concatena(entrada[i],entrada[i+1]);
		}
		if(numEntrada % 2 == 1){
			Metodo.Concatena(entrada[numEntrada -1],entrada[numEntrada -1]);
		}
	}


	public static void testeReplace(String [] entrada,int numEntrada){

		for(int i =0; i< numEntrada; i++){
			Metodo.Replace(entrada[i],entrada[i].charAt(0),                                          entrada[i].charAt(entrada[i].length()-1));
		}
	}

	public static void testeReplaceAleatorio(String [] entrada, int numEntrada){
	
	Random gerador = new Random();
	gerador.setSeed(4);
	char teste;
 	 
	for(int i = 0; i < numEntrada; i++){

         teste = ((char)('A' + (Math.abs(gerador.nextInt()) % 26)));

         Metodo.ReplaceAleatorio(entrada[i], entrada[i].charAt(0), teste);
      	}	
	}

	public static void testeCompareTo(String[] entrada, int numEntrada){
      

		for(int i = 0; i < numEntrada - 1; i+=2){
         		System.out.println(Metodo.CompareTo(entrada[i],
         		entrada[i+1]) + " " + Metodo.CompareToIgnoreCase(entrada[i],entrada[i+1])); 
      		}

      		if(numEntrada % 2 == 1){
         		System.out.println(Metodo.CompareTo(entrada[numEntrada-1],
         		entrada[numEntrada-1]) + " "+ Metodo.CompareToIgnoreCase(entrada  			                     [numEntrada-1],entrada[numEntrada-1])); 
      		}
   	}

	public static void testeContar(String[] entrada, int numEntrada){

		for(int i = 0; i < numEntrada; i++){

                	System.out.println(Metodo.contarCaractere(entrada[i],entrada[i].charAt(0)) +                                              " " + Metodo.contarLetra(entrada[i])                         +                                              " " + Metodo.contarNaoLetra(entrada[i])                      +                                              " " + Metodo.contarDoidao(entrada[i]));                     
      }
   }

	public static void testeIs(String[] entrada, int numEntrada){

		for(int i = 0; i < numEntrada; i++){

                	System.out.println(Metodo.isVogal(entrada[i]) +                                              " " + Metodo.isConsoante(entrada[i])                         +                                              " " + Metodo.isInteiro(entrada[i])                      +                                              " " + Metodo.isReal(entrada[i]));  
		}
	}

	public static void testeConversao(String[] entrada, int numEntrada){

		for(int i = 0; i < numEntrada; i++){

                	System.out.println(Metodo.ToUpper(entrada[i]));
 			System.out.println(Metodo.ToLower(entrada[i]));        
                        System.out.println(Metodo.trim(entrada[i]));
                        System.out.println(Metodo.trim(entrada[i],entrada[i].charAt(0)));  
		}
	}



	public static void main (String [] args){

		Metodo plv = new Metodo();

		String[] entrada = new String[1000];
		String linha;
		int numEntrada = 0;

		do{		
			entrada[numEntrada] = MyIO.readLine();
		}
		while(entrada[numEntrada++].equals("FIM") == false);

                	numEntrada--; //Desconsiderar ultima linha 
	
	  	//testePalindromo(entrada,numEntrada);
		//testeConcatena(entrada, numEntrada);
                //testeReplace(entrada,numEntrada);
		//testeReplaceAleatorio(entrada,numEntrada);
 	        //testeCompareTo(entrada, numEntrada);// b
		//testeContar(entrada, numEntrada);// d
		//testeIs(entrada,numEntrada);
                testeConversao(entrada,numEntrada); 
	}

}
