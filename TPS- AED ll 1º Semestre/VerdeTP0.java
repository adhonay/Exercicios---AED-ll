import java.nio.charset.*;
import java.util.Random;
import java.io.*;
import java.*;

class Palavra{



//=========================================================================================================// 

	// funcao que retorna true caso seja palindroma ou false casjo nao seja contendo 				ambos metodas chamando a si mesmo sendo o segundo contendo o caso de parada.
   public static boolean isPalindromo(String s){
   
      int x = 0;
      int y = s.length() -1;
      return isPalindromo(s,x,y);
   
   }
	
   public static boolean isPalindromo(String s, int x, int y){
   
      char px = s.charAt(x);
      char py = s.charAt(y);
      boolean resp = false;     
   
      if(x < s.length()/2){
                  
         if(px == py){
            y--; 
            x++;
            resp = isPalindromo(s,x,y);
         } 
      
      }
   	
      if(x == s.length()/2){
      
         resp = true;
              
      }
                
      return resp;
                        
   }
	




//=========================================================================================================//




	// funçao que soma o primeiro char da segunda palavra com o ultimo da primeira 
        // enquanto o contador nao chega no seu limite no caso o ultimo char da segunda palavra
   public static String concatena(String s1, String s2){
         
      int contador = 0;
      String s = concatena(s1,s2,contador);
      return s;
   }
   public static String concatena(String s1, String s2, int contador){
   
      if(contador <= s2.length()){
         s1 = s1 + s2.charAt(contador);
      }	
      contador++;
   
      if(contador < s2.length()){
         s1 = concatena(s1,s2,contador);
      }
      return s1;
   }



//=========================================================================================================//





	//funçao usado paara substituir um char por outro , usando a concordancia 
	//se existe o atual ou nao caso exista nao faça a atribuicçao do novo char 
   public static String replace(String s, char atual, char novo){
   
      int cont = 0;
      String result = "";
      return replace(s,atual,novo,result,cont);
   
   }
	
   public static String replace(String s, char atual, char novo ,String result, int cont){	
   
   
      if( cont < s.length()){
      
         if(s.charAt(cont) == atual){
         
            result = result + novo;
         }	
         else{		
            result = result + s.charAt(cont);
         
         }	
      
         result = replace(s,atual,novo,result,cont = cont+1);
      }
   
      return result;
   }




//=========================================================================================================//





	//funçao que altera numa determinada posicao caso exista por uma letra maiuscula aleatoria

   public static String replaceAleatorio(String s , char c){
   
      int cont = 0;
      return replaceAleatorio(s,c,cont);
   
   }
	
   public static String replaceAleatorio(String s , char c, int cont ){
        
      int aleatorio = 0;
      String novo = "";
   
      Random gerador = new Random();
      gerador.setSeed(4);
   
      if( cont < s.length()){
      
         if( s.charAt(cont) == c){
         			
         // alet recebe um condigo aleatorio equivalente as maiuscula
         
            aleatorio = (65 + (Math.abs(gerador.nextInt()) % 26 ));
         
                	// concatena na nova string
         
            novo = novo + (char)aleatorio;	
         }
         
         else{
         
         // nao tiver alteraçao concatena normalmente
            novo = novo + s.charAt(cont);
         }
      
         novo = novo + replaceAleatorio(s,c,cont = cont + 1);
      }
   
   
      return novo;
   }



//=========================================================================================================//




	 //funçao recursiva que recebe duas strings por parametro
   	 //e compara ambas retornando valores distintos atrazes de determinados valores
   public static int compareTo( String s1, String s2){
   
      int cs1 = 0, cs2 = 0;
      return compareTo(s1, s2, cs1, cs2 ) ;
   	
   }

    	//funcao do tipo inteira que recebe duas strings e dois contadores para determinadas posiçoes	
   
   public static int compareTo(String s1, String s2, int cs1, int cs2){
      
      if( cs1< s1.length() && cs1 < s2.length()){
      
         if( s1.charAt(cs1) != s2.charAt(cs1)){ //diferentes
         
            if( s1.charAt(cs1) < s2.charAt(cs1)){ //primeira menor
            
               cs2 = -1; // condição
            }
            	
            else if( s2.charAt(cs1) < s1.charAt(cs1)){ //segunda menor
            
               cs2 = 1; // s.condição
            }
         }//se diferentes
         
         else if( s1.charAt(cs1) == s2.charAt(cs1)){
         
            cs2 = compareTo( s1, s2, cs1 = cs1 + 1, cs2 );
         }
      }
      
      return cs2;
   }  
       


//=========================================================================================================//



       // agora ignorando as letras maiuscuas e minusculas para 
       //isso usando toupper(aproveitando outra funçao)
   public static int compareToIgnoreCase(String s1, String s2){
   
      int cs1 = 0, cs2 = 0; // incio variaveis
      String a = toUpper(s1);//condicao1
      String b = toUpper(s2);//condicao2
    	 
      cs2 = -3;
      cs2 = compareTo(a,b);
      return cs2;
   }
	
//=========================================================================================================//

       
	//funcao para contar quantos caracteres um determinado caracter existe na string 
	// bastando comparar o caractere com ou de cada posicao da string

   public static int contarCaractere( String s , char c){
   
      int cont = 0, x = 0;
      return	contarCaractere(s,c,cont,x);
   
   }
	
   public static int contarCaractere(String s, char c , int cont, int x){
   
      if(cont < s.length()){
      
         if(s.charAt(cont) == c){
         
            x++;
         }			
      
         x = contarCaractere(s,c,cont = cont + 1, x);
      }
      return x;	
   
   }

//=========================================================================================================//



	// funcao para contar quantas letras existe na string 
	// bastando apenas comprar com o intervalo 'a'/'z' e 'A'/'Z'
   public static int contarLetra(String s){
   
      int contador = 0, posicao = 0;
      return contarLetra(s,contador,posicao);
   
   }

   public static int contarLetra(String s, int contador,int posicao){
   
      if( posicao  < s.length()){
      
         if(s.charAt(posicao) >= 'a' && s.charAt(posicao) <= 'z'||                          s.charAt(posicao) >= 'A' && s.charAt(posicao) <= 'Z'){
         
            contador++;
         }	
         contador = contarLetra(s,contador, posicao = posicao +1);
      
      }	
   
      return contador;
   }

//=========================================================================================================//


	// funcao para contar quais caracters diferem de letras
	// bastando apenas comparar os diferentes d intervalo 'a'/'z' e 'A'/'Z'
   public static int contarNaoLetra(String s){
   
      int contador = 0, posicao = 0;
      return contarNaoLetra(s,contador,posicao);
   
   }

   public static int contarNaoLetra(String s, int contador,int posicao){
   
      if( posicao  < s.length()){
      
         if(!(s.charAt(posicao) >= 'a' && s.charAt(posicao) <= 'z'||                          s.charAt(posicao) >= 'A' && s.charAt(posicao) <= 'Z')){
         
            contador++;
         }	
         contador = contarNaoLetra(s,contador, posicao = posicao +1);
      
      }	
   
      return contador;
   }


//=========================================================================================================//


  //funcao que recebe uma string como parametro e retorna de acordo com a condicao passada

   public static int contarDoidao(String s){
      int cont = 0;
      return contarDoidao(s,cont);
   }


  //recebe uma string e contador por parametro

   public static int contarDoidao(String s, int cont){  
     
      int resp = 0; 
   
      if( cont < s.length()){ 
      
      //testeando se caractere se enquandra nos termos do contarDoidao
      // antes da "?" e feita uma pergunta caso verdadeiro faz resp  
      // caso for falso faz resp +1 , e como se o ":" fose um else e "?" o if    
      
         if(isConsoante(s.charAt(cont))== true ){
            resp = ((int)s.charAt(cont) %  5 == 0 && (int)s.charAt(cont) % 2 != 0 ? resp: resp+1);
         }      
      
         if( isVogal(s.charAt(cont)) == true ){ 
            resp =  (((int)s.charAt(cont)) % 5 != 0 && ((int)s.charAt(cont)) % 8 != 0 ? resp+1: resp);
         
         }
      
         resp = resp +contarDoidao(s,cont= cont+1);
      } 
      
      return resp;
   }


      // para testar caso for vogal
	// fazendo varios testes de comparçoes e igualdades

   public static boolean isVogal(char c){
    
      boolean resp = false;
    
      int w = (int)c;
      if( !(c>='0'&& c<= '9' ) || c == 'a'|| c == 'A'|| c == 'e'|| c == 'E'|| c == 'i'|| c == 'I'||
                 c == 'o'|| c == 'O'|| c == 'u'|| c =='U'|| w >= 128 && w<= 223 ){
      
         resp = true;
      }
   
      return resp;
   }

      
	// para testar caso for consoante
	// fazendo varios testes de comparaçoes 
   public static boolean isConsoante(char c){
    
      boolean resp = false;
   
      int w = (int)c;
   
      if( !(c>='0'&& c<= '9' ) || c != 'a'|| c != 'A'|| c != 'e'|| c != 'E'|| c != 'i'|| c != 'I'||
            c != 'o'|| c != 'O'|| c != 'u'|| c !='U' ||  ! ( w >= 1 && w <= 64) || (w >= 128 && w <= 217)){
      		
         resp = true;
      }
   
      return resp;
   }
//=========================================================================================================//
        
   public static boolean isVogal(String s){
    
      int x = 0, y = 0;
      return isVogal(s, x, y);
   }

   //funcao recursivda do tipo boolean que recebe uma string e duas variaveis inteiras por parametro e retorna true caso a string seja feita por vogais
  
   public static boolean isVogal( String s, int x, int y )
   {
      boolean resp = false;
   
      if( x < s.length() )
      {
      //testar se posicao da string e uma vogal
         if( s.charAt(x) == 'a'|| s.charAt(x) == 'A'|| s.charAt(x) == 'e'||
         s.charAt(x) == 'E'|| s.charAt(x) == 'i'|| s.charAt(x) == 'I'|| 
         s.charAt(x) == 'o'|| s.charAt(x) == 'O'|| s.charAt(x) == 'u'|| 
         s.charAt(x) =='U'){
            y++;
         
         }
         resp = isVogal(s,x=x+1,y);
      }
      if( y == s.length() )
      {
         resp = true;
      }
      return resp;
   }


//=========================================================================================================//
        
   public static boolean isConsoante(String s)
   {
      int x = 0, y = 0;
      return isConsoante(s, x, y);
   }
  //funcao recursiva booleana que recebe uma string e dois inteirose testa todas as posicoes da string retornando true caso ela seja feita de apenas consoantes
  
   public static boolean isConsoante( String s, int x, int y ){
     
      boolean resp = false; int w = 0;
   
      if( x < s.length() ){
      
         w = s.charAt(x);// armazenando em w para faciltar 
      
      //caso a string contenha uma vogal incrementar + 1
         if(!( s.charAt(x) == 'a'|| s.charAt(x) == 'A'|| s.charAt(x) == 'e'||
         s.charAt(x) == 'E'|| s.charAt(x) == 'i'|| s.charAt(x) == 'I'||
         s.charAt(x) == 'o'|| s.charAt(x) == 'O'|| s.charAt(x) == 'u'||
         s.charAt(x) =='U' || w <= 222 && w >= 129 || s.charAt(x) >= '0' && s.charAt(x) <= '9')){
            y++;
         
         }
      
      
         resp = isConsoante(s,x=x+1,y);
      }
    //teste para verificar se o contador foi incrementado
    //se sim, a string contem vogais
      if( y == s.length() )
      {
         resp = true;
      }
   
      return resp;
   }

//=========================================================================================================//
        
        // para testar caso for inteiro
	// fazendo varios testes e comparaçoes 
   
   public static boolean isInteiro(String s)
   {
      int x = 0;
      int y = 0;
      return isInteiro(s, x, y);
   }
  
   //caso inteiros retorna true (sim)
   public static boolean isInteiro( String s, int x, int y ){
     
      boolean resp = false;
     //teste para evitar testes
     //desnecessarios
      if( x < s.length() )
      {
      //testando se alguma posicao da string e um inteiro
         if( s.charAt(x) >= '0' && s.charAt(x) <= '9' )
         {
            y++;
         }
      //chamada recursiva guardando os valores de resp
         resp = isInteiro(s,x = x+1, y);
      }
     //teste final para ver se o contador foi incrementando em todas as posicoes
    
      if( y == s.length() )
      {
         resp = true;
      }
      return resp;
   }
//=========================================================================================================//
     
   // para testar caso for real
   // fazendo varios testes de comparaçoes 
   public static boolean isReal(String s){ 
     
      int x = 0; int y=0;
      boolean resp = true;
   
      int guarda = isReal(s, x, y);
   
      if ( guarda < s.length()-1  ){
         resp = false;
      }
      return resp;
   }
   //funcao recursiva booleana que recebe uma string e dois contadores por parametro

   public static int isReal( String s, int cont, int resp ){
        
      int j =0;
      if( cont < s.length() ){
      
      //verificar se a string contem apenas numeros reais
         if(s.charAt(cont) < 0 ||  s.charAt(cont) >= '0'  && s.charAt(cont) <= '9'|| s.charAt(cont) == '.'&&
         s.charAt(cont) == ','){
         
            resp = resp + 1;
         //chamada recursiva incremetando o segundo contador
         }
         cont++;
         resp = isReal(s, cont, resp); 
      }
       //se o contador incrementar em todas as posicoes, return true
     
      return resp;
   }
//=========================================================================================================//
        
       //funcao recursiva que testa cada posicao da string, alterando 
  	//caracteres minusculos por caracteres maiusculos e retornando a string nova

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
//=========================================================================================================//

   //funcao recursiva que alterando toda a ocorrencia
   //de caracteres minusculos por maiusculos retornando uma nova string


   public static String toLower( String s ){
   	
      int x = 0, y = 0; 
      return toLower(s, x, y);
   }


   public static String toLower( String s, int x, int y ){ 
     
      String nova = "";
    
      if(x < s.length()){ //teste de parada 
      
      	
         if( s.charAt(x) >= 'A' && s.charAt(x) <= 'Z'|| s.charAt(x) >= 192 && s.charAt(x) <= 221 ){//verificando se ha caractere maiusculos
         
         
            y = s.charAt(x)+32;
            nova = nova + (char)y;//concatenando o em uma nova string o caractere
         }
         else{
         
            nova = nova + s.charAt(x);
         }
      //chamada recursiva incrementando o contador x e guardando os valores na nova string a
         nova = nova + toLower(s,x=x+1,y);
      }
     
      return nova;
   }
	
//=========================================================================================================//

   // funcao que testa caso haver espaco na string retirar o mesmo
   public static String trim ( String s )
   {
      int cont = 0;
      String nova = "";
      return trim(s, nova, cont);
    
   }
   public static String trim ( String s, String nova, int cont ){
     // caso base
      if( cont < s.length() ){
        // caso houver espaco
         if( s.charAt(cont) != ' ' ){
         // copia a nova string sem o espaço quando houver
            nova = nova + s.charAt(cont);
            cont++;
            nova = trim( s, nova, cont );
         }         
         else{
         // mantem quando nao houver
            nova = trim( s, nova, cont=cont+1);
         
         }
      }
      return(nova);
   }
 
//=========================================================================================================//

 // funcao que testa caso haver espaco na string retirar o mesmo
   public static String trim(String s, char c){
   
      int cont = 0;
      String nova = "";
      return trim(s, c, cont, nova);
        
   }

   public static String trim(String s, char c, int cont, String nova){
        // caso base
      if(cont <s.length()){
        	// caso for diferente do primeiro caractere 
         if(s.charAt(cont) != c){
         		
         	// copia a string toda sem ele e retorna uma nova
            nova = nova + s.charAt(cont);
            cont++;
            nova = trim(s, c, cont, nova);
         }
         
         else{
         // caso nao for continue caractere normal
            nova = trim(s, c, cont=cont+1, nova);
         
         }
      }
    
      return nova;
   }	 	  	  

}
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
      }
      catch(Exception e){}
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
      }
      catch(Exception e){}
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
      }
      catch(IOException ioe){
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
      }
      catch(IOException ioe){
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
      }
      catch(Exception e){}
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
      }
      catch(Exception e){}
   
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
      }
      catch(Exception e){}
   }

   public static void pause(String str){
      System.out.print(str);
      pause();
   }
}

class VerdeTP0{

   public static void testePalindromo(String [] entrada, int numEntrada){
   	
      for(int i = 0; i <numEntrada; i++){	
         if(Palavra.isPalindromo(entrada[i]) == true){	
            System.out.println("SIM");
         }
         else{
            System.out.println("NAO");
         }
      }
   }

   public static void testeConcatena(String [] entrada, int numEntrada){
      for(int i = 0; i<numEntrada -1; i+=2){
         System.out.println(Palavra.concatena(entrada[i],entrada[i+1]));
      }
      if(numEntrada % 2 == 1){
         System.out.println(Palavra.concatena(entrada[numEntrada -1],entrada[numEntrada -1]));
      }
   }
	
   public static void testeReplace(String [] entrada,int numEntrada){
   
      for(int i =0; i< numEntrada; i++){
         System.out.println(Palavra.replace(entrada[i],entrada[i].charAt(0),                                          entrada[i].charAt(entrada[i].length()-1)));
      }
   }

   public static void testeReplaceAleatorio(String [] entrada, int numEntrada){
   
   
      for(int i =0 ; i< numEntrada; i++){
         System.out.println(Palavra.replaceAleatorio(entrada[i],                                                       entrada[i].charAt(0)));
      
      }
   }

   public static void testeCompareTo(String[] entrada, int numEntrada){
      
   
      for(int i = 0; i < numEntrada - 1; i+=2){
         System.out.println(Palavra.compareTo(entrada[i],
            	entrada[i+1]) + " " + Palavra.compareToIgnoreCase(entrada[i],entrada[i+1])); 
      }
   
      if(numEntrada % 2 == 1){
         System.out.println(Palavra.compareTo(entrada[numEntrada-1],
            	entrada[numEntrada-1]) + " "+ Palavra.compareToIgnoreCase(entrada  			                     [numEntrada-1],entrada[numEntrada-1])); 
      }
   }

   public static void testeContar(String[] entrada, int numEntrada){
   
      for(int i = 0; i < numEntrada; i++){
      
         System.out.println(Palavra.contarCaractere(entrada[i],entrada[i].charAt(0)) +                                              " " + Palavra.contarLetra(entrada[i])                         +                                              " " + Palavra.contarNaoLetra(entrada[i])                      +                                              " " + Palavra.contarDoidao(entrada[i]));                     
      }
   }
		

   public static void testeIs(String[] entrada, int numEntrada){
   
      for(int i = 0; i < numEntrada; i++){
      
         System.out.println(Palavra.isVogal(entrada[i]) +                                              " " + Palavra.isConsoante(entrada[i])                         +                                              " " + Palavra.isInteiro(entrada[i])                      +                                              " " + Palavra.isReal(entrada[i]));  
      }
   }

   public static void testeConversao(String[] entrada, int numEntrada){
   
      for(int i = 0; i < numEntrada; i++){
      
         System.out.println(Palavra.toUpper(entrada[i]));
         System.out.println(Palavra.toLower(entrada[i]));        
         System.out.println(Palavra.trim(entrada[i]));
         System.out.println(Palavra.trim(entrada[i],entrada[i].charAt(0)));  
      }
   }

		

   public static void main (String [] args){
   
      Palavra plv = new Palavra();
   
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
   	//testeReplaceAleatorio(entrada,numEntrada);//SAIDA DIFERENTE
           //testeCompareTo(entrada, numEntrada);
   	//testeContar(entrada, numEntrada);//CONFERIR SAIDA CONTARDOIDAO E CONTARLETRA
   	//testeIs(entrada,numEntrada);
      testeConversao(entrada,numEntrada); 
   }
}
                
                





	
